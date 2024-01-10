package src.java_solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InfectedBinaryTree {
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class InfectedBinaryTreeSolution {
    Map<Integer, TreeNode> map = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();
    int infectorValue;
    TreeNode infector;

    public int amountOfTime(TreeNode root, int start) {
        this.infectorValue = start;
        populateMapDFS(root);
        Set<TreeNode> startSet = new HashSet<>();
        startSet.add(infector);
        return bfs(0, startSet);
    }

    private void populateMapDFS(TreeNode node) {
        if (node.val == infectorValue) {
            this.infector = node;
        }
        if (node.left != null) {
            map.put(node.left.val, node);
            populateMapDFS(node.left);
        }
        if (node.right != null) {
            map.put(node.right.val, node);
            populateMapDFS(node.right);
        }
    }

    private int bfs(int pathLen, Set<TreeNode> currentNodes) {
        if (currentNodes.isEmpty()) {
            return pathLen;
        }

        visited.addAll(currentNodes);
        Set<TreeNode> destinations = new HashSet<>();
        currentNodes.forEach(node -> {
            if (node.left != null && !visited.contains(node.left)) {
                destinations.add(node.left);
            }
            if (node.right != null && !visited.contains(node.right)) {
                destinations.add(node.right);
            }
            if (map.containsKey(node.val) && !visited.contains(map.get(node.val))) {
                destinations.add(map.get(node.val));
            }
        });

        if (!destinations.isEmpty()) {
            return bfs(++pathLen, destinations);
        }
        return pathLen;
    }
}
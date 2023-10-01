package src.java_solutions;

import java.util.HashSet;

/**
 * 141. Linked List Cycle
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list
 * if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            HashSet<ListNode> visited = new HashSet<>();
            ListNode currentNode = head;

            while (currentNode != null) {
                visited.add(currentNode);
                currentNode = currentNode.next;
                if (visited.contains(currentNode)) {
                    return true;
                }
            }
            return false;
        }
    }
}

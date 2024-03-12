package src.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class RemoveZeroSumConsecutiveNodes {

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {
            List<ListNode> stack = new ArrayList<>();
            ListNode listNode = head;
            while (listNode != null) {
                int listNodeVal = listNode.val;
                if (listNodeVal == 0) {
                    listNode = listNode.next;
                    continue;
                }
                int prevNodesValSum = 0;
                boolean matchFound = false;
                for (int index = stack.size() - 1; index >= 0; index--) {
                    prevNodesValSum += stack.get(index).val;
                    if (prevNodesValSum + listNodeVal == 0) {
                        stack = stack.subList(0, index);
                        matchFound = true;
                        break;
                    }
                }
                if (!matchFound) {
                    stack.add(listNode);
                }
                listNode = listNode.next;
            }
            for (int index = 0; index < stack.size() - 1; index++) {
                stack.get(index).next = stack.get(index + 1);
            }
            if (!stack.isEmpty()) {
                stack.get(stack.size() - 1).next = null;
                return stack.get(0);
            }
            return null;
        }
    }
}

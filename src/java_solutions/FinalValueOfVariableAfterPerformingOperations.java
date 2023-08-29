package session9.homework.leetcode;

public class FinalValueOfVariableAfterPerformingOperations {

    /**
     * 2011. Final Value of Variable After Performing Operations
     * There is a programming language with only four operations and one variable X:
     * <p>
     * ++X and X++ increments the value of the variable X by 1.
     * --X and X-- decrements the value of the variable X by 1.
     * <p>
     * Initially, the value of X is 0.     *
     * Given an array of strings operations containing a list of operations,
     * return the final value of X after performing all the operations.
     */
    class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int answerValue = 0;
            for (String operation : operations) {
                if (operation.charAt(1) == '-') {
                    answerValue -= 1;
                } else {
                    answerValue += 1;
                }
            }
            return answerValue;
        }
    }
}

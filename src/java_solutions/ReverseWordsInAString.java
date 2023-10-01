package src.java_solutions;

public class ReverseWordsInAString {
    /**
     * Given a string s,
     * reverse the order of characters in each word within a sentence
     * while still preserving whitespace and initial word order.
     */
    class Solution {

        private static String reverseString(String input) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int index = input.length() - 1; index >= 0; index--) {
                stringBuilder.append(input.charAt(index));
            }
            return stringBuilder.toString();
        }

        public String reverseWords(String s) {

            StringBuilder sb = new StringBuilder();
            for (String word : s.split(" ")) {
                sb.append(reverseString(word + " "));
            }
            return sb.toString().trim();
        }
    }
}

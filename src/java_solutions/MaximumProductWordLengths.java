package session9.homework.leetcode;

public class MaximumProductWordLengths {

    /**
     * 318. Maximum Product of Word Lengths
     * Given a string array words,
     * return the maximum value of length(word[i]) * length(word[j])
     * where the two words do not share common letters.
     * no such two words exist, return 0.
     */
    class Solution {
        public int maxProduct(String[] words) {
            int wordsArrayLength = words.length;
            String[] wordsWithUniqueLetters = new String[wordsArrayLength];
            for (int index = 0; index < wordsArrayLength; index++) {
                wordsWithUniqueLetters[index] = getUniqueLetters(words[index]);
            }
            int answer = 0;
            for (int indexFirstWord = 0; indexFirstWord < wordsArrayLength; indexFirstWord++) {
                for (int indexSecondWord = indexFirstWord + 1; indexSecondWord < wordsArrayLength;
                     indexSecondWord++) {
                    if (haveNoCommonLetters(wordsWithUniqueLetters[indexFirstWord],
                            wordsWithUniqueLetters[indexSecondWord])) {
                        answer = Math.max(words[indexFirstWord].length() * words[indexSecondWord].length(), answer);
                    }
                }
            }
            return answer;
        }

        private String getUniqueLetters(String input) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int index = 0; index < input.length(); index++) {
                if (stringBuilder.toString().indexOf(input.charAt(index)) < 0) {
                    stringBuilder.append(input.charAt(index));
                }
            }
            return stringBuilder.toString();
        }

        private boolean haveNoCommonLetters(String wordOne, String wordTwo) {
            for (int indexWordOne = 0; indexWordOne < wordOne.length(); indexWordOne++) {
                for (int indexWordTwo = 0; indexWordTwo < wordTwo.length(); indexWordTwo++) {
                    if (wordOne.charAt(indexWordOne) == wordTwo.charAt(indexWordTwo)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /*     What is this?
        private int getStateFromString(String s){
            int state=0;
            for(char c:s.toCharArray()){
                int index=c-'a';
                state|=1<<(index);
            }
            return state;
        }
    */
}

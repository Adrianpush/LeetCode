package session9.homework.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {

    /**
     * 500. Keyboard Row
     * Given an array of strings words,
     * return the words that can be typed
     * using letters of the alphabet on only one row of American keyboard.
     * *
     * In the American keyboard:
     * the first row consists of the characters "qwertyuiop",
     * the second row consists of the characters "asdfghjkl", and
     * the third row consists of the characters "zxcvbnm".
     */
    class Solution {
        public String[] findWords(String[] words) {
            List<String> wordsTypedOnSingleKeyboardRow = new ArrayList<>();
            for (String word : words) {
                if (allLettersOnSingleKeyboardRow(word.toLowerCase())) {
                    wordsTypedOnSingleKeyboardRow.add(word);
                }
            }
            String[] wordsOnSingleKeyboardRow = new String[wordsTypedOnSingleKeyboardRow.size()];
            for (int index = 0; index < wordsTypedOnSingleKeyboardRow.size(); index++) {
                wordsOnSingleKeyboardRow[index] = wordsTypedOnSingleKeyboardRow.get(index);
            }
            return wordsOnSingleKeyboardRow;
        }

        private boolean allLettersOnSingleKeyboardRow(String word) {
            String[] keyBoardRows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
            String chosenRow = "";
            for (int index = 0; index < keyBoardRows.length; index++) {
                if (keyBoardRows[index].indexOf(word.charAt(0)) != -1) {
                    chosenRow = keyBoardRows[index];
                    break;
                }
            }
            for (int index = 1; index < word.length(); index++) {
                if (chosenRow.indexOf(word.charAt(index)) == -1) {
                    return false;
                }
            }
            return true;
        }
    }
}

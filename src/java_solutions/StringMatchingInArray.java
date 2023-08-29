package session9.homework.leetcode;

import java.util.ArrayList;
import java.util.List;

public class StringMatchingInArray {

    /**
     * 1408. String Matching in an Array
     * Given an array of string words,
     * return all strings in words that is a substring of another word.
     * You can return the answer in any order.     *
     * A substring is a contiguous sequence of characters within a string
     */
    class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> substringsOfOtherWords = new ArrayList<>();
            for (int indexWordOne = 0; indexWordOne < words.length; indexWordOne++) {
                for (int indexWordTwo = 0; indexWordTwo < words.length; indexWordTwo++) {
                    if (indexWordOne != indexWordTwo &&
                            words[indexWordTwo].contains(words[indexWordOne])) {
                        substringsOfOtherWords.add(words[indexWordOne]);
                        break;
                    }
                }
            }
            return substringsOfOtherWords;
        }
    }
}

package src.java_solutions;

import java.util.*;

public class ExtraCharactersInString {

    public static void main(String[] args) {
        String input = "eglglxa";
        String[] dict = {"rs","j","h","g","fy","l","fc","s","zf","i","k","x","gl","qr","qj",
                "b","m","cm","pe","y","ei","wg","e","c","ll","u","lb","kc",
                "r","gs","p","ga","pq","o","wq","mp","ms","vp","kg","cu"};

        HashMap<Integer, Integer> cache = new HashMap<>();
        cache.put(input.length(), 0);

        HashSet<String> stringsSet = new HashSet<>(List.of(dict));
        System.out.println("result " + solveDFS(0, cache, stringsSet, input));
    }

    public static int solveDFS(int index, HashMap<Integer, Integer> cache, HashSet<String> set, String string) {

        if (cache.containsKey(index)){
            return cache.get(index);
        }
        int result = 1 + solveDFS(index + 1, cache, set, string);

        for (int substringIndex = index; substringIndex < string.length(); substringIndex++) {
            String currentSubstring = string.substring(index, substringIndex + 1);
            if (set.contains(currentSubstring)) {
                result = Math.min(result, solveDFS(substringIndex + 1, cache, set, string));

            }
        }
        cache.put(index, result);
        return result;
    }







    /**
     * You are given a 0-indexed string s and a dictionary of words dictionary.
     * You have to break s into one or more non-overlapping substrings
     * such that each substring is present in dictionary.
     * There may be some extra characters in s which are not present in any of the substrings.     *
     * Return the minimum number of extra characters left over if you break up s optimally.
     */

    class Solution {

    }
}

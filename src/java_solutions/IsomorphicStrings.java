package src.java_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IsomorphicStrings {

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, List<Integer>> wordOneCharCounter = new HashMap<>();
            Map<Character, List<Integer>> wordTwoCharCounter = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (wordOneCharCounter.containsKey(s.charAt(i))) {
                    wordOneCharCounter.get(s.charAt(i)).add(i);
                } else {
                    wordOneCharCounter.put(s.charAt(i), new ArrayList<>());
                    wordOneCharCounter.get(s.charAt(i)).add(i);
                }
                if (wordTwoCharCounter.containsKey(t.charAt(i))) {
                    wordTwoCharCounter.get(t.charAt(i)).add(i);
                } else {
                    wordTwoCharCounter.put(t.charAt(i), new ArrayList<>());
                    wordTwoCharCounter.get(t.charAt(i)).add(i);
                }
            }

            return wordOneCharCounter.values().stream()
                    .filter(list -> list.size() > 1)
                    .collect(Collectors.toSet())
                    .equals(wordTwoCharCounter.values().stream().filter(list -> list.size() > 1).collect(Collectors.toSet()));
        }
    }
}

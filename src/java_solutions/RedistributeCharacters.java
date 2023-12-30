package src.java_solutions;

import java.util.Arrays;

public class RedistributeCharacters {

    public static void main(String[] args) {
        String[] words = {"hello", "hellzllo"};
        int[] chars = new int[26];

        Arrays.stream(words)
                .flatMapToInt(String::chars)
                .forEach(number -> chars[number - 'a'] += 1);

        System.out.println(Arrays.stream(chars)
                .noneMatch(frequency -> frequency % words.length != 0));
    }
}

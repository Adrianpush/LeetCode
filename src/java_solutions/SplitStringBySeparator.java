package src.java_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitStringBySeparator {

    public static List<String> splitStrings(List<String> words, char separator) {
        return words.stream()
                .flatMap(word -> Arrays.stream(word.split(String.valueOf(separator))))
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("hello-world", "foo-bar", "abc-def"));
        char separator = '-';

        List<String> result = splitStrings(words, separator);

        for (String str : result) {
            System.out.println(str);
        }
    }
}



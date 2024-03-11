package src.java_solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomSorter {

    public String customSortString(String order, String s) {
        List<Character> list = new ArrayList<>();
        for (char character : s.toCharArray()) {
            list.add(character);
        }
        list.sort(Comparator.comparingInt(order::indexOf));
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : list) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}

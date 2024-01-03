package src.java_solutions;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertArrTo2D {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 5, 5, 6};
        Map<Integer, Long> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(
                        i -> i,
                        TreeMap::new,
                        Collectors.counting()
                ));

        List<List<Integer>> answer = new ArrayList<>();
        boolean fin = false;
        while (!fin) {
            List<Integer> currentRow = new ArrayList<>();
            fin = true;
            for (Integer key : map.keySet()) {
                if (map.get(key) > 0) {
                    currentRow.add(key);
                    map.put(key, map.get(key) - 1);
                    fin = false;
                }
            }
            if (!currentRow.isEmpty()) answer.add(currentRow);
        }
    }
}

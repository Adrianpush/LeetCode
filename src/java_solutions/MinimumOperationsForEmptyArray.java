package src.java_solutions;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumOperationsForEmptyArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3};
        Collection<Long> frequencies = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(
                        i -> i,
                        HashMap::new,
                        Collectors.counting()
                )).values();

        int totalMoves = 0;
        for (Long frequency :frequencies) {
            if (frequency < 2) {
                //return -1;
            } else if (frequency.intValue() % 3 == 0) {
                totalMoves += frequency.intValue() / 3;
            } else {
                totalMoves += frequency.intValue() / 3 + 1;
            }
        }
    }

}

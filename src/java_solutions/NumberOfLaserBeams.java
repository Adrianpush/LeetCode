package src.java_solutions;

import java.util.Arrays;

public class NumberOfLaserBeams {

    public int numberOfBeams(String[] bank) {

        final int[] lastUsed = new int[1];

        return Arrays.stream(bank)
                .map(string -> string.chars()
                        .filter(ch -> ch == '1')
                        .count())
                .mapToInt(Long::intValue)
                .reduce(0, (acc, rowCount) -> {
                    int toBeAdded = lastUsed[0] * rowCount;
                    lastUsed[0] = rowCount > 0 ? rowCount : lastUsed[0];
                    return acc + toBeAdded;
                });
    }
}

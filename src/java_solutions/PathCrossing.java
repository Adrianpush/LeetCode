package src.java_solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isPathCrossing(String path) {

        Set<int[]> history = new HashSet<>();
        int[] previousCoords = {0,0};
        history.add(previousCoords);

        for (int index = 0; index < path.length(); index++) {
            int[] currentCoords = getUpdatedCoords(previousCoords, path.charAt(index));
            if (history.stream().anyMatch(prevLocation -> Arrays.equals(prevLocation, currentCoords))) {
                return true;
            }
            history.add(currentCoords);
            previousCoords = currentCoords;
        }
        return false;
    }

    private int[] getUpdatedCoords(int[] currentLocation, char direction) {
        int [] updatedLocation = {currentLocation[0], currentLocation[1]};
        switch (direction) {
            case 'N' -> updatedLocation[0] += 1;
            case 'S' -> updatedLocation[0] -= 1;
            case 'E' -> updatedLocation[1] += 1;
            case 'W' -> updatedLocation[1] -= 1;
        }
        return updatedLocation;
    }
}

package src.java_solutions;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    private int[][] cache;
    private int[] nums;

    public int lengthOfLIS(int[] nums) {
        int newSize = nums.length + 1;
        int[] newArray = new int[newSize];
        System.arraycopy(nums, 0, newArray, 0, nums.length);
        newArray[newSize - 1] = Integer.MIN_VALUE;
        this.nums = newArray;

        cache = new int[this.nums.length][this.nums.length];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return getLongestIncrSubsequence(0, newSize - 1);
    }

    private int getLongestIncrSubsequence(int index, int currentMaxIndex) {

        if (index >= nums.length) {
            return 0;
        }
        if (cache[currentMaxIndex][index] != -1) {
            return cache[currentMaxIndex][index];
        }

        int take = 0;
        int dontTake = getLongestIncrSubsequence(index + 1, currentMaxIndex);

        if (nums[index] > nums[currentMaxIndex]) {
            take = Math.max(
                    dontTake,
                    1 + getLongestIncrSubsequence(index + 1, index));
        }
        cache[currentMaxIndex][index] = Math.max(take, dontTake);
        return cache[currentMaxIndex][index];
    }
}
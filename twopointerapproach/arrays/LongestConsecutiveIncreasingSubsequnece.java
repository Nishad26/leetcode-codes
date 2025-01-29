package arrays;

import java.util.HashMap;
//QUESTION :- https://www.geeksforgeeks.org/longest-increasing-consecutive-subsequence/?ref=lbp

public class LongestConsecutiveIncreasingSubsequnece {
    public static void main(String[] args) {
        System.out.println(longestIncreaseingConsecutiveSubsequence(new int[] { 3, 7, 17, 33, 4 }));
    }

    public static int longestIncreaseingConsecutiveSubsequence(int nums[]) {
        int maxLength = 0;
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int i : nums) {
            if (count.containsKey(i - 1)) {
                int currLength = count.get(i - 1);
                if (currLength + 1 > maxLength) {
                    maxLength = currLength + 1;
                }
                count.putIfAbsent(i, currLength + 1);
            } else {
                count.putIfAbsent(i, 1);
            }
        }
        return maxLength;

    }
}

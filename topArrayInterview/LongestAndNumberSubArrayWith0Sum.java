package topArrayInterview;

import java.util.HashMap;

public class LongestAndNumberSubArrayWith0Sum {

    public static void main(String[] args) {
        int[] arr = { 3, -3, 0, 0 };
        System.out.println(maxNumberOfSubArrayHavingSum0(arr));
    }

    static int maxLen(int[] arr) {

        // Map to store the previous sums
        HashMap<Integer, Integer> presum = new HashMap<>();

        int sum = 0;
        int max_len = 0;

        // Traverse through the given array
        for (int j = 0; j < arr.length; j++) {

            // Add current element to sum
            sum += arr[j];

            // If the sum is 0, update max_len
            if (sum == 0) {
                max_len = j + 1;
            }

            // Check if this sum is seen before
            // Here we will put always first occurace of the prefix sum as we want the
            // longest array
            if (presum.containsKey(sum)) {

                // If this sum is seen before, update
                // max_len
                max_len = Math.max(max_len,
                        j - presum.get(sum));
            } else {

                // If this sum is not seen before, add it to
                // the map
                presum.put(sum, j);
            }
        }

        return max_len;
    }

    static int maxNumberOfSubArrayHavingSum0(int[] arr) {

        x
    }
}

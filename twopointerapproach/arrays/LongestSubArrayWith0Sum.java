package arrays;

import java.util.HashMap;
//think of prefix sum array 
//The idea is based on the observation that for two different indices i and j (where j > i) if 
//the prefix sums Sum i and Sum j are equal, it means that the sum of the elements between 
//indices i+1 and j is zero. 

/*
    Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23}
    Output: 5
    Explanation: The longest subarray with sum equals to 0 is {-2, 2, -8, 1, 7}
 */
public class LongestSubArrayWith0Sum {
    // Function to return the length of the largest
    // subarray with sum 0
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

    static int maxLenAndPrintingTheLongestArrayHaving0Sum(int[] arr) {
        // Map to store the previous sums
        HashMap<Integer, Integer> presum = new HashMap<>();

        int sum = 0;
        int max_len = 0;
        int start = -1; // To track the starting index of the subarray

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum
            sum += arr[i];

            // If the sum is 0, update max_len and start index
            if (sum == 0) {
                max_len = i + 1;
                start = 0; // Subarray starts from the beginning
            }

            // Check if this sum is seen before
            if (presum.containsKey(sum)) {
                // If this sum is seen before, update max_len and start index
                if (max_len < i - presum.get(sum)) {
                    max_len = i - presum.get(sum);
                    start = presum.get(sum) + 1;
                }
            } else {
                // If this sum is not seen before, add it to the map
                presum.put(sum, i);
            }
        }
        // If we found a subarray, print it
        if (start != -1) {
            System.out.print("The longest subarray with 0 sum is: ");
            for (int i = start; i < start + max_len; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("No subarray with 0 sum found.");
        }

        return max_len;
    }

    public static void main(String[] args) {
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(maxLen(arr));
    }
}

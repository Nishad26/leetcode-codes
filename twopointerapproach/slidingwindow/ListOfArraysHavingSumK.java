package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfArraysHavingSumK {
    // Function to find subarrays of size 3 that sum up to the target
    public static List<int[]> findSubarraysWithSum(int[] arr, int targetSum) {
        List<int[]> result = new ArrayList<>();
        int windowSum = 0;

        // Check if the array has at least 3 elements
        if (arr.length < 3) {
            return result; // Return an empty list if the array is too small
        }

        // Calculate the sum of the first window (first 3 elements)
        for (int i = 0; i < 3; i++) {
            windowSum += arr[i];
        }

        // Sliding window starts here
        for (int i = 3; i <= arr.length; i++) {
            // If current window sum equals the target, add the subarray to the result
            if (windowSum == targetSum) {
                int[] subarray = new int[3];
                for (int j = 0; j < 3; j++) {
                    subarray[j] = arr[i - 3 + j];
                }
                result.add(subarray);
            }

            // Slide the window: remove the element that is going out of the window and add
            // the next element
            if (i < arr.length) {
                windowSum = windowSum - arr[i - 3] + arr[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 1, 2, 3, 0, 5, -1, 6 };
        int targetSum = 5;

        List<int[]> subarrays = findSubarraysWithSum(arr, targetSum);

        if (subarrays.isEmpty()) {
            System.out.println("No subarray found with sum = " + targetSum);
        } else {
            System.out.println("Subarrays of size 3 with sum = " + targetSum + ":");
            for (int[] subarray : subarrays) {
                System.out.println(Arrays.toString(subarray));
            }
        }
    }
}

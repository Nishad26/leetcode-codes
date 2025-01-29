package topArrayInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Find from left to right , longest increasing suvsequnce
//then start iterating from the end of the array and find again longest increasing subsequce
//store it in different array

public class LongestBioTonicSequence {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 11, 40, 5, 3, 1));

        System.out.println(LongestBitonicSequence(arr));
    }

    // Function to find the longest bitonic subsequence
    static int LongestBitonicSequence(ArrayList<Integer> arr) {
        int n = arr.size();

        // If there are less than 3 elements,
        // no bitonic subsequence exists
        if (n < 3)
            return 0;

        // Create ArrayLists for longest increasing subsequence
        // (LIS) and longest decreasing subsequence (LDS)
        ArrayList<Integer> left = new ArrayList<>(Collections.nCopies(n, 1));

        ArrayList<Integer> right = new ArrayList<>(Collections.nCopies(n, 1));

        // Fill left ArrayList for LIS
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                // If arr[i] is greater than arr[j],
                // update LIS value at i
                if (arr.get(i) > arr.get(j)) {
                    left.set(i, Math.max(left.get(i),
                            left.get(j) + 1));
                }
            }
        }

        // Fill right ArrayList for LDS
        for (int i = n - 2; i >= 0; i--) {

            // Compare each element with subsequent
            // ones to build LDS
            for (int j = n - 1; j > i; j--) {

                // If arr[i] is greater than arr[j],
                // update LDS value at i
                if (arr.get(i) > arr.get(j)) {
                    right.set(i, Math.max(right.get(i),
                            right.get(j) + 1));
                }
            }
        }

        // Calculate the maximum length of bitonic subsequence
        int maxLength = 0;
        for (int i = 0; i < n; i++) {

            // Check if both LIS and LDS are valid
            // for the current index
            if (left.get(i) > 1 && right.get(i) > 1) {

                // Update maxLength considering both LIS
                // and LDS, subtracting 1 for the peak element
                maxLength = Math.max(maxLength,
                        left.get(i) + right.get(i) - 1);
            }
        }

        // If no valid bitonic sequence, return 0
        return maxLength < 3 ? 0 : maxLength;
    }
}

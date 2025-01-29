package topArrayInterview;

/*
 * problem:- https://www.geeksforgeeks.org/number-subarrays-sum-less-k/
 * Given an array of non-negative numbers and a non-negative number k, 
 * find the number of subarrays having sum less than k. We may assume that there is no overflow.
 */
public class NumberOfSubArraysHavingSumLessThanK {
    public static void main(String[] args) {
        int[] arr = { 1, 11, 2, 15 };
        System.out.println(numberOfSubArraysHavingSumLessThanK(arr, 15));
    }

    static int numberOfSubArraysHavingSumLessThanK(int[] arr, int k) {

        int i = 0;
        int j = 0;
        int count = 0;
        // Prefix sum calculation
        for (int l = 1; l < arr.length; l++) {
            arr[l] += arr[l - 1];
        }
        while (j < arr.length) {

            // if the prefix sum is less than k ,take all subarrays (including i)
            if (arr[j] < k) {
                count += (j - i + 1);
                j++;
                continue;
            }
            // check if the array from i+1 to j is less than k, if so number of subarrays
            // will be j-i
            if (arr[j] - arr[i] < k) {
                count += (j - i);
                j++;
            }
            // bring i to point where sum is less
            else {
                while (i <= j && arr[j] - arr[i] >= k) {
                    i++;
                }
            }

        }

        return count;
    }
}

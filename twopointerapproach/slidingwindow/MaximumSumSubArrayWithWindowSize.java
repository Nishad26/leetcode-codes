package slidingwindow;

/**
 * MaximumSumSubArray
 * Follow this pattern
 */
public class MaximumSumSubArrayWithWindowSize {

    public static int maximumSumSubArray(int[] arr, int windowSize) {
        if (arr.length < windowSize || windowSize <= 0) {
            throw new IllegalArgumentException("Invalid window size");
        }

        int j = 0;
        int i = 0;
        int maxSum = 0;
        int sum = 0;
        while (j < arr.length) {
            sum += arr[j];

            if (j - i + 1 > windowSize) {
                sum = sum - arr[i];
                i++;
            }
            if (j - i + 1 == windowSize) {
                maxSum = Math.max(sum, maxSum);
            }
            j++;
        }
        return maxSum;
    }

}
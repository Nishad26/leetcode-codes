package arrays;

/*
 * https://www.youtube.com/watch?v=AHZpyENo7k4 --uoutube
 * 
 */
public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] arr = { -100, -1, -2, -1, -4, -1, -7, -10 };
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        if (nums[0] > 0) {
            sum = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            sum = sum + nums[i];

            if (sum > maxSum) {
                maxSum = sum;
            }

            if (sum < 0) {

                if (nums[i] > maxSum) {
                    maxSum = nums[i];
                }

                sum = 0;
            }
        }
        return maxSum;
    }
}

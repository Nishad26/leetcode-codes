package arrays;

//Find the largest pair sum in an array of distinct integers.
//In O(N) without using any extra space
public class LargestPairSumInArray {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(pairsum(new int[] { 4, 3, 6, 2, 1, 1 }));
    }

    public static int pairsum(int[] arr) {
        if (arr.length < 2) {
            return -1;
        }
        int max = Math.max(arr[0], arr[1]);
        int maxSum = arr[0] + arr[1];

        for (int j = 2; j < arr.length; j++) {
            if (max + arr[j] > maxSum) {
                maxSum = max + arr[j];
            }
            if (arr[j] > max) {
                max = arr[j];
            }
        }

        return maxSum;

    }
}

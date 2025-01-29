package arrays;

import java.util.Arrays;

public class NumberOfSubSequeceThatSatisfyCondition_1498 {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        int[] arr = { 3, 5, 6, 7 };
        System.out.println(numberOfSubSequenceThatSatisfyGivenSum(arr, 10));
    }

    // binary exponentitaion
    // Function to calculate the power of a number (a) raised to the power of b
    // modulo mod
    public static long power(long a, long b) {
        long result = 1;
        while (b > 0) {
            // If the current bit of b is set, multiply the result by a
            if ((b & 1) == 1) { // if it is odd
                result = (result * a) % mod;
                b--;
            } else {
                // Square the value of a and reduce it modulo mod
                a = (a * a) % mod;
                b = b / 2;
            }
        }
        return result;
    }

    public static int numberOfSubSequenceThatSatisfyGivenSum(int[] arr, int k) {

        int res = 0;
        Arrays.sort(arr);

        for (int i = 0, j = arr.length - 1; i <= j; ++i) {
            while (j >= i && arr[i] + arr[j] > k) {
                j--;
            }
            if (j >= i) {
                // here insted of normal power you can call the binary exponentaytiation
                // operator
                int possibilities = (int) Math.pow(2, j - i);
                res = res + possibilities;
            }

        }
        return res;
    }
}

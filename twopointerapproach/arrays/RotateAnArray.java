package arrays;

public class RotateAnArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;

        rotate(arr, k);

        // Print the rotated array
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void rotate(int arr[], int k) {
        int n = arr.length;
        // If k is greater than array length, reduce it (as rotating by n is same as
        // rotating by 0)
        k = k % n;

        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - k - 1);
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            // Swap elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

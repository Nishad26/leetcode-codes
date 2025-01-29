package recursionandbacktracking;

public class SubSetSumEqualsK {
    public static void main(String[] args) {
        System.out.println(subsetSumEqulalK(new int[] { 2, 7, 8, 10, 11 }, 11, 5));
    }

    public static boolean subsetSumEqulalK(int arr[], int sum, int n) {
        if (sum == 0) {
            return true;
        }
        if (sum != 0 && n == 0) {
            return false;
        }
        if (arr[n - 1] <= sum) {
            return subsetSumEqulalK(arr, sum - arr[n - 1], n - 1) || subsetSumEqulalK(arr, sum, n - 1);
        } else {
            return subsetSumEqulalK(arr, sum, n - 1);
        }
    }
}
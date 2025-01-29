package prefixSumAlgo;

public class RangeSumQuery {
    public static void main(String[] args) {
        System.out.println(rangeSumQuery(new int[] { 1, 2, 3, 4, 5 }, 0, 2));
    }

    public static long rangeSumQuery(int arr[], int i, int j) {
        for (int k = 1; k < arr.length; k++) {
            arr[k] = arr[k - 1] + arr[k];
        }

        return arr[j] - (i - 1 < 0 ? 0 : arr[i - 1]);
    }
}

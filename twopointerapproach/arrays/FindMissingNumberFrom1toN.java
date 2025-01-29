package arrays;

public class FindMissingNumberFrom1toN {

    public static void main(String[] args) {
        findMissingNumberFrom1toN(new int[] { 1, 2, 3, 5, 6, 7 }, 7);
    }

    // another approach is to use the formula (n*n+1)/2== sum of first n natural
    // numers
    // subtract it with sum of array elemts and you are done
    // n is nothing but the length of the array
    // This is xor approach
    public static int findMissingNumberFrom1toN(int arr[], int n) {

        int xorOfArray = 0;
        for (int i : arr) {
            xorOfArray = xorOfArray ^ i;
        }
        for (int i = 1; i <= n; i++) {
            xorOfArray = xorOfArray ^ i;
        }
        return xorOfArray;
    }
}

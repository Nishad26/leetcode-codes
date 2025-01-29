package topArrayInterview;

/*
 * inc = Length of longest alternative subsequence so far with current value being greater than it’s previous value.
dec = Length of longest alternative subsequence so far with current value being smaller than it’s previous value.
The tricky part of this approach is to update these two values. 


“inc” should be increased, if and only if the last element in the alternative sequence was smaller than it’s previous element.
“dec” should be increased, if and only if the last element in the alternative sequence was greater than it’s previous element.
 */
public class LongestAlternatingSubSequence {

    // Driver Code
    public static void main(String[] args) {
        int[] arr = { 10, 22, 9, 33, 49, 50, 31, 60 };
        int n = arr.length;

        // Function Call
        System.out.println(LAS(arr, n));
    }

    public static int LAS(int[] arr, int n) {

        // "inc" and "dec" initialized as 1,
        // as single element is still LAS
        int inc = 1;
        int dec = 1;

        // Iterate from second element
        for (int i = 1; i < n; i++) {

            if (arr[i] > arr[i - 1]) {
                // "inc" changes if "dec"
                // changes
                inc = dec + 1;
            } else if (arr[i] < arr[i - 1]) {

                // "dec" changes if "inc"
                // changes
                dec = inc + 1;
            }
        }

        // Return the maximum length
        return Math.max(inc, dec);
    }

}

package arrays;
/*
 * Given an array of integers, the task is to find the maximum absolute difference between the 
 * nearest left and the right smaller element of every element in the array. 

    Note: If there is no smaller element on right side or left side of any 
    element then we take zero as the smaller element. For example for the leftmost element,
    the nearest smaller element on the left side is considered as 0. Similarly, for rightmost elements, 
    the smaller element on the right side is considered as 0.
    eg:-
    Input  : arr[] = {2, 4, 2, 7, 7, 9, 3} {3,9,7,7,2,4,2} {}
Output : 4
Left smaller   LS[] = {0, 2, 4, 4, 4, 7, 2}
Right smaller  RS[] = {0, 3, 3, 3, 0, 2, 0}
Maximum Diff of abs(LS[i] - RS[n - 1 - i]) = 7 - 3 = 4 

 */

import java.util.Stack;

public class LeftSmallerRightSmaller {

    public static void leftSmaller(int arr[], int leftSmaller[]) {
        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            // Keep removing top element from S while the top
            // element is greater than or equal to arr[i]
            while (!S.empty() && S.peek() >= arr[i]) {
                S.pop();
            }

            // Store the smaller element of current element
            if (!S.empty()) {
                leftSmaller[i] = S.peek();
            }
            // If all elements in S were greater than arr[i]
            else {
                leftSmaller[i] = 0;
            }

            // Push this element
            S.push(arr[i]);
        }
    }

    // Function returns maximum difference b/w Left &
    // right smaller element
    public static int findMaxDiff(int arr[], int n) {
        int[] LS = new int[n]; // To store left smaller elements

        // find left smaller element of every element
        leftSmaller(arr, LS);

        // find right smaller element of every element
        // first reverse the array and do the same process
        int[] RRS = new int[n]; // To store right smaller elements in

        // reverse array
        reverse(arr);
        leftSmaller(arr, RRS);

        // find maximum absolute difference b/w LS & RRS
        // In the reversed array right smaller for arr[i] is
        // stored at RRS[n-i-1]
        int result = -1;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, Math.abs(LS[i] - RRS[n - 1 - i]));
        }

        // return maximum difference b/w LS & RRS
        return result;
    }

    public static void reverse(int a[]) {
        int i, n = a.length;
        int t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }
}

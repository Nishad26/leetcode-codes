package arrays;

import java.util.Arrays;

/*
 * problem url :- https://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights/
 * Given the heights of n towers and a positive integer k, increase or decrease the height of
 * all towers by k (only once). After modifications, the task is to 
 * find the minimum difference between the heights of the tallest and the shortest tower
 * 
 * Condition one :- you have to add or subrtact from each elemt (this is must)
 * Condition 2:- by subtracting the hight should not be negative
 * 
 * Here the thinking is , array sort kaar , then the difference between maximum ele ands minimum ele kaad,
 * this will give you your maximum difference, and you have to minimize this difference somehow
 * Logically what you will always do is, tu chotya value madhe kaay tari add karanar, and mothya
 * value madhun kaay taari subtract karanr , hyane kaay hoil , tuza smallest ele and largest ele cha 
 * difference kami hoil and you will get your answer
 * 
 * Observation :- 1. from the smaller elemts (chote elemts) you will never subtract, this will keep
 * your difference same (if you subtract from max) or increase your difference if you add to max.
 * Hence it makes no sense to subtract from chote elemts . Thats why you will always add k upto 
 * index i and after index i you will always subtract.Since you want to decrease the range   
 * solution video :- https://www.youtube.com/watch?v=I6_fYaR17gk
 */
public class MinimizeMaximumDifferenceBetweenHeights {

    public static void main(String[] args) {
        int k = 6;
        int[] arr = { 12, 6, 4, 15, 17, 10 };

        int ans = getMinDiff(arr, k);
        System.out.println(ans);
    }

    static int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        // if we add k to all the elemts or subtract k from all the elements, the result
        // will be as
        // shown below, that is the maximum elemts - the minimum elemts as the array is
        // sorted it is
        // the first and last elemt
        int res = arr[n - 1] - arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - k < 0) {
                continue;
            }
            // minimum elemnt in the transformed array can be eighter the 1st elemt or the
            // i+1 th elemt
            int min = Math.min(arr[0] + k, arr[i + 1] - k);
            // maximum ekemt can be eigther the last elemnt in the array or the ith elents
            // as we are adding k in the ith elemt it can be more than the last elemt
            // (maximun elemt
            // wherein we will be subtracting k from)
            // in the array
            int max = Math.max(arr[n - 1] - k, arr[i] + k);

            res = Math.min(res, max - min);

        }
        return res;

    }
}

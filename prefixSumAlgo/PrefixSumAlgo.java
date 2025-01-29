package prefixSumAlgo;

/**
 * Suppose tula sangitla find the sum of numbers between index 0 to 5, you will usually do a for loop 
 * between 0 to 5 (O(n))
 * now for 2 to 5 same agin O(n)...and so on 
 * So now if we want to find the sum m time then total complexity will be O(m*n) (worst case)
 * So hya alogoirtm ne phakta tula pahila ekda O(n) use karun ek prefix sum array banavayala lagel
 * Then no need to run for loop again
 *    
*/
import java.util.*;

public class PrefixSumAlgo {

    public static void main(String[] args) {
        int prefixSumArr[] = prefixSumArray(new int[] { 5, 6, 7, 3, 2 });
        System.out.println(Arrays.toString(prefixSumArr));
        // Sum between 2 to 5
        System.out.println(prefixSumArr[4] - prefixSumArr[0]);
        // Sum between 3 to 5
        System.out.println(prefixSumArr[4] - prefixSumArr[1]);
    }

    public static int[] prefixSumArray(int nums[]) {
        int prefixSumArray[] = new int[nums.length];

        prefixSumArray[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSumArray[i] = nums[i] + nums[i - 1];
        }
        return prefixSumArray;

    }
}
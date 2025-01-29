// 442. Find All Duplicates in an Array
//FindDuplicatesInAnArray solution to this will not workl here
//Here the constraint is that
/*
 * 1.The array will have 1 to n numbers only and the array will be of sinze n
 * 2. Each elemts is only repaeated twice not more than that (tahts why this approach works)
 */

//But if we make the result type as set we can repeate it any number of times
/*
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] 
 * and each integer 
 * appears at most twice, return an array of all the integers that appears twice.
 */

//FindDuplicatesInAnArray this solution will not work as 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicatesInAnArrayAnother {
  public static void main(String args[]) {
    int arr[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
    int arr_size = arr.length;

    System.out.println("The repeating elements are: ");

    // Function call
    System.out.println(findDuplicates(arr, arr_size));
  }

  public static Set<Integer> findDuplicates(int[] nums, int size) {
    Set<Integer> ans = new HashSet<Integer>();

    for (int i = 0; i < nums.length; i++) {
      // Get the index the elemt corresponds to
      int index = Math.abs(nums[i]) - 1;

      // if the number is negative it meanse we have already encountered it and we are
      // encopuntering it twice
      if (nums[index] < 0) {
        ans.add(index + 1);
      }

      nums[index] = nums[index] * -1;
    }
    return ans;
  }
}

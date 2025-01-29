package topArrayInterview;

import java.util.HashSet;
import java.util.Set;

//Here the constraint is that
/*
 * 1.The array will have 1 to n numbers only and the array will be of sinze n or more than n
 */
public class FindDuplicatesInArrayHaving0tonelemts {
    public static void main(String args[]) {
        int arr[] = { 4, 3, 2, 7, 8, 2, 3, 1, 8, 8 };
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
                continue;
            }

            nums[index] = nums[index] * -1;
        }
        return ans;
    }
}

package arrays;
/*
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] 
 * inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.
 */

/*
 * So here we can use the conecpt of fast and slow pointers similar to the linked list
 * This can only work as there are only elemts upto n (1 to n) and 
 * There is only one reparted elemts  (mutiple times)
 */
public class FindDuplicateNumberInArray_287 {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

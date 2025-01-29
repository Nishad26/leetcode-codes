package topArrayInterview;

public class MoveZerosToEnd {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;

        while (j < nums.length) {

            if (nums[j] == 0) {
                j++;
                continue;
            }
            nums[i++] = nums[j++];
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}

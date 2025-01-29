package arrays;

class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;

        while (j <= nums.length - 1) {
            if (nums[i] != val) {
                i++;
                j++;
                continue;
            }
            if (nums[i] == val && nums[j] != val) {
                nums[i] = nums[j];
                nums[j] = val;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i;
    }

    public int anotherRemoveElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length;

        while (j > i) {
            if (nums[i] == val) {
                nums[i] = nums[j - 1];
                j = j - 1;
            } else {
                i++;
            }
        }
        return j;

    }
}
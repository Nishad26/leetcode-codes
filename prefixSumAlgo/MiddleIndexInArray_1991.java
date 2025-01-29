package prefixSumAlgo;
/*
 * A middleIndex is an index where 
 * nums[0] + nums[1] + ... + nums[middleIndex-1] == 
 * nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1].
 */
public class MiddleIndexInArray_1991 {
    public int findMiddleIndex(int[] nums) {
        int prefixSum[] = new int[nums.length];
        // find prefix sum
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int total = prefixSum[nums.length - 1];

        //edge case : if the middleindex is at array index 0
        if (0 == total - prefixSum[0]) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int j = prefixSum.length - 1; j > 0; j--) {
            if (prefixSum[j - 1] == total - prefixSum[j]) {
                min = Math.min(min, j);
            }
        }
        if (min > nums.length) {
            return -1;
        }
        return min;
    }
}

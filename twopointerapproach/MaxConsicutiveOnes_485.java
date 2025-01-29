/**
 * MaxConsicutiveOnes_485
 */
public class MaxConsicutiveOnes_485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int j=0;
        int max=0;
        int count=0;
        while(j<nums.length){
            
            if(nums[j]==1){
                count++;
            }
            else {
                count=0;
            }
            
            max= Math.max(count, max);
            j++;
        }
        return max;
    }
}
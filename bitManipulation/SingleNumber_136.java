package bitManipulation;

public class SingleNumber_136 {
    public static int singleNumber(int[] nums) {
        int a=0;
        for(int i = 0 ; i<nums.length ; i++){
           a= a ^ nums[i];
        }
        return a;
   }
}

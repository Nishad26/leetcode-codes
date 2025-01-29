
// 930. Binary Subarrays With Sum
/*
*Supoose you are given an array (having only zero and positive no) and you are told to find subarrays having 
sum as goal
You can interpret this as:-

No of subarrays having (sum == goal) 
    = No of subarrays having (sum <= goal) - No of subarrays having (sum < goal) 
or 
No of subarrays having (sum == goal) 
    = No of subarrays having (sum <= goal) - No of subarrays having (sum <= goal-1) 
*/
public class AnotherBinarySubArrayWithSum_930 {
    public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(numSubarraysWithSum(new int[]{1,2,3,4}, 5)); 
	}
	public static int numSubarraysWithSum(int[] nums, int goal){
	    return numberOfSubArraysWithSumLessThanOrEqualToGoal(nums, goal)-
	                numberOfSubArraysWithSumLessThanOrEqualToGoal(nums, goal-1);
	}
	public static int numberOfSubArraysWithSumLessThanOrEqualToGoal(int[] nums, int goal) {
        int i=0;
        int j=0;
        int sum=0;
        int count= 0;
        
        while(j<nums.length){
            sum +=nums[j];
            while(sum > goal && i<=j){
                sum-= nums[i];
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
}

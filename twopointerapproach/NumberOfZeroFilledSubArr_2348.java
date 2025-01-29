// 2348. Number of Zero-Filled Subarrays

public class NumberOfZeroFilledSubArr_2348{
    public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(zeroFilledSubarray(new int[]{1,0,0,4,0,0})); 
	}
    public static long zeroFilledSubarray(int[] nums) {
        long count =0L;
	    for(int i =0 ;i < nums.length; i++){
	        
	        if(nums[i]==0){
	            int j = i;
	            while(j < nums.length && nums[j]==0){
	                count+=j-i+1;
	                j++;
	            }
	            i=j;
	        }
	        
	    }
	    return count;
    }
}
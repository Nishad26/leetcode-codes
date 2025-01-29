import java.util.*;
// 930. Binary Subarrays With Sum

/*
 * Suppose i am at a point j in an array at any index and i have a goal
 * So prefixSum[j]-prefixsum[i-1]= sub arry sum
 * now prefixSum[j]-prefixsum[i-1]= goal
 * so prefixSum[j] - goal = prefixSum(i-1)
 * hyacha aartha aasa hoti ki you have to find aasa prefixSum(i-1) 
 * jyala tu subtract kela j madhun taar tuza goal yeto
 * so samaz aase tula 2 prefixsum[i-1], bhetle taar tuzze index j la include kaarun (j la last elemet pakdun)
 *  2 subarrays bantat, karaan tu tya array chya aadhiche elemts la jevha subtrarct kartoy 
 * j chya prefix sum sobat tevha tula goal miltoy 
 * arr={5,5,7,3,0,2}
 * prefixsum= {5,10,17,20,20,22}
 *  youtube :- https://youtu.be/ZZ5bOSRxAqM?si=l-qwZrZHLkNIxzaH
 */
public class BinarySubArrayWithSum_930 {
    

    public static void main(String[] args) {
        int prefixSumArrCount = numSubarraysWithSum(new int[]{5,5,7,3,0,2}, 5);
        System.out.println(prefixSumArrCount);
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
       
        //prefix sum arr
        int prefixSum[] = new int[nums.length];
        
        //cpunt of subarrays having sum as goal
        int count=0;
        
        prefixSum[0]=nums[0];
        for(int i=1; i < nums.length ; i++){
            prefixSum[i]= prefixSum[i-1]+nums[i];
        }
        
        //HashMap for frequency of prefix sum
        //formula is prefixSum[j] - prefixSum[i-1]= goal
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        
        for(Integer j : prefixSum){
             if(map.containsKey(j-goal)){
                 count= count+map.get(j-goal);
             }
             map.put(j, map.getOrDefault(j, 0)+1);
        }
        
        return count;
        
     }
    public int numSubarraysWithSumBrteForceSlidingWindow(int[] nums, int goal) {
        int goalCount = 0;

        for (int windowSize = 1; windowSize <= nums.length; windowSize++) {
            int windowSum = 0;
            for (int i = 0; i < windowSize; i++) {
                windowSum += nums[i];
            }
            if (windowSum == goal) {
                goalCount++;
            }
            for (int j = windowSize; j < nums.length; j++) {
                windowSum = windowSum + nums[j] - nums[j - windowSize];
                if (windowSum == goal) {
                    goalCount++;
                }
            }

        }
        return goalCount;
    }
}

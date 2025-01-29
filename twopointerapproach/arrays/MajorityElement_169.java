package arrays;

// 169. Majority Element
// Here the intuition is that, there are regions in the array lets say, [2,2,1,1,3,3,3,3] ,in this array
// 0-3 is one region , in this region there is no majority there are equal number of 2s and 1s, so the majority elemet (element that occurs
// more than n/2 times in the array) is not present in this region,so we discard this region 
// so in the remaining region 4-7, 3 occurs the most hence 3 is the majoroty element, this is called
// Boyer Moore Voting algo

// Here the intution is that, suppose tuza 10 elemets cha array aahee, aani 8 tuza majproty element aahe jo 6 time appear hoto (more than n/2), taar
// tu 8 laa kaasa paan place kaaar, tulaa ek region milnarach jyachyat 8 maximum vela yeto
// [8,1,8,3,8,1,8,1,8,8], here that region is 8 to 9, last 2 index
public class MajorityElement_169 {

    public static int majorityElement(int[] nums) {
        int majorityEle = nums[0];
        int count = 0;

        for (int number : nums) {
            if (number == majorityEle) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majorityEle = number;
                count = 1;
            }
        }
        return majorityEle;
    }
}

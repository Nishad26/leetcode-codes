/**
 * TwoSum2_SortedArray_167
 */
public class TwoSum2_SortedArray_167 {

    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;
        
        while(i+1<=j){
            if(numbers[i]+numbers[j] == target){
                return new int[]{i+1, j+1};
            }
            else if(numbers[i]+numbers[j] > target){
                j--;
            } else {
                i++;
            }
        }
        return new int[]{0,0};
    }
}
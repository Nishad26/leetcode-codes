package BinarySearchApproaches;

//finidng duplicate when we have array of length n+1 and elemts are from 1 to n
//you should stricly ahve an array of n+1  elemts , that is size of the array 
//should be n+1, and also with just n elemts that is elemts from 1 to n
//Also only one elemts hosuld be repeated
//for eg you cant make an array having size 8 (as max value is n+1)
// with only 4 repeating 1s (taking 4 becuase 4 will be mid), you have to add some number
//less than or equal to 4 and then the condition is violated
//1 3 3 3 3 5 6 7 
//[1 1 3 3]
public class FindingDuplicate {
    public static int findDuplicate(int nums[]) {
        int low = 1;
        int high = nums.length - 1;
        int cnt;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            cnt = 0;

            // Count the number of elements less than or equal to mid
            for (int n : nums) {
                if (n <= mid)
                    cnt++;
            }

            // Binary search on the left
            if (cnt <= mid)
                low = mid + 1;
            else
                // Binary search on the right
                high = mid - 1;
        }
        return low;
    }
}

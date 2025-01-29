package prefixSumAlgo;

import java.util.HashSet;
import java.util.Set;

// video :- https://www.youtube.com/watch?v=u_ft5jCDZXk&t=601s
/*
 * 1.In general, 𝑎 mod 𝑛 gives the remainder when 
 * 𝑎 is divided by 𝑛. The result is always in the range of 0 to 𝑛 − 1.
 * 2.So, when we calculate −8mod15, we are looking for the remainder when −8 is divided by 
 * 15, but the 
 * remainder must be non-negative and fall between 0 and 14 (since 𝑛 = 15).
 * 3.Since we are working with negative numbers, we adjust the division by finding how far −8 is 
 * from the 
 * next multiple of 15. The multiple of 15 15 just below − 8 −8 is − 15 −15.
 * 4.So to find modulo always do this :- 22%15 = 22- (mulyiple of 15 just smaller than 22)= 22-15= 7
 * 5. So -8%15 = -8 - (-15)=7
 * 6. So -20 mod 15 = 10 (kaean multiple of 15 just less than -20 is -30)
 * 7. Here keep in mind that prefix = prefixsum % m (for this question)
 * 8. Also if you have to find the modulo of array let say i+1 to j, it will be 
 * prefixSumModuloJ - prefixsummodule i , karan adding actually two numbers and then doing modulo is similar 
 * to adding the reminder to the next number and the doing modulo  for eg :- (15 + 15)%15  is similar to
 * (15+0)%15 
 * 9. Forget this all above wala stuff just here the idea is , if i have a number (a) i will find a number
 * just bigger than that numnber  (b) so a-b will be negative  and a very small negative and when we 
 * subtract it from n (the number which we are diving it with ) we will get maximun reminder
 * 10. keep in mind (a+m)%m == a%m for eg (15+20)%20 = 15 == 15 % 20
 * 
 */
public class maximumSubArraySumModuloM {
    public static void main(String[] args) {
        // Driver Code
        int[] arr = new int[] { 3, 3, 9, 9, 5 };
        int n = 5;
        int m = 7;
        System.out.print(maxSubarray(arr, n, m));
    }

    public static int maxSubarray(int[] arr, int n, int m) {
        int prefixSumModulo = 0;
        int maxim = 0;
        Set<Integer> S = new HashSet<Integer>();
        S.add(0);

        // Traversing the array.
        for (int i = 0; i < n; i++) {

            // Finding prefix sum.
            prefixSumModulo = (prefixSumModulo + arr[i]) % m;

            // Finding maximum of prefix sum.
            maxim = Math.max(maxim, prefixSumModulo);

            // Finding iterator pointing to the first
            // element that is not less than value
            // "prefix + 1", i.e., greater than or
            // equal to this value.
            int it = 0;

            for (int j : S) {
                if (j >= prefixSumModulo + 1)
                    it = j;
            }
            if (it != 0) {
                maxim = Math.max(maxim, prefixSumModulo - it + m);
            }

            // adding prefix in the set.
            S.add(prefixSumModulo);
        }
        return maxim;
    }
}

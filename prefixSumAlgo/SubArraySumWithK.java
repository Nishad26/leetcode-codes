package prefixSumAlgo;

import java.util.HashMap;
import java.util.List;

public class SubArraySumWithK {
    public static void main(String[] args) {
        System.out.println(countNumberOfSubarrays(List.of(3, -3, 1, 1, 1), 3));
    }

    public static long countNumberOfSubarrays(List<Integer> arr, int k) {
        // This stores how many times that prefix sum has occured
        HashMap<Integer, Integer> prefixSumMap = new HashMap<Integer, Integer>();
        // This indicates that prefix sum is 0 1 time, this is for the case which
        // denotes that
        // take all elemts
        /*
         * for eg [1,2] prefix sum at index 1 will be 3, if k =3 ,prefixSum-k= 3-3 = 0,
         * Here s is prefix sum at that index or current index
         * So here sminusk=0 which denotes that take all the elemets,
         * aasa pan hou shakta at some point in the array the prefix sum i 0
         * then in the preixSumMap 0 --> 2, 0 will be mapped to 2 which is fine, which
         * means
         * there are two subarrays having sum as k, one will be by considering all the
         * elements upto
         * that point other will be by considering the array from the 0 point to the
         * cirrent index
         */
        prefixSumMap.put(0, 1);

        int prefixSum = 0;
        int countSubArraysWithk = 0;
        for (int i : arr) {

            prefixSum += i;

            int sminusk = prefixSum - k;

            if (prefixSumMap.containsKey(sminusk)) {
                countSubArraysWithk += prefixSumMap.get(sminusk);
            }

            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);

        }
        return countSubArraysWithk;

    }
}

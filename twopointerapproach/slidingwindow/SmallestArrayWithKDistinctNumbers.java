package slidingwindow;

import java.util.HashMap;

public class SmallestArrayWithKDistinctNumbers {
    // Driver code
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 3, 3, 4, 5 };
        int n = arr.length;
        int k = 3;

        minRange(arr, n, k);
    }

    static void minRange(int arr[], int n, int k) {

        /*
         * start = starting index of resultant subarray
         * end = ending index of resultant subarray
         */
        int start = 0, end = n;

        HashMap<Integer, Integer> map = new HashMap<>();

        /*
         * i = starting index of the window (on left side)
         * j = ending index of the window (on right side)
         */
        int i = 0, j = 0;

        while (j < n) {

            // Add the current element to the map
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            j++;

            // Nothing to do when having less element
            if (map.size() < k)
                continue;

            /*
             * If map contains exactly k elements,
             * consider subarray[i, j - 1] keep removing
             * left most elements
             */
            while (map.size() == k) {
                // as considering the (j-1)th and i-th index
                int windowLen = (j - 1) - i + 1;
                int subArrayLen = end - start + 1;

                if (windowLen < subArrayLen) {
                    start = i;
                    end = j - 1;
                }

                // Remove elements from left

                // If freq == 1 then totally erase
                if (map.get(arr[i]) == 1)
                    map.remove(arr[i]);

                // decrease freq by 1
                else
                    map.put(arr[i], map.get(arr[i]) - 1);

                // move the starting index of window
                i++;
            }
        }

        if (start == 0 && end == n)
            System.out.println("Invalid k");

        else
            System.out.println(start + " " + end);
    }
}

package arrays;
/*
 * Given an array of N elements, where each element is at most K away 
from its target position, devise an algorithm that sorts in O(N log K) time
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortANearlySortedOrKSortedArray {
    public static void main(String[] args) {
        // This is a K sorted array
        int arr[] = { 6, 5, 3, 2, 8, 10, 9 };
        sortAKSortedOrNearlySortedArray(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortAKSortedOrNearlySortedArray(int arr[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0;
        for (Integer integer : arr) {
            minHeap.add(integer);
            if (minHeap.size() > k + 1) {
                int element = minHeap.poll();
                arr[i++] = element;
            }
        }
        while (!minHeap.isEmpty()) {
            int element = minHeap.poll();
            arr[i++] = element;
        }

    }
}

package heap;

import java.util.Collections;
import java.util.PriorityQueue;

//use max heap
public class KthSmallestElementInArray {
    public static void main(String[] args) {
        int arr[] = { 7, 10, 4, 3, 20, 15 };
        int k = findKthSmallestElementInArray(arr, 3);
        System.out.println(k);
    }

    public static int findKthSmallestElementInArray(int arr[], int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer integer : arr) {
            maxHeap.add(integer);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        // Here if we return the heap or create a list of heap and the sort it ,
        // we will get k smallest element in the array
        return maxHeap.peek();

    }
}

package heap;

import java.util.PriorityQueue;

//Create min heap
//wHEN WE CREATE MIN HEAP THE SMALLEST ELEMENT COMES ON TOP
//this is a useless element so we poll it , at the end we are just left with k elemts in the heap
//out of which the smallest is at the top, and this is your Kth largest element
//as the smaller ones are already removed
public class KthLargestElemetInArray {
    public static void main(String[] args) {
        int arr[] = { 7, 10, 4, 3, 20, 15 };
        int k = findKthLargestElementInArray(arr, 3);
        System.out.println(k);
    }

    public static int findKthLargestElementInArray(int arr[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer integer : arr) {
            minHeap.add(integer);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();

    }
}

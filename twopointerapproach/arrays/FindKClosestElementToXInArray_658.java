package arrays;

import java.util.*;

public class FindKClosestElementToXInArray_658 {
	public static void main(String[] args) {
		System.out.println(findKClosestNumber(new int[] { 1, 2, 3, 4, 5 }, 4, 3));
	}

	// This will gives us the sortes list of all the elemts closest to x
	// but here id we consider the above example then 5 is also 2 units aways and 1
	// is also 2 units away
	// In question it is given, in such cases return 1 , so the second function will
	// do that
	public static List<Integer> findKClosestNumber(int arr[], int k, int x) {
		PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<List<Integer>>((a, b) -> b.get(0) - a.get(0));
		for (Integer integer : arr) {
			maxHeap.add(List.of(Math.abs(x - integer), integer));
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		List<Integer> ls = new ArrayList<Integer>();
		while (!maxHeap.isEmpty()) {
			ls.add(maxHeap.poll().get(1));
		}
		Collections.sort(ls);
		return ls;
	}

	// Here the heap is created on two conditions
	// 1st :- Based on difference (which ever elemt has the difference greatest it
	// will be on top)
	// or it will be the root elemt in the heap
	// 2nd :- Based of the elemt itself, if the elemt is big them the bigger elemt
	// will be on top
	// For eg 0 0 3 3 4 7 7 8
	// consider a scenario where heap is 7 3 7 4, ofcourse top 7 will be popped,
	// then heap will be
	// 4 3 7, then to heapify it will take 7 on top (7 3 4) as it will check its
	// both child
	// if difference is same it will take the elemt which is greatest
	// so all the greater elemts will be removed and we will have al the elemts
	// which are close to x
	// and also the smaller elemts
	public List<Integer> findClosestElementsAnother(int arr[], int k, int x) {
		PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<List<Integer>>((a, b) -> {
			// this is differnece of differences
			if (b.get(0) - a.get(0) != 0) {
				return b.get(0) - a.get(0);
			} else {
				return Integer.compare(b.get(1), a.get(1));
			}
		});
		for (int i = arr.length - 1; i >= 0; i--) {
			maxHeap.add(List.of(Math.abs(x - arr[i]), arr[i]));
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		List<Integer> ls = new ArrayList<Integer>();
		while (!maxHeap.isEmpty()) {
			ls.add(maxHeap.poll().get(1));
		}
		Collections.sort(ls);
		return ls;
	}

	// this also works, created a min heap here
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		PriorityQueue<List<Integer>> minHeap = new PriorityQueue<List<Integer>>((a, b) -> {
			if (b.get(0) - a.get(0) != 0) {
				return Integer.compare(a.get(0), b.get(0));
			} else {
				return Integer.compare(a.get(1), b.get(1));
			}
		});

		for (int i = arr.length - 1; i >= 0; i--) {
			minHeap.add(List.of(Math.abs(x - arr[i]), arr[i]));
		}
		List<Integer> ls = new ArrayList<Integer>();
		while (k > 0) {
			ls.add(minHeap.poll().get(1));
			k--;
		}
		Collections.sort(ls);
		return ls;
	}

}

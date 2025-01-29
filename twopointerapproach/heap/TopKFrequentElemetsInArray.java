package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElemetsInArray {
    public static void main(String[] args) {
        System.out.println(
                topKFrequentDisplayInDescendingFrequency(
                        new int[] { 7, 10, 11, 5, 2, 5, 7, 11, 8, 9, 100, 101, 88, 88, 88 }, 15, 4));

    }

    // this will give you result in decending order of frequency
    // this will give you always biggest numbers with maxum frquency ie for eg if
    // you have
    // 2 and 100 bith with frequency 1 then in the result it will give you 100
    // if you wnat in ascending order if fewquencies are same, change the comparator
    public static List<Integer> topKFrequentDisplayInDescendingFrequency(int[] arr, int N, int k) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<List<Integer>>(
                (a, b) -> {
                    if (a.get(1) == b.get(1)) {
                        return Integer.compare(b.get(0), a.get(0));
                    } else {
                        return Integer.compare(b.get(1), a.get(1));
                    }
                });
        for (Integer integer : mp.keySet()) {
            maxHeap.add(List.of(integer, mp.get(integer)));
        }
        List<Integer> mostFrequentElemts = new ArrayList<Integer>();

        while (k > 0) {
            mostFrequentElemts.add(maxHeap.poll().get(0));
            k--;
        }
        return mostFrequentElemts;
    }

    public static void topKFrequent(int[] arr, int N,
            int K) {

        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        // Put count of all the
        // distinct elements in Map
        // with element as the key &
        // count as the value.
        for (int i = 0; i < N; i++) {

            // Get the count for the
            // element if already present in the
            // Map or get the default value which is 0.
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(
                mp.entrySet());

        // Sort the list
        Collections.sort(
                list,
                new Comparator<Map.Entry<Integer, Integer>>() {
                    public int compare(
                            Map.Entry<Integer, Integer> o1,
                            Map.Entry<Integer, Integer> o2) {
                        if (o1.getValue() == o2.getValue())
                            return o2.getKey() - o1.getKey();
                        else
                            return o2.getValue()
                                    - o1.getValue();
                    }
                });

        for (int i = 0; i < K; i++)
            System.out.print(list.get(i).getKey() + " ");
    }

}

package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayConversion {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 3, 9, 9, 5 };
        Integer arr2[] = new Integer[arr.length];
        int j = 0;
        for (Integer i : arr) {
            arr2[j++] = i;
        }
        Arrays.sort(arr2, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr2));
        // Arrays.equals(arr, some_other_same_type_array);
        Arrays.stream(arr).sum();
        Arrays.binarySearch(arr, 1);

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr2));
        Collections.sort(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}

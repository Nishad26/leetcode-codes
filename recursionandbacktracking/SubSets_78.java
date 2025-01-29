package recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Here thinking is tree aasa bannar ki start with empty list, then you can have two option
 * you can pick 1 or not pick one , if you pick one, then you will get all the ssubsets having 1 
 * after picking 1 you have again 2 options , you can pck 2 or not pick 2 and so on
 */
public class SubSets_78 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        getSubSets(new int[] { 1, 2, 3 });
    }

    public static List<List<Integer>> getSubSets(int arr[]) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        getSubSetsImpl(arr, new ArrayList<Integer>(), 0, ans);
        return ans;
    }

    public static void getSubSetsImpl(int[] arr, List<Integer> ds, int start, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(ds));
        for (int i = start; i < arr.length; i++) {
            ds.add(arr[i]);

            getSubSetsImpl(arr, ds, i + 1, ans);

            ds.remove(ds.size() - 1);
        }
    }

    public static void getSubSetsImpl2(int[] arr, List<Integer> ds, int index, List<List<Integer>> ans) {
        // Base case: if we’ve considered all elements
        if (index == arr.length) {
            ans.add(new ArrayList<>(ds)); // Add the current subset to the answer list
            return;
        }

        // Option 1: Include the current element
        ds.add(arr[index]);
        getSubSetsImpl(arr, ds, index + 1, ans); // Move to the next element
        ds.remove(ds.size() - 1); // Backtrack

        // Option 2: Exclude the current element
        getSubSetsImpl(arr, ds, index + 1, ans); // Move to the next element
    }
}

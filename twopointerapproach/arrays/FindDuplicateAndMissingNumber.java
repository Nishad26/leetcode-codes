package arrays;

import java.util.ArrayList;

public class FindDuplicateAndMissingNumber {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(findTwoElement(new int[] { 4, 3, 6, 2, 1, 1 }));
    }

    public static ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length + 1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] % n;

            arr[index - 1] = arr[index - 1] + n;
        }

        for (int i = 0; i < arr.length; i++) {
            int freq = arr[i] / n;
            if (freq > 1) {
                ans.add(i + 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int freq = arr[i] / n;
            if (freq == 0) {
                ans.add(i + 1);
            }
        }

        return ans;

    }
}

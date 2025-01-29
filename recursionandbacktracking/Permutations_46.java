package recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[] { 1, 2, 3 }));
    }

    public static void permuteImplAnother(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            ans.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permuteImplAnother(nums, index + 1, ans);
            swap(nums, index, i);
        }

    }

    public static List<List<Integer>> permuteAnother(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        permuteImplAnother(nums, 0, ans);
        return ans;

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> ds = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int picked[] = new int[nums.length];
        permuteImpl(nums, ds, ans, picked);
        return ans;
    }

    public static void permuteImpl(int[] nums, List<Integer> ds, List<List<Integer>> ans, int picked[]) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (picked[i] == 0) {
                ds.add(nums[i]);
                picked[i] = 1;
                permuteImpl(nums, ds, ans, picked);
                ds.remove(ds.size() - 1);
                picked[i] = 0;
            }
        }
    }

    public static void swap(int num[], int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}

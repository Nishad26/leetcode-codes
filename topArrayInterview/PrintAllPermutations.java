package topArrayInterview;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3 };
        List<List<Integer>> result = new ArrayList<>();

        // Generate all subsets
        generateSubsets(array, 0, new ArrayList<>(), result);

        // Generate permutations for each subset
        List<List<Integer>> finalResult = new ArrayList<>();
        for (List<Integer> subset : result) {
            generatePermutationsNoSwap(subset, new ArrayList<>(), finalResult);
        }

        // Print all unique subsets and their permutations
        for (List<Integer> subset : finalResult) {
            System.out.println(subset);
        }
    }

    // Generate all permutations without swapping
    private static void generatePermutationsNoSwap(List<Integer> subset, List<Integer> current,
            List<List<Integer>> result) {
        if (current.size() == subset.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < subset.size(); i++) {
            if (current.contains(subset.get(i)))
                continue; // Skip already used elements
            current.add(subset.get(i)); // Choose the element
            generatePermutationsNoSwap(subset, current, result); // Explore further
            current.remove(current.size() - 1); // Backtrack
        }
    }

    // Generate all subsets
    private static void generateSubsets(int[] array, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == array.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include the current element
        current.add(array[index]);
        generateSubsets(array, index + 1, current, result);

        // Exclude the current element
        current.remove(current.size() - 1);
        generateSubsets(array, index + 1, current, result);
    }

}

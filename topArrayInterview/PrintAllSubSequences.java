package topArrayInterview;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubSequences {
    public static void main(String[] args) {
        System.out.println("Hello World");
        generateAllPossibleSubSequence(new int[] { 1, 2 }, 0, new ArrayList<Integer>());
    }

    // using input output method (aditya verma)
    // when we drawy the input output tree we find that
    // 1. whenever we are reaching the end of the array (start==rr.length)
    public static void generateAllPossibleSubSequenceAnother(int arr[], int start, List<Integer> list) {
        if (start == arr.length) {
            System.out.println(list);
            return;
        }
        List<Integer> op1 = new ArrayList<Integer>(list);
        List<Integer> op2 = new ArrayList<Integer>(list);

        // in op1 we do not take the character
        // we op2 we take the chracter
        op2.add(arr[start]);

        generateAllPossibleSubSequenceAnother(arr, start + 1, op1);
        generateAllPossibleSubSequenceAnother(arr, start + 1, op2);

    }

    public static void generateAllPossibleSubSequence(int arr[], int start, List<Integer> list) {
        if (start > arr.length) {
            return;
        }
        if (list.size() <= arr.length) {
            System.out.println(list);
        }

        for (int i = start; i < arr.length; i++) {
            list.add(arr[i]);
            generateAllPossibleSubSequence(arr, i + 1, list);
            list.remove(list.size() - 1);
        }

    }

    private static void generateSubstrings(String input, int start, List<String> result) {
        // Base case: If start reaches the end of the string
        if (start == input.length()) {
            return;
        }

        // Generate substrings starting from the current index
        for (int end = start + 1; end <= input.length(); end++) {
            result.add(input.substring(start, end)); // Add the substring [start, end)
        }

        // Recursive call to process the next starting index
        generateSubstrings(input, start + 1, result);
    }
}

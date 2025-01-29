package recursionandbacktracking;

import java.util.HashMap;

//question link :- https://www.youtube.com/watch?v=EgG3jsGoPvQ&t=2s
public class FrogJump_youtubetuf {

    public static void main(String[] args) {
        System.out.println(frogJump(new int[] { 10, 20, 30, 10 }));
    }

    public static int frogJump(int arr[]) {
        HashMap<Integer, Integer> mon = new HashMap<Integer, Integer>();
        int max = frogJumpImpl(arr, 0, 0, mon);
        System.out.println(mon);
        return max;
    }

    // hey recussion give me the best way to reach from this i to the last
    // step/index, you can ask this question to frogJumpImpl(height, i+1,i);
    public static int frogJumpImpl(int height[], int i, int prev, HashMap<Integer, Integer> energies) {
        if (i > height.length - 1) {
            return Integer.MAX_VALUE;
        }
        if (i == height.length - 1) {
            return Math.abs(height[i] - height[prev]);
        }
        if (energies.containsKey(i)) {
            return Math.abs(height[i] - height[prev]) + energies.get(i);
        }
        int oneStep = frogJumpImpl(height, i + 1, i, energies);
        int twoStep = frogJumpImpl(height, i + 2, i, energies);

        int optimalEnergy = Math.abs(height[i] - height[prev]) + Math.min(twoStep, oneStep);
        energies.put(i, Math.min(twoStep, oneStep));

        return optimalEnergy;
    }

    // hey recussion give me the best way to reach from this i to the last
    // step/index
    // so it will minenergy from i+1 th step to last + the energy to reach there
    public static int findMinStep(int arr[], int current) {
        if (current == arr.length - 1) {
            return 0; // No energy needed if already at the last index
        }

        if (current >= arr.length) {
            return Integer.MAX_VALUE; // Invalid move
        }

        // Calculate energy for 1-step jump
        int oneStep = Math.abs(arr[current] - arr[current + 1]) + findMinStep(arr, current + 1);

        // Calculate energy for 2-step jump, if possible
        int twoStep = Integer.MAX_VALUE;
        if (current + 2 < arr.length) {
            twoStep = Math.abs(arr[current] - arr[current + 2]) + findMinStep(arr, current + 2);
        }

        // Return the minimum energy required from this step
        return Math.min(oneStep, twoStep);
    }

}

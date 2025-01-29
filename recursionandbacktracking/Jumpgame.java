package recursionandbacktracking;

import java.util.HashMap;

public class Jumpgame {
    public boolean canJump(int[] nums) {
        return canJumpImpl(nums, 0, new HashMap<Integer, Boolean>());
    }

    public static boolean canJumpImpl(int nums[], int current, HashMap<Integer, Boolean> canJumpMap) {
        if (current >= nums.length - 1) {
            return true;
        }

        if (canJumpMap.containsKey(current)) {
            return canJumpMap.get(current);
        }

        int possibleSteps = nums[current];
        boolean canJump = false;

        for (int i = possibleSteps; i > 0; i--) {
            canJump = canJump || canJumpImpl(nums, current + i, canJumpMap);
            if (canJump == true) {
                break;
            }
        }

        canJumpMap.put(current, canJump);

        return canJump;
    }
}

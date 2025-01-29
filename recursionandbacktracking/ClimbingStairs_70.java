package recursionandbacktracking;

import java.util.HashMap;

public class ClimbingStairs_70 {
    public int climbStairsCaller(int n, HashMap<Integer, Integer> noOfWaysMap) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (noOfWaysMap.containsKey(n)) {
            return noOfWaysMap.get(n);
        }
        int ways = climbStairsCaller(n - 1, noOfWaysMap) + climbStairsCaller(n - 2, noOfWaysMap);
        noOfWaysMap.put(n, ways);
        return ways;
    }

    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return climbStairsCaller(n, new HashMap<Integer, Integer>());
    }
}

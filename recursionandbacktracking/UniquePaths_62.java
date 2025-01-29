package recursionandbacktracking;

import java.util.HashMap;
import java.util.List;
//you are given a grid 
public class UniquePaths_62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {
        HashMap<List<Integer>, Integer> noOfWays = new HashMap<List<Integer>, Integer>();
        return uniquePathsImpl(m - 1, n - 1, 0, 0, noOfWays);
    }

    public static int uniquePathsImpl(int m, int n, int i, int j, HashMap<List<Integer>, Integer> noOfWays) {
        if (m == i && n == j) {
            return 1;
        }
        if (i > m) {
            return 0;
        }
        if (j > n) {
            return 0;
        }
        if (noOfWays.containsKey(List.of(i, j))) {
            return noOfWays.get(List.of(i, j));
        }
        int pathToRight = uniquePathsImpl(m, n, i, j + 1, noOfWays);
        int pathDown = uniquePathsImpl(m, n, i + 1, j, noOfWays);

        noOfWays.put(List.of(i, j), pathDown + pathToRight);
        return pathDown + pathToRight;

    }
}

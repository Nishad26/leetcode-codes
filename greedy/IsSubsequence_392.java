package greedy;

public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        char s1[] = s.toCharArray();
        char t1[] = t.toCharArray();

        int target = 0;
        int i = 0;
        for (int j : s1) {
            while (i < t1.length && t1[i] != j) {
                i++;
            }
            if (i < t1.length && j == t1[i]) {
                target++;
                i++;
            }

        }
        return target == s.length() ? true : false;
    }
}

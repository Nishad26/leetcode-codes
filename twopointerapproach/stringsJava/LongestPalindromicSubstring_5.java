package stringsJava;

public class LongestPalindromicSubstring_5 {

    public static void main(String[] args) {
        String s = "racecar";

        System.out.println(longestPalindromeBruteForce("raceca5r"));
        System.out.println(longestPalindromeRecusion(s));
    }

    public static String longestPalindrome(String s) {
        String result = "";
        int maxlength = 0;
        int low = 0;
        int high = 0;
        if (s.length() == 1) {
            return s;
        }
        for (int i = 1; i < s.length(); i++) {
            low = i;
            high = i;

            while (s.charAt(low) == s.charAt(high)) {
                String temp = s.substring(low, high + 1);
                if (temp.length() > maxlength) {
                    result = new String(temp);
                    maxlength = result.length();
                }
                low--;
                high++;
                if (low < 0 || high > s.length() - 1) {
                    break;
                }
            }
            low = i - 1;
            high = i;

            if (low < 0) {
                continue;
            }

            while (s.charAt(low) == s.charAt(high)) {
                String temp = s.substring(low, high + 1);
                if (temp.length() > maxlength) {
                    result = new String(temp);
                    maxlength = result.length();
                }
                low--;
                high++;
                if (low < 0 || high > s.length() - 1) {
                    break;
                }
            }
        }
        return result;
    }

    /*
     * Here dp array denotes , if we are taking two indexes i,j, taar ti ji string
     * bante ti palindrom ahe ka
     * a b b a
     * i j
     * 0 1 2 3
     * so dp[0][3] will tell tuzi ti string palindrom ahe ka, if yes taar put 1 else
     * put -1
     * apli base conditio i+1==j pahila check karte dp madhe kahi ahe ka , nasel
     * taar swataha dp set kaarte
     * 
     */
    public static int isPalindromRecursion(String s, int i, int j, int dp[][]) {
        if (i == j) {
            dp[i][i] = 1;
            return 1;
        }
        if (i + 1 == j) {
            if (dp[i][j] != 0) {
                return dp[i][j];
            }
            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = 1;
                return 1;
            }
            dp[i][j] = -1;
            return -1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (s.charAt(i) != s.charAt(j)) {
            dp[i][j] = -1;
            return -1;
        }

        dp[i][j] = isPalindromRecursion(s, i + 1, j - 1, dp);
        return dp[i][j];
    }

    public static String longestPalindromeRecusion(String s) {
        int dp[][] = new int[s.length()][s.length()];

        int length = s.length();
        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (isPalindromRecursion(s, i, j, dp) == 1 && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static String longestPalindromeBruteForce(String s) {
        int length = s.length();
        int maxLength = 0;
        int start = 0;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isPalindrom(s, i, j) && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static boolean isPalindrom(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

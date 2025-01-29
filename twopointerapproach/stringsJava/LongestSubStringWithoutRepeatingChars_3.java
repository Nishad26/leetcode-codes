package stringsJava;

import java.util.HashSet;

/**
 * LongestSubStringWithoutRepeatingChars_3
 */
public class LongestSubStringWithoutRepeatingChars_3 {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> unique = new HashSet<Character>();
        int i = 0;
        int j = 0;
        int max = 0;

        while (j < s.length()) {

            char charAtJ = s.charAt(j);

            if (!unique.contains(charAtJ)) {
                unique.add(charAtJ);
            } else {

                while (unique.contains(charAtJ)) {
                    char charAtI = s.charAt(i);
                    unique.remove(charAtI);
                    i++;
                }
                unique.add(charAtJ);
            }

            int length = j - i + 1;
            max = Math.max(length, max);
            j++;

        }
        return max;
    }

    public static String longestSubstringWithoutRepeatingCharacters(String s) {
        HashSet<Character> unique = new HashSet<Character>();
        int i = 0;
        int j = 0;
        int max = 0;
        int start = 0;

        while (j < s.length()) {

            char charAtJ = s.charAt(j);

            if (!unique.contains(charAtJ)) {
                unique.add(charAtJ);
            } else {

                while (unique.contains(charAtJ)) {
                    char charAtI = s.charAt(i);
                    unique.remove(charAtI);
                    i++;
                }
                unique.add(charAtJ);
            }

            int length = j - i + 1;
            if (length > max) {
                start = i;
                max = length;
            }
            j++;

        }
        return s.substring(start, start + max);
    }
}
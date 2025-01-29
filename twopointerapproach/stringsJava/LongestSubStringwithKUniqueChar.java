package stringsJava;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 1.Start moving your j, move till you have 3 unique characters between i and
 * j, and also move till
 * you encounter 4th unique character
 * 2. When you encounter 4th uniquw character shirk your window till again you
 * have just 3 unique
 * characters
 * 3.Keep doing this
 * 4.While doing this keep track ofd Max
 */
public class LongestSubStringwithKUniqueChar {

    public static void main(String[] args) {
        System.out.println(longestSubString("aabacbebebe", 3));
    }

    public static int longestSubStringCleanSolution(String str, int k) {
        if (str == null || str.length() == 0 || k == 0) {
            return 0;
        }

        int i = 0, j = 0, max = 0;
        HashMap<Character, Integer> freq = new HashMap<>();

        while (j < str.length()) {
            char endChar = str.charAt(j);

            freq.put(endChar, freq.getOrDefault(endChar, 0) + 1);

            while (freq.size() > k) {
                char startChar = str.charAt(i);
                freq.put(startChar, freq.get(startChar) - 1);
                if (freq.get(startChar) == 0) {
                    freq.remove(startChar);
                }
                i++;
            }

            if (freq.size() == k) {
                max = Math.max(max, j - i + 1);
            }

            j++;
        }

        return max;
    }

    public static int longestSubString(String str, int k) {
        int i = 0;
        int j = 0;

        char charArr[] = str.toCharArray();

        HashSet<String> unique = new HashSet<String>();
        int max = 0;
        HashMap<String, Integer> freq = new HashMap<String, Integer>();

        while (i < str.length() - 1 && j < str.length()) {

            String character = String.valueOf(charArr[j]);

            if (unique.size() < k || unique.contains(character)) {
                unique.add(character);
                freq.put(character, freq.getOrDefault(character, 0) + 1);
                j++;
                continue;
            }
            if (j - i + 1 > max) {
                max = j - i + 1;
            }

            while (unique.size() != k - 1) {
                String characterI = String.valueOf(charArr[i]);

                freq.put(characterI, freq.get(characterI) - 1);
                i++;

                if (freq.get(characterI) == 0) {
                    unique.remove(characterI);
                    break;
                }
            }
            unique.add(character);

        }
        return max;

    }

}
package stringsJava;

import java.util.Arrays;

/*
 * Here the idea is when we sort an array, the array is sorted according to the letters, then only
 * first and last letter matters
 * eg [article, cir, cir, cz]-- we have to find longest prefix in all the elemts in the array, so here
 * for 1st and last elemt we dont have common prefix but for eg another:-
 * [cir, cir, ciz]:- here in first and last we have common prefix ci 
 */
public class LongesCommonPrefix_14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] { "club", "clear", "class" }));
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        char str1[] = strs[0].toCharArray();
        char str2[] = strs[strs.length - 1].toCharArray();

        int min = Math.min(str1.length, str2.length);

        int i = 0;
        String ans = "";

        while (i <= min - 1) {
            if (str1[i] == str2[i]) {
                ans += str1[i];
            } else {
                break;
            }
            i++;
        }
        return ans;
    }
}

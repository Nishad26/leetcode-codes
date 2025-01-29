
/*
 * Spreading the input array into a frequency array
 */
public class FindLuckyInteger_1394 {
   
    public int findLucky(int[] arr) {
        int freq[] = new int[501];

        for (int i : arr) {
            freq[i] += 1;
        }

        for (int i = freq.length - 1; i >= 1; i--) {
            if (i == freq[i]) {
                return i;
            }
        }
        return -1;
    }
}

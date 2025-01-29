package bitManipulation;

public class MinimumBitFlipsToConvertNumber_2220 {

    //This is best, remeber if you want to compare two bits xor is nice
    //it will give same asel taar 0, naai taar 1 , 
    //then you have 1s in all the places where bit needs to be flipped
    public static int anotherMinBitFlip(int start, int goal) {
        int res = start ^ goal;
        int count = 0;
        while (res != 0) {
            if ((1 & res) >= 1) {
                count++;
            }
            res = res >> 1;
        }
        return count;

    }

    // Here the approach is check each and every bit from left to right
    // if they are not equal flip it
    // do this till bith goal and start are equal
    // For toggling do xor with 1
    public static int minBitFlips(int start, int goal) {
        int count = 0;
        int i = 0;

        while (start != goal) {
            if (((1 << i) & start) != ((1 << i) & goal)) {
                start = start ^ (1 << i);
                count++;
            }
            i++;
        }
        return count;
    }
}

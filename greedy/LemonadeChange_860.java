package greedy;

/**
 * LemonadeChange_860
 */
public class LemonadeChange_860 {

    public boolean lemonadeChange(int[] bills) {
    
        int count[] = new int[11];

        for (int i : bills) {
            if (i != 20) {
                count[i]++;
            }
            int rem = i - 5;
            while (rem != 0 && count[5] > 0) {
                if (rem > 10 && count[10] > 0) {
                    rem = rem - 10;
                    count[10]--;
                }
                rem = rem - 5;
                count[5]--;
            }
            if (rem != 0) {
                return false;
            }
        }
        return true;
    }
}
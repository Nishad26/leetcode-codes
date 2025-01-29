
//Min adject swaps:- https://www.youtube.com/watch?v=WhMbbnHZpis
// any swaps:- https://www.youtube.com/watch?v=3YDBT9ZrfaU
public class MinimumAdjusentBracketSwap {
    public static int minimumAdjusentBracketSwap(String brackets) {
        int open = 0, close = 0, unbalanced = 0, swaps = 0;

        for (int i = 0; i < brackets.length(); i++) {
            if (brackets.charAt(i) == '(') {
                open++;
                if (unbalanced > 0) {
                    swaps += unbalanced;
                    unbalanced--;
                }
            } else {
                close++;
                unbalanced = close - open;
            }
        }
        return swaps;

    }

    public static int minAnySwaps(String brackets) {
        int close = 0, maxClose = 0;
        for (char bracket : brackets.toCharArray()) {
            if (bracket == '(') {
                close--;
            } else {
                close++;
            }
            maxClose = Math.max(maxClose, close);
        }
        return (maxClose + 1) / 2;

    }
}

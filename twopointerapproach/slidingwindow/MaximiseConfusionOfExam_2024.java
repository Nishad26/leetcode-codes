package slidingwindow;

public class MaximiseConfusionOfExam_2024 {
    public static void main(String[] args) {
        System.out.println(
                maxConsecutiveAnswers("TTFFT", 2));

    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int size = answerKey.length();
        int left = 0;
        int right = 0;
        int ans = 0;
        int count = 0;

        while (right < size) {

            if (answerKey.charAt(right) == 'F') {
                count++;
            }
            if (count > k) {
                while (count > k) {

                    if (answerKey.charAt(left) == 'F') {
                        count--;
                    }
                    left++;
                }
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }

        left = 0;
        right = 0;
        count = 0;

        while (right < size) {

            if (answerKey.charAt(right) == 'T') {
                count++;
            }
            if (count > k) {
                while (count > k) {

                    if (answerKey.charAt(left) == 'T') {
                        count--;
                    }
                    left++;
                }
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;

    }
}

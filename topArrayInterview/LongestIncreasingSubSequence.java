package topArrayInterview;

import java.util.Arrays;

//longest alternating subsequence :- https://www.geeksforgeeks.org/longest-alternating-subsequence/

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(lengthOfLongestIncreasingSubSequence(new int[] { 1, -2, -1, 0, 3, 4 }));
	}

	public static int lengthOfLongestIncreasingSubSequence(int arr[]) {

		if (arr.length == 1) {
			return 1;
		}
		// Here value at index i, denotes the length of longest increasing subseuquce,
		// where i is included
		int lengthOfLongestIncreasingSubSequenceIncludingI[] = new int[arr.length];
		Arrays.fill(lengthOfLongestIncreasingSubSequenceIncludingI, 1);

		for (int j = 1; j < arr.length; j++) {
			for (int i = 0; i < j; i++) {

				if (arr[j] > arr[i]) {

					if (lengthOfLongestIncreasingSubSequenceIncludingI[j] < lengthOfLongestIncreasingSubSequenceIncludingI[i]
							+ 1) {

						lengthOfLongestIncreasingSubSequenceIncludingI[j] = lengthOfLongestIncreasingSubSequenceIncludingI[i]
								+ 1;

					}

				}

			}
		}
		int max = 0;
		for (int l : lengthOfLongestIncreasingSubSequenceIncludingI) {
			max = Math.max(max, l);
		}
		return max;
	}

	// Additionally, we maintain a count[] array,
	// where count[i] holds the number of LIS’s ending at index i.
	static int numberofLIS(int[] arr) {
		int n = arr.length;

		// Array to store the length of the
		// LIS ending at each element
		int[] lis = new int[n];

		// Array to store the number of LIS
		// of that length ending at each element
		int[] count = new int[n];

		// Initialize LIS and count arrays
		Arrays.fill(lis, 1);
		Arrays.fill(count, 1);

		// Variable to track the length of
		// the longest LIS found
		int maxLen = 1;

		for (int i = 1; i < n; i++) {
			for (int prev = 0; prev < i; prev++) {
				if (arr[i] > arr[prev]) {

					// If a longer subsequence is found,
					// update the lis and reset the count
					if (lis[i] < lis[prev] + 1) {
						lis[i] = lis[prev] + 1;
						count[i] = count[prev];
					}

					// If another subsequence of the
					// same length is found, add to the
					// count
					else if (lis[i] == lis[prev] + 1) {
						count[i] += count[prev];
					}
				}
			}
			if (lis[i] > maxLen) {
				maxLen = lis[i];
			}
		}

		// Sum up counts of subsequences that
		// have the maximum length
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (lis[i] == maxLen) {
				res += count[i];
			}
		}

		return res;
	}

	public static int lengthOfLongestDecreasingSubSequence(int arr[]) {

		if (arr.length == 1) {
			return 1;
		}
		// Here value at index i, denotes the length of longest decreasing subseuquce,
		// where i is included
		int lengthOfLongestDecreasingSubSequenceIncludingI[] = new int[arr.length];
		Arrays.fill(lengthOfLongestDecreasingSubSequenceIncludingI, 1);

		for (int j = 1; j < arr.length; j++) {
			for (int i = 0; i < j; i++) {

				if (arr[j] < arr[i]) {

					if (lengthOfLongestDecreasingSubSequenceIncludingI[j] < lengthOfLongestDecreasingSubSequenceIncludingI[i]
							+ 1) {

						lengthOfLongestDecreasingSubSequenceIncludingI[j] = lengthOfLongestDecreasingSubSequenceIncludingI[i]
								+ 1;

					}

				}

			}
		}
		int max = 0;
		for (int l : lengthOfLongestDecreasingSubSequenceIncludingI) {
			max = Math.max(max, l);
		}
		System.out.println(Arrays.toString(lengthOfLongestDecreasingSubSequenceIncludingI));
		return max;
	}
}

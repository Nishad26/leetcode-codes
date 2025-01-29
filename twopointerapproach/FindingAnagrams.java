import java.util.*;

class FindingAnagrams {
	public static void main(String[] args) {
		System.out.println("Hello World");
		findAnagramsOptimized("bzzacab", "cba");
	}

	public static int findAnagramsOptimized(String str, String target) {
		if (str == null || target == null || str.length() < target.length()) {
			return 0;
		}

		HashMap<Character, Integer> letterCount = new HashMap<>();
		int lettcount = 0; // Number of unique characters in the target with zero frequency in window
		int anagramCount = 0;
		int i = 0, j = 0;

		// Initialize the letterCount with the frequency of characters in target
		for (char c : target.toCharArray()) {
			letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
		}

		lettcount = letterCount.size(); // Number of unique characters that need to match

		// Sliding window approach
		while (j < str.length()) {
			char charAtJ = str.charAt(j);

			// Add character at j to the window
			if (letterCount.containsKey(charAtJ)) {
				letterCount.put(charAtJ, letterCount.get(charAtJ) - 1);
				if (letterCount.get(charAtJ) == 0) {
					lettcount--;
				}
			}

			// Shrink the window from the left if the window size exceeds target length
			if (j - i + 1 > target.length()) {
				char charAtI = str.charAt(i);
				if (letterCount.containsKey(charAtI)) {
					if (letterCount.get(charAtI) == 0) {
						lettcount++;
					}
					letterCount.put(charAtI, letterCount.get(charAtI) + 1);
				}
				i++;
			}

			// Check if the current window is a valid anagram
			if (j - i + 1 == target.length() && lettcount == 0) {
				anagramCount++;
			}

			j++;
		}

		return anagramCount;
	}

	public static void findAnagrams(String str, String target) {

		HashMap<String, Integer> letterCount = new HashMap<String, Integer>();

		HashMap<String, Integer> iterationLetterCount = new HashMap<String, Integer>();

		for (char a : target.toCharArray()) {
			String letter = String.valueOf(a);
			letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
		}

		char arr[] = str.toCharArray();

		int i = 0;
		int j = 0;

		while (j < target.length()) {
			String letter1 = arr[j] + "";
			if (letterCount.containsKey(letter1)) {
				iterationLetterCount.put(letter1, iterationLetterCount.getOrDefault(letter1, 0) + 1);
			}

			j++;
		}
		j--;
		System.out.println(letterCount);
		int count = 0;
		while (j < str.length()) {
			System.out.println(iterationLetterCount);
			if (letterCount.equals(iterationLetterCount)) {
				count++;
			}

			if (j == str.length() - 1) {
				break;
			}
			String jchar = arr[j + 1] + "";
			String ichar = arr[i] + "";

			// remove i
			if (letterCount.containsKey(ichar))
				iterationLetterCount.put(arr[i] + "", iterationLetterCount.getOrDefault(arr[i] + "", 0) - 1);
			i++;
			// add j+1
			if (letterCount.containsKey(jchar)) {
				iterationLetterCount.put(jchar, iterationLetterCount.getOrDefault(jchar, 0) + 1);
			}
			j++;

		}
		System.out.println(count);

	}

}
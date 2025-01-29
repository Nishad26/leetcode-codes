package topArrayInterview;

import java.util.Arrays;

public class MoveAllUniqueElemtstoFront {
	public static void main(String[] args) {
		System.out.println("Hello World");
		moveAllUniqueElemtstoFront(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 4, 5, 6 });
	}

	public static void moveAllUniqueElemtstoFront(int arr[]) {

		int i = 1;
		int j = 1;

		while (j < arr.length) {

			if (j < arr.length && arr[j] > arr[i - 1]) {
				arr[i++] = arr[j++];
			} else {
				j++;
			}

		}
		while (i < arr.length) {
			arr[i++] = 0;
		}
		System.out.println(Arrays.toString(arr));
	}
}

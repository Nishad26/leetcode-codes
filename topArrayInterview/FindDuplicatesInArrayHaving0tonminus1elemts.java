package topArrayInterview;

/*
 * This solution will only work if these conditions are meet
 * 1. There are only elemts between 0 to n-1 in the array (such as when we divide the result array 
 * (after adding n to it), the original numbera s it is smaller than n turns out to be zero)
 * 2. elemts can be repeated any number of time
 * 
 * Here the whole idea is, you make a frequency array out of the input array itself, but instead of
 * adding 1 you add  n , what this will do is when we finally didvide the aaray elemts
 * the original number at the index (as it is smaller than n) will be turning out to zero
 * and the number of times n is added (for eg 3n), as we are dividing we will get the frequency
 * as n will be getting cancelled
 * 
 * Here thought is if lets say 2 is 3 repeating, then n will be added 3 times to the number present 
 * at index 2, then when we didvide the number at index 2 , as the original number at index 2 
 * is samller than n it will turn out to be 0 and 3n will just be 3 (as we are diving)
 * so this is freqency of how many times 2 is repeated 
 */
public class FindDuplicatesInArrayHaving0tonminus1elemts {
    static void printRepeating(int arr[], int n) {
        // First check all the values that are
        // present in an array then go to that
        // values as indexes and increment by
        // the size of array
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
        }

        // Now check which value exists more
        // than once by dividing with the size
        // of array
        for (int i = 0; i < n; i++) {
            if ((arr[i] / n) >= 2)
                System.out.print(i + " ");
        }
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = { 1, 6, 3, 1, 3, 6, 6 };
        int arr_size = arr.length;

        System.out.println("The repeating elements are: ");

        // Function call
        printRepeating(arr, arr_size);
    }
}

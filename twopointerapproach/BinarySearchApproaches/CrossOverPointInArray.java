package twopointerapproach.BinarySearchApproaches;

//Cross over point is a point in array where or an index in array where
//1. at the index or indexes lesser than that index we have values smaller than or equal to 
//x
//2. at the index + 1 positon we have values greter than x 
public class CrossOverPointInArray {
    //
    private static int findCrossover(int[] arr, int low, int high, int x) {
        // Base cases
        if (arr[high] <= x) // x is greater than all elements
            return high;
        if (arr[low] > x) // x is smaller than all elements
            return low;

        // Binary search to find the crossover point
        int mid = low + (high - low) / 2;

        // If arr[mid] is less than or equal to x and arr[mid + 1] is greater than x
        if (arr[mid] <= x && arr[mid + 1] > x) {
            return mid;
        }

        // If x is smaller than arr[mid], then crossover point lies in the left half
        if (arr[mid] > x) {
            return findCrossover(arr, low, mid - 1, x);
        }

        // Else, it lies in the right half
        return findCrossover(arr, mid + 1, high, x);
    }
}

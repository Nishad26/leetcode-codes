package arrays;

public class CountingOccurencesInSortedArray {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 2, 2, 3 };
        int n = arr.length;
        int x = 2;
    }

    /*
     * Find index of last occurrence of greatest element
     * less than key in array
     * Returns: an index in range [0, n-1] if key is not
     * the least element in array, -1 if
     * key is the least element in array
     */
    static int greatestlesser(int low, int high, int key) {
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low + 1) / 2;
            int midVal = a[mid];

            if (midVal < key) {

                // If mid is less than key, all elements
                // in range [low, mid - 1] are < key
                // we note down the last found index, then
                // we search in right side of mid
                // so we now search in [mid + 1, high]
                ans = mid;
                low = mid + 1;
            } else if (midVal > key) {

                // If mid is greater than key, all elements
                // in range [mid + 1, high] are > key
                // then we search in left side of mid
                // so we now search in [low, mid - 1]
                high = mid - 1;
            } else if (midVal == key) {

                // If mid is equal to key, all elements
                // in range [mid + 1, high] are >= key
                // then we search in left side of mid
                // so we now search in [low, mid - 1]
                high = mid - 1;
            }
        }

        return ans;
    }

    /*
     * Find first occurrence index of key in array
     * Returns: an index in range [0, n-1] if key belongs
     * to array, -1 if key doesn't belong to array
     */
    static int first(int low, int high, int key) {
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low + 1) / 2;
            int midVal = a[mid];

            if (midVal < key) {

                // If mid is less than key, all elements
                // in range [low, mid] are also less
                // so we now search in [mid + 1, high]
                low = mid + 1;
            } else if (midVal > key) {

                // If mid is greater than key, all elements
                // in range [mid + 1, high] are also greater
                // so we now search in [low, mid - 1]
                high = mid - 1;
            } else if (midVal == key) {

                // If mid is equal to key, we note down
                // the last found index then we search
                // for more in left side of mid
                // so we now search in [low, mid - 1]
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    /*
     * Find last occurrence index of key in array
     * Returns: an index in range [0, n-1] if key
     * belongs to array, -1 if key doesn't
     * belong to array
     */
    static int last(int low, int high, int key) {
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low + 1) / 2;
            int midVal = a[mid];

            if (midVal < key) {

                // If mid is less than key, then all elements
                // in range [low, mid - 1] are also less
                // so we now search in [mid + 1, high]
                low = mid + 1;
            } else if (midVal > key) {

                // If mid is greater than key, then all
                // elements in range [mid + 1, high] are
                // also greater so we now search in
                // [low, mid - 1]
                high = mid - 1;
            } else if (midVal == key) {

                // If mid is equal to key, we note down
                // the last found index then we search
                // for more in right side of mid
                // so we now search in [mid + 1, high]
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

    /*
     * Find index of first occurrence of least element
     * greater than key in array
     * Returns: an index in range [0, n-1] if key is not
     * the greatest element in array, -1 if key
     * is the greatest element in array
     */
    static int leastgreater(int low, int high, int key) {
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low + 1) / 2;
            int midVal = a[mid];

            if (midVal < key) {

                // If mid is less than key, all elements
                // in range [low, mid - 1] are <= key
                // then we search in right side of mid
                // so we now search in [mid + 1, high]
                low = mid + 1;
            } else if (midVal > key) {

                // If mid is greater than key, all elements
                // in range [mid + 1, high] are >= key
                // we note down the last found index, then
                // we search in left side of mid
                // so we now search in [low, mid - 1]
                ans = mid;
                high = mid - 1;
            } else if (midVal == key) {

                // If mid is equal to key, all elements in
                // range [low, mid] are <= key
                // so we now search in [mid + 1, high]
                low = mid + 1;
            }
        }
        return ans;
    }

}

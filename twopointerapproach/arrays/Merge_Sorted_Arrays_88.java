package arrays;

class Merge_Sorted_Arrays_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m = m - 1;
        n = n - 1;

        for (int k = nums1.length - 1; k >= 0; k--) {
            if (n < 0) {
                break;
            }
            if (m < 0) {
                nums1[k] = nums2[n];
                n--;
                continue;
            }
            if (nums2[n] >= nums1[m]) {
                nums1[k] = nums2[n];
                n--;
            } else {
                nums1[k] = nums1[m];
                nums1[m] = 0;
                m--;
            }
        }
    }
}

package arrays;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int a[] = { 3, 7, 10, 12 };
        int b[] = { 1, 2, 5, 6 };
        System.out.println(medianOfTwoSortedArrays(a, b));
        // 1,2 3,5,7,10,12

    }

    public static void mergeTwoSortedArrays(int num1[], int num2[]) {

        int i = 0;
        int j = 0;
        int n = num1.length;
        int m = num2.length;
        int mergedArray[] = new int[m + n];
        int m2 = 0;
        int count = -1;
        for (int k = 0; k <= (m + n); k++) {
            if (count == -1) {
                count++;
            } else {
                mergedArray[count++] = m2;
            }

            if (i != n && j != m) {
                if (num1[i] > num2[j]) {
                    m2 = num2[j++];
                } else {
                    m2 = num1[i++];
                }
            } else if (i < n) {
                m2 = num1[i++];
            } else if (j < m) {
                m2 = num2[j++];
            }
        }

        System.out.println(Arrays.toString(mergedArray));

    }

    // Always assign smaller number to m1 and then assign it to m2
    public static double medianOfTwoSortedArrays(int num1[], int num2[]) {

        // 1,2 3,5,7,10,12
        // int a[] = { 3, 7, 10, 12 };
        // int b[] = { 1, 2, 5, 6 };
        int i = 0;
        int j = 0;
        int m1 = 0;
        int m2 = 0;

        int n = num1.length;
        int m = num2.length;

        for (int k = 0; k <= (m + n) / 2; k++) {
            m2 = m1;

            if (i != n && j != m) {
                if (num1[i] > num2[j]) {
                    m1 = num2[j++];
                } else {
                    m1 = num1[i++];
                }
            } else if (i < n) {
                m1 = num1[i++];
            } else if (j < m) {
                m1 = num2[j++];
            }
        }
        System.out.println("m1 " + m1);
        System.out.println("m2 " + m2);
        if ((n + m) % 2 == 1) {
            return m1;
        } else {
            double add = (m1 + m2);
            return add / 2;
        }

    }
}

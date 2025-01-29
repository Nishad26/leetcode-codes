package recursionandbacktracking;

import java.util.Arrays;
import java.util.List;

public class SortAnArrayusingRecursion {
    
    public static void main(String[] args) {
        int arr[] = {1,6,2,9,0,8};
        sortAnArray(arr, 0);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortAnArray(int arr[], int end){
        if(end>arr.length){
            return;
        }
        for (int i = 0; i <end; i++) {
            int j=i+1;
            while(j<end){
                if(arr[i]>arr[j]){
                    swap(arr, i, j);
                }
                j++;
            }
        }
        sortAnArray(arr, end+1);

    }
    public static void sortAnArrayAnother(List<Integer> arr){
        if(arr.size()==1){
            return;
        }
    
        int value= arr.remove(arr.size()-1);
        sortAnArrayAnother(arr);
        insert(arr, value);

    }
    public static void insert(List<Integer> arr, int value) {
        if(arr.isEmpty() || arr.get(arr.size()-1)< value){
            arr.add(value);
            return;
        }
        int temp = arr.remove(arr.size()-1);
        insert(arr, value);
        arr.add(temp);
    
    }
    public static void swap(int num[], int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}

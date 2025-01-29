import java.util.Arrays;
/*
 * Count Sort ( O(max_value) time complexity )
Usually the normal sorting takes O(nlogn) time complexity
When to use count sort:-
1. Counting sort is most efficient when the maxium value in an array (range of the input values ) 
is less than the number of elements (length of the array). 
If  maxium value in an array  is large compared to length of the array, 
the space complexity will increase, making counting sort less efficient.

2. If the values are uniformly distributed within the range, counting sort can be very efficient. 
It works well when you have many repeated values.
 */

public class Countsortalgo{
    public static void main(String[] args) {
	   countSort(new int[]{2,2,1,1,3,3,3,3,3},3); 	
	}

	public static void countSort(int[] arr, int max_value) {

        int count[] = new int[max_value+1];
        for(int num: arr){
            count[num]+=1;
        }
        int j=0;
        for(int value=0 ;value <= max_value ; value++){
            while(count[value] >0){
                arr[j++]=value;
                count[value]-=1;
            }
        }
        System.out.println(Arrays.toString(arr));
	}
}
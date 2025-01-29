
// url :- https://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/
//used two pointer approiach
//this is correct siolution

//wE CAN ASLO CREATE TWO ARRAYS HERE
//1st array :- maximum left
//2nd array:- minimum right 

// this is because you want a number of which left side is alwats smaller and right side is 
//always bigger
import java.util.List;

class ElementBeforeAndAfterWhich {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(findElement(List.of(5, 6, 7, 8)));
    }

    public static int findElement(List<Integer> arr) {
        if (arr.size() <= 2) {
            return -1;
        }

        int i = 1;
        int j = 2;

        int max = arr.get(0);

        while (j < arr.size()) {
            if (arr.get(i) > max && arr.get(j) > arr.get(i)) {
                j++;
            } else {
                while (i < j) {
                    max = Math.max(max, arr.get(i));
                    i++;
                }
                j++;
            }

        }
        if (i == j - 1) {
            return -1;
        }
        return arr.get(i);
    }
}
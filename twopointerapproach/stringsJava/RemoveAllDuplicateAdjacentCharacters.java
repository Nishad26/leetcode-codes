package stringsJava;

import java.util.Stack;

public class RemoveAllDuplicateAdjacentCharacters {
    public static void main(String[] args) {
        String str1 = "azzxzy";
        System.out.print(ShortenString(str1));

    }

    static String ShortenString(String str1) {
        // Store the String without
        // duplicate elements
        Stack<Character> st = new Stack<Character>();

        // Store the index of str
        int i = 0;

        // Traverse the String str
        while (i < str1.length()) {
            // Checks if stack is empty
            // or top of the stack is not
            // equal to current character
            if (st.isEmpty() ||
                    str1.charAt(i) != st.peek()) {
                st.add(str1.charAt(i));
                i++;
            }

            // If top element of the stack is
            // equal to the current character
            else {
                st.pop();
                i++;
            }
        }

        // If stack is empty
        if (st.isEmpty()) {
            return ("Empty String");
        }

        // If stack is not Empty
        else {
            String short_String = "";
            while (!st.isEmpty()) {
                short_String = st.peek() +
                        short_String;
                st.pop();
            }
            return (short_String);
        }
    }

}

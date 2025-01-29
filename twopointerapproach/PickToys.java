import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * PickToys
 */
public class PickToys {

    public static void main(String[] args) {
		System.out.println(pickToys("caaaab")); 
	}
     public static int pickToysCleanSolution(String toys) {
        int i = 0, j = 0, max = 0;
        Map<Character, Integer> cart = new HashMap<>();
        
        while (j < toys.length()) {
            char currentToy = toys.charAt(j);
            
            // Add the current toy to the cart
            cart.put(currentToy, cart.getOrDefault(currentToy, 0) + 1);
            
            // If the cart contains more than 2 types of toys, shrink the window from the left
            while (cart.size() > 2) {
                char toyAtI = toys.charAt(i);
                cart.put(toyAtI, cart.get(toyAtI) - 1);
                
                // Remove the toy from the cart if its count becomes 0
                if (cart.get(toyAtI) == 0) {
                    cart.remove(toyAtI);
                }
                
                i++; // Slide the window from the left
            }
            
            // Calculate the number of toys in the current window
            int totalToys = j - i + 1;
            max = Math.max(max, totalToys); // Update the maximum number of toys
            
            j++; // Expand the window to the right
        }
        
        return max;
    }
	public static int pickToys(String toys){
	    char toysArr[] = toys.toCharArray();
	    int i=0;
	    int j=0;
	    
	    HashMap<Character, Integer> cart = new HashMap<Character, Integer>();
	    int max=0;
	    while(j< toysArr.length){
	        
	        if(!cart.containsKey(toysArr[j]) && !(cart.keySet().size() < 2)){
	            
	            System.out.println("cart before "+cart);
	            //calculate no of toys
	            int totalToys= 0;
	            for(int no: cart.values()){
	                totalToys+=no; 
	            }
	            if(totalToys> max){
	                max=totalToys;
	            }
	            
	            //slide i
	            ArrayList<Character> keyList = new ArrayList<Character>(cart.keySet());
	            while(cart.get(keyList.get(0))!=0 && cart.get(keyList.get(1))!=0 ){
	                char charAtI = toysArr[i];
	                cart.put(charAtI, cart.get(charAtI)-1);
	                i++;
	            }
	            if(cart.get(keyList.get(0))==0){
	                cart.remove(keyList.get(0));
	            } else {
	                cart.remove(keyList.get(1));
	            }
	            
	           System.out.println("cart after "+cart);
	            
	        }
	        cart.put(toysArr[j], cart.getOrDefault(toysArr[j], 0)+1);
	        j++;
	        System.out.println("cart after loop "+cart);    
	    } 
	    //calculate no of toys
	    int totalToys= 0;
	    for(int no: cart.values()){
	       totalToys+=no; 
	    }
	    if(totalToys> max){
	       max=totalToys;
	    }
	    return max;
	}
}
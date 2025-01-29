package greedy;

import java.util.Arrays;

/**
 * AssignCookies_455
 */
public class AssignCookies_455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
	    Arrays.sort(s);
	    
	    int count=0;
	    int i =0;
	    int j =0;
	    while(i<s.length && j<g.length){
	        if(s[i]>=g[j]){
	            count++;
	            i++;
	            j++;
                continue;
	        }
	        i++;
	    }
	    return count;
    }
}
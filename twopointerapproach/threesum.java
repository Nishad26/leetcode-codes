// Given an integer array nums, return all the triplets 
// [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

import java.util.*;
class Solution {

    public List<List<Integer>> threeSumOptimized(int[] nums) {
        List<List<Integer>> set = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int i =0; i < nums.length-2; i++){
            
            int a= nums[i];
            int j=i+1;
            int k=nums.length-1;
            
            while(j+1<=k){
                
                int b=nums[j];
                int c=nums[k];
                if(a+b+c==0){
                    set.add(
                        List.of(
                            Integer.valueOf(a),
                            Integer.valueOf(b),
                            Integer.valueOf(c)
                        )
                    );
                    while(nums[j]== b && j<k){
                        j++;
                    }
                    while(nums[k]==c && k>j){
                        k--;
                    }
                } 
                else if (nums[k]+nums[j] > 0-a ){
                    while(nums[k]==c && k>j){
                        k--;
                    }
                } 
                else {
                    while(nums[j]== b && j<k){
                        j++;
                    }
                    
                }
            }
            while(nums[i]==a && i< nums.length-2){
                i++;
            }
            i--;
            
        }
        
        
        return new ArrayList<List<Integer>>(set);
    }

    //this is brute force approach
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = Arrays.asList(new Integer[] { nums[i], nums[j], nums[k] });
                        Collections.sort(temp);
                        if (!list.contains(temp))
                            list.add(temp);
                    }
                }
            }
        }
        return list;
    }
}
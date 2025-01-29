package recursionandbacktracking;

public class TowerOfHanoi {
    

    public static void towerOfHanoi(int source, int destination, int helper, int n){
        if(n==1){
            System.out.println("move "+n+ " from "+source+ " to "+destination);
        }

        towerOfHanoi(source, helper, destination, n);
        System.out.println("move "+n+ " from "+source+ " to "+destination);
        towerOfHanoi(helper, destination, source, n);
    }
}

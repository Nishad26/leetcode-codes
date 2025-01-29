package recursionandbacktracking;


/*
 * Here first of akll the grammar looks like this
 * n= 1  0
 * n= 2  0 1 
 * n= 3  0 1 1 0
 * n= 4  0 1 1 0 1 0 0 1
 * 1.Here first observation is grammar of n/2 and n-1 are same for eg 8/2==4 so for n==4 til 4 and n-1 ie 3
 * the grammar is same  
 * 2. If you are asked the letter at 2nd posistion , te nahenmi 1aach aasnar karaan , karan 0 split houn
 * 0 ani 1ach banavanar and so second element will always be 1, after n==2
 * 3. if n==4 then 0sand1s will be 8 , 8/2 is 4 (this is same as n-1), but tyachya nanatr che are 
 * compliment of k-mid like position 5 is compliment of position 1 (1 based indexing) and so on 
 * 4. So tu samaj n==4 madhe ahes, ani tula recusive call ne n==3 sathicha k delay taar tula to k 
 * compliment karayacahay ki nahi this dependes ups tuza k, n===4 madhe khute lie kaarto, if it is
 * after mid then compliment it (karan apla obersvation says so), if it is before mid taar dont, karan mid
 * chya paahile elemets are same as n-1 che elemts 
 */

public class KthSymbolInGrammar_779 {

    public static void main(String[] args) {
        kthGrammar(4, 5);
    }
    public static int kthGrammar(int n, int k) {
        if(n==1 && k==1){
            return 0;
        }
        int mid = (int)Math.pow(2, n-1)/2;
        if(k<=mid){
            return kthGrammar(n-1, k);
        }
        else{
            return kthGrammar(n-1, k-mid)^1;
        }
    }
    
}

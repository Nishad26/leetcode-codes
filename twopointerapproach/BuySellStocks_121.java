/**
 * BuySellStocks_121
 */
public class BuySellStocks_121 {

    public int maxProfit(int[] prices) {
        int i=0;
        int j=i+1;
        int max=0;
        while(j< prices.length){
            if(prices[j]-prices[i]<0){
                i=j;
            } else {
                max= Math.max(max, (prices[j]-prices[i]));
            }
            j++;
        }
        return max;
    }
}
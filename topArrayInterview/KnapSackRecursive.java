package topArrayInterview;

public class KnapSackRecursive {
    public static int knapSackMostCorrect(int weight[], int price[], int knapWeight, int n) {

        if (n == 0 || knapWeight == 0) {
            return 0;
        }

        if (weight[n - 1] <= knapWeight) {

            int temp1 = price[n - 1] + knapSackMostCorrect(weight, price, knapWeight - weight[n - 1], n - 1);
            int temp2 = knapSackMostCorrect(weight, price, knapWeight, n - 1);
            return Math.max(temp1, temp2);
        } else {
            return knapSackMostCorrect(weight, price, knapWeight, n - 1);
        }
    }

    public static int knapSack(int[] price, int[] weight, int knapWeight, int start) {
        // Base case: If we have considered all items or the knapsack is full
        if (start == price.length || knapWeight == 0) {
            return 0;
        }

        int maxPriceTemp = 0;

        // Iterate through items starting from 'start'
        for (int i = start; i < price.length; i++) {
            // Check if the current item's weight fits in the knapsack
            if (knapWeight >= weight[i]) {
                // Choose the current item and recursively calculate the rest
                int currentProfit = price[i] + knapSack(price, weight, knapWeight - weight[i], i + 1);

                // Update the maximum profit
                maxPriceTemp = Math.max(maxPriceTemp, currentProfit);
            }
            // Here we dont have to manually handle the backtracking as we are not modifying
            // the state or
            // argument varuables directly in the code of the function
            // here the state of call does not change eg:- knapWeight remain knapWeight
            // throuighput the code
        }

        return maxPriceTemp;
    }

    public static int knapSack(int price[], int weight[], int knapWeight, int start, int priceTemp) {

        if (start == price.length) {
            return priceTemp;
        }

        int maxPriceTemp = priceTemp;
        int temp = 0;
        for (int i = start; i < price.length; i++) {
            if (knapWeight - weight[i] < 0) {
                continue;
            }

            priceTemp += price[i];
            knapWeight -= weight[i];

            temp = knapSack(price, weight, knapWeight, i + 1, priceTemp);
            maxPriceTemp = Math.max(maxPriceTemp, temp);

            // backtracking
            priceTemp -= price[i];
            knapWeight += weight[i];
        }

        return maxPriceTemp;
    }
}

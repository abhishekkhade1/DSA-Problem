class Solution {
    public int maxProfit(int[] prices) {
        int buyStock = Integer.MAX_VALUE;
        int profit = 0;

        for(int i = 0; i<prices.length; i++){

            if(prices[i] > buyStock){
                profit = Math.max(profit, prices[i] - buyStock);
            }else{
                buyStock = prices[i];
            }
        }
        return profit;   
    }
}
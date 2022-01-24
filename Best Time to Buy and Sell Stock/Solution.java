class Solution {
    public int maxProfit(int[] prices) {
        //max subarray difference
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        
        for(int i = 0; i < prices.length; i++) {
            if(minprice > prices[i]) {
                minprice = prices[i];
            }
            maxprofit = Math.max(maxprofit, prices[i] - minprice);
        }
        return maxprofit;
    }
}

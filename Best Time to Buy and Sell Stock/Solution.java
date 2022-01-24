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
//////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int maxProfit(int[] prices) {
        //kadane's algorithm
        //max subarray sum type
        int maxprofit = Integer.MIN_VALUE;
        int currmaxprofit = 0;
        
        for(int i = 1; i < prices.length; i++) {
            currmaxprofit += prices[i] - prices[i-1];
            
            maxprofit = Math.max(maxprofit, currmaxprofit);
            if(currmaxprofit < 0)
                currmaxprofit = 0;
        }
        return maxprofit;
    }
}

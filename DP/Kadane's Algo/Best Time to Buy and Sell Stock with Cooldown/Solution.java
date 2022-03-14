class Solution {
    public int maxProfit(int[] prices) {
        int boughtState = -prices[0];
        int soldState = 0;
        int coolState = 0;
        for(int i = 1; i < prices.length; i++) {
            int prevBoughtState = boughtState;
            boughtState = Math.max(boughtState, coolState - prices[i]);
            
            int prevSoldState = soldState;
            soldState = Math.max(soldState, prevBoughtState + prices[i]);
            
            coolState = prevSoldState;//keep it running one behind
        }
        return soldState;
    }
    
}

class Solution {
    public static int maxProfit(int[] prices) {
            int min = prices[0];
            int maxprofit=0;
        for (int i= 1; i<prices.length; i++){
            if (prices[i]< min){
                min = prices[i];
            }
               int profit = prices[i] - min;
            if(profit> maxprofit){
                maxprofit =profit;
            }
        }
        return maxprofit;
    }
    public static void main (String args[]){
        int prices[] = new int[]{7,1,5,3,6,4};
        int result = maxProfit(prices);
        System.out.println("maximum profit" + result);
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-03
 * Time: 20:33
 */
class Solution {
    //121. 买卖股票的最佳时机
    //就是用O（N）的复杂度找最大值和最小值，基本自己一遍过
    public int maxProfit(int[] prices) {
        int prevMin=Integer.MAX_VALUE,n=prices.length,
                ret=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            prevMin=Math.min(prevMin,prices[i]);
            ret=Math.max(ret,prices[i]-prevMin);
        }
        return ret;
    }
}

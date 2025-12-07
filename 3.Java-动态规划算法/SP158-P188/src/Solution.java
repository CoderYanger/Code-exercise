/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-20
 * Time: 20:27
 */
class Solution {
    //188.买卖股票的最佳时机Ⅳ
    //听了吴小哲说的，上一题做完直接写着题，发现果然一遍过，代码一模一样
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        k=Math.min(k,n/2);//这题不同于上题，有个优化：缩小k的规模
        int[][] f=new int[n][k+1];
        int[][] g=new int[n][k+1];
        int INF=-0x3f3f3f3f;
        for(int i=0;i<=k;i++) f[0][i]=g[0][i]=INF;
        f[0][0]=-prices[0];g[0][0]=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<=k;j++){
                f[i][j]=Math.max(f[i-1][j],g[i-1][j]-prices[i]);
                g[i][j]=g[i-1][j];
                if(j-1>=0) g[i][j]=Math.max(g[i][j],f[i-1][j-1]+prices[i]);
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=k;i++) max=Math.max(max,g[n-1][i]);
        return max;
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-17
 * Time: 13:17
 */
class Solution {
    //3573. 买卖股票的最佳时机 V
    public long maximumProfit(int[] p, int k) {
        int n=p.length;
        if(n<2) return 0;//不足2天无法交易
        long[][] f=new long[n][k+1];
        long[][] g=new long[n][k+1];
        //新增h[i][j]:第i天，j笔交易，手里没股票的最大利润（因为做空买入时手里不能有股票）
        long[][] h=new long[n][k+1];
        //初始化
        for(int i=0;i<k+1;i++){
            f[0][i]=-0x3f3f3f3fL;
            g[0][i]=-0x3f3f3f3fL;
            h[0][i]=-0x3f3f3f3fL;
        }
        h[0][0]=0;
        f[0][0]=-p[0];//第一天可以普通交易买入
        g[0][0]=p[0];//第0天可以做空交易卖出
        for(int i=1;i<n;i++){
            for(int j=0;j<k+1;j++){//保证交易次数对的上
                //买入状态：要么啥也不干，要么普通交易买入
                f[i][j]=Math.max(f[i-1][j],h[i-1][j]-p[i]);
                //卖出状态：要么啥也不干，要么做空交易卖出
                g[i][j]=Math.max(g[i-1][j],h[i-1][j]+p[i]);
                h[i][j]=h[i-1][j];//h[i-1][j]的状态一定存在
                if(j-1>=0){
                    //普通交易卖出，交易次数－1
                    h[i][j]=Math.max(h[i][j],f[i-1][j-1]+p[i]);
                    //做空交易买入，交易次数－1
                    h[i][j]=Math.max(h[i][j],g[i-1][j-1]-p[i]);
                }
            }
        }
        long max=Integer.MIN_VALUE;
        //取手中没股票时的最大值，因为普通买入了一定不大，做空卖出了就成骗子了
        for(int i=0;i<k+1;i++) max=(max>h[n-1][i]?max:h[n-1][i]);
        return max;
    }
}

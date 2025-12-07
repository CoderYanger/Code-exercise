/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-20
 * Time: 20:25
 */
class Solution {
    //123.买卖股票的最佳时机Ⅲ
    //看完算法原理后自己写的
    //逻辑错误：for里面还有个j的循环，我一开始没特别理解，就没写
    //疏忽：f[0][0]忘记初始化了+max定义成最大值了（笔误）
    //吴小哲的代码仅仅是在初始化部分改用了循环，但区别不大
    public int maxProfit(int[] prices) {
        int n=prices.length;int k=2;
        int[][] f=new int[n][k+1];
        int[][] g=new int[n][k+1];
        f[0][0]=-prices[0];
        f[0][1]=f[0][2]=g[0][1]=g[0][2]=-0x3f3f3f3f;
        for(int i=1;i<n;i++){
            for(int j=0;j<k+1;j++){
                f[i][j]=Math.max(f[i-1][j],g[i-1][j]-prices[i]);
                g[i][j]=g[i-1][j];
                if(j-1>=0) g[i][j]=Math.max(g[i][j],f[i-1][j-1]+prices[i]);
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k+1;i++)
            max=(max>g[n-1][i]?max:g[n-1][i]);
        return max;
    }
}
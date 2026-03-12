/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-14
 * Time: 20:36
 */
class Solution {
    //解法一：动态规划
    public double champagneTower(int p, int r, int c) {
        //dp[i][j]:第i行第j列流入香槟总量
        double[][] dp=new double[100][100];
        dp[0][0]=p;
        //i<99:避免i+1=100越界
        for(int i=0;i<99;i++){//行
            for(int j=0;j<=i;j++){//列
                if(dp[i][j]>1){
                    double half=(dp[i][j]-1)/2.0;
                    dp[i+1][j]+=half;
                    dp[i+1][j+1]+=half;
                }
            }
        }
        return Math.min(dp[r][c],1);
    }

    //解法二：BFS模拟
    public double champagneTower(int p, int r, int c) {
        //当前层每个杯子中流入的香槟总量
        double[] cur=new double[]{(double)p};
        for(int i=1;i<=r;i++){
            //下一层每个杯子中流入的香槟总量
            double[] next=new double[i+1];
            for(int j=0;j<cur.length;j++){
                //计算当前杯子j的溢出量
                double x=cur[j]-1;
                if(x>0){
                    next[j]+=x/2.0;
                    next[j+1]+=x/2.0;
                }
            }
            cur=next;
        }
        return Math.min(cur[c],1);
    }
}

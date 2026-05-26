import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-10
 * Time: 12:30
 */
class Solution {
    //3742. 网格中得分最大的路径
    public int maxPathScore(int[][] grid, int t) {
        int m=grid.length,n=grid[0].length;
        int[][][] dp=new int[m+1][n+1][t+1];
        //初始化为-1，方便后续判断不可达的情况
        for(int i=0;i<m+1;i++) for(int j=0;j<n+1;j++) Arrays.fill(dp[i][j],-1);
        //保证第一个位置可达
        for(int k=0;k<t+1;k++){dp[0][1][k]=0;dp[1][0][k]=0;};
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                for(int k=0;k<t+1;k++){
                    //计算当前位置的花费
                    int w=(grid[i-1][j-1]==2?1:grid[i-1][j-1]);
                    if(k-w>=0){
                        //判断是否可达，若为-1则不可达
                        int pre=Math.max(dp[i-1][j][k-w],dp[i][j-1][k-w]);
                        if(pre==-1) continue;
                        dp[i][j][k]=pre+grid[i-1][j-1];
                    }
                }
            }
        }
        int ret=-1;
        for(int k=0;k<t+1;k++) ret=Math.max(ret,dp[m][n][k]);
        return ret;
    }

    //空间优化
    public int maxPathScore(int[][] grid, int t) {
        int m=grid.length,n=grid[0].length;
        int[][] prev=new int[n+1][t+1];
        //初始化为-1，方便后续判断不可达的情况
        for(int j=0;j<n+1;j++) Arrays.fill(prev[j],-1);
        //保证第一个位置可达
        for(int k=0;k<t+1;k++) prev[1][k]=0;
        for(int i=1;i<=m;i++){
            int[][] curr=new int[n+1][t+1];
            for(int j=0;j<n+1;j++) Arrays.fill(curr[j],-1);
            //仅第一行左侧可达
            if(i==1) for(int k=0;k<=t;k++) curr[0][k]=0;
            for(int j=1;j<=n;j++){
                for(int k=0;k<t+1;k++){
                    //计算当前位置的花费
                    int w=(grid[i-1][j-1]==2?1:grid[i-1][j-1]);
                    if(k-w>=0){
                        //判断是否可达，若为-1则不可达
                        int pre=Math.max(prev[j][k-w],curr[j-1][k-w]);
                        if(pre==-1) continue;
                        curr[j][k]=pre+grid[i-1][j-1];
                    }
                }
            }
            prev=curr;//滚动更新，当前行变为上一行
        }
        int ret=-1;
        for(int k=0;k<t+1;k++) ret=Math.max(ret,prev[n][k]);
        return ret;
    }

    //进阶空间优化
    public int maxPathScore(int[][] grid, int t) {
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[n+1][t+1];
        //初始化为-1，方便后续判断不可达的情况
        for(int j=0;j<n+1;j++) Arrays.fill(dp[j],-1);
        //保证第一个位置可达
        for(int k=0;k<t+1;k++) dp[1][k]=0;
        for(int i=1;i<=m;i++){
            //仅第一行左侧可达
            if(i==1) for(int k=0;k<=t;k++) dp[0][k]=0;
            else Arrays.fill(dp[0],-1);
            for(int j=1;j<=n;j++){
                //计算当前位置的花费
                int w=(grid[i-1][j-1]==2?1:grid[i-1][j-1]);
                //类似0-1背包：k从大到小遍历，避免覆盖掉上一行的dp[j][k-w]
                for(int k=t;k-w>=0;k--){//if提上来成为条件
                    //判断是否可达，若为-1则不可达
                    int pre=Math.max(dp[j][k-w],dp[j-1][k-w]);
                    if(pre==-1) dp[j][k]=-1;//必须显式设为-1，否则会保留上一行的值
                    else dp[j][k]=pre+grid[i-1][j-1];
                }
                //处理k-w<0的情况，全部不可达
                for(int k=0;k<w;k++) dp[j][k]=-1;
            }
        }
        int ret=-1;
        for(int k=0;k<=t;k++) ret=Math.max(ret,dp[n][k]);
        return ret;
    }
}

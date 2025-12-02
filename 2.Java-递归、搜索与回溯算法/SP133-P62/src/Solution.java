/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-10
 * Time: 20:39
 */
class Solution {
    //62. 不同路径
    //记忆化搜索
    //按着自己的理解+稍稍瞄了一眼吴小哲的代码
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo=new int[m+1][n+1];
        return dfs(m,n);
    }
    public int dfs(int i,int j){
        if(i==0||j==0) return 0;
        if(i==1&&j==1) return 1;
        //递归前检查一下备忘录
        if(memo[i][j]!=0) return memo[i][j];
        //返回前把结果放进备忘录
        memo[i][j]=dfs(i-1,j)+dfs(i,j-1);
        return memo[i][j];
    }

    //吴小哲的解法更规范，但这里我改成了全局变量，我感觉更好理解
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo=new int[m+1][n+1];
        return dfs(m,n);
    }
    public int dfs(int i,int j){
        //递归前检查一下备忘录
        if(memo[i][j]!=0) return memo[i][j];
        if(i==0||j==0) return 0;
        if(i==1&&j==1){
            memo[i][j]=1;
            return memo[i][j];
        }
        //返回前把结果放进备忘录
        memo[i][j]=dfs(i-1,j)+dfs(i,j-1);
        return memo[i][j];
    }

    //吴小哲的动态规划解法
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        dp[1][1]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1&&j==1) continue;
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
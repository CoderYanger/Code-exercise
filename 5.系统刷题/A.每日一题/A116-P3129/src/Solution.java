import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-09
 * Time: 17:51
 */
class Solution {
    //3129. 找出所有稳定的二进制数组 I
    //解法一：暴力递归-StringBuffer→显式回溯
    private static final int MOD=1_000_000_007;
    private StringBuffer cur=new StringBuffer();
    public int numberOfStableArrays(int zero, int one, int limit) {
        return dfs(cur,zero,0,0,one,0,0,limit);
    }
    private int dfs(StringBuffer cur,int zero,int n0,int ln0,int one,int n1,int ln1,int limit){
        //递归出口
        if(cur.length()==zero+one) return 1;//找到1个

        int ret0=0,ret1=0;
        //尝试添加0
        if(n0<zero&&ln0<limit){
            cur.append("0");
            ret0=dfs(cur,zero,n0+1,ln0+1,one,n1,0,limit)%MOD;
            //回溯
            cur.deleteCharAt(cur.length()-1);
        }
        //尝试添加1
        if(n1<one&&ln1<limit){
            cur.append("1");
            ret1=dfs(cur,zero,n0,0,one,n1+1,ln1+1,limit)%MOD;
            //回溯
            cur.deleteCharAt(cur.length()-1);
        }
        return (ret0+ret1)%MOD;
    }

    //解法一：暴力递归-直接数组覆盖→隐式回溯
    private static final int MOD=1_000_000_007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        char[] cur=new char[zero+one];
        return dfs(0,cur,zero,0,0,one,0,0,limit);
    }
    private int dfs(int i,char[] cur,int zero,int n0,int ln0,int one,int n1,int ln1,int limit){
        //递归出口
        if(i==zero+one) return 1;//找到1个

        int ret0=0,ret1=0;
        //尝试添加0
        if(n0<zero&&ln0<limit){
            cur[i]='0';
            ret0=dfs(i+1,cur,zero,n0+1,ln0+1,one,n1,0,limit)%MOD;
        }
        //尝试添加1
        if(n1<one&&ln1<limit){
            cur[i]='1';
            ret1=dfs(i+1,cur,zero,n0,0,one,n1+1,ln1+1,limit)%MOD;
        }
        return (ret0+ret1)%MOD;
    }

    //解法二：记忆化搜索
    private static final int MOD=1_000_000_007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] memo=new int[zero+1][one+1][2];
        for(int[][] m1:memo)
            for(int[] m2:m1)
                Arrays.fill(m2,-1);
        return (dfs(zero,one,0,limit,memo)+dfs(zero,one,1,limit,memo))%MOD;
    }
    private int dfs(int i,int j,int k,int limit,int[][][] memo){
        if(i==0) return k==1&&j<=limit?1:0;
        if(j==0) return k==0&&i<=limit?1:0;
        if(memo[i][j][k]!=-1) return memo[i][j][k];
        if(k==0) memo[i][j][k]=(int)(1L*((dfs(i-1,j,0,limit,memo)+dfs(i-1,j,1,limit,memo))%MOD)+(i>limit?MOD-dfs(i-limit-1,j,1,limit,memo):0))%MOD;
        else memo[i][j][k]=(int)(1L*((dfs(i,j-1,0,limit,memo)+dfs(i,j-1,1,limit,memo))%MOD)+(j>limit?MOD-dfs(i,j-limit-1,0,limit,memo):0))%MOD;
        return memo[i][j][k];
    }

    //解法三：动态规划
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int MOD=1_000_000_007;
        long[][][] dp=new long[zero+1][one+1][2];
        for(int i=0;i<=Math.min(zero,limit);i++)
            dp[i][0][0]=1;
        for(int j=0;j<=Math.min(one,limit);j++)
            dp[0][j][1]=1;
        for(int i=1;i<=zero;i++){
            for(int j=1;j<=one;j++){
                long supi=i>limit?(MOD-dp[i-limit-1][j][1])%MOD:0;
                dp[i][j][0]=(dp[i-1][j][1]+dp[i-1][j][0]+supi)%MOD;
                long supj=j>limit?(MOD-dp[i][j-limit-1][0])%MOD:0;
                dp[i][j][1]=(dp[i][j-1][0]+dp[i][j-1][1]+supj)%MOD;
            }
        }
        return (int)((dp[zero][one][0]+dp[zero][one][1])%MOD);
    }
}

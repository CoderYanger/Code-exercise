import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-09-02
 * Time: 15:09
 */
class Solution {
    //1140. 石子游戏 II
    //解法：DFS（未优化，会超时）
    public int stoneGameII(int[] piles) {
        //计算后缀和，s[i]：包括 plies[i]的后缀和
        int[] s=piles;
        int n=piles.length;
        for(int i=n-2;i>=0;i--) s[i]+=s[i+1];
        //Alice 先手，dfs结果即返回值
        return dfs(0,1,s);
    }
    //dfs(i,m,s)：当前选手从 i 开始能拿到的最大石子
    private int dfs(int i,int m,int[] s){
        //能全拿走(s[i]是剩下全部石子的总和)
        if(i+m*2>=s.length) return s[i];
        //mn：对手能拿走的最大收益的最小值
        int mn=0x3f3f3f3f;
        for(int x=1;x<=m*2;x++){
            //这里的dfs从i+1开始，代表对手的最大收益
            //为啥是Math.max(m,x)而不是x？
            //因为M只能变大，不能变小，在后续过程中M变大之后，再次重新循环的时候如果还是用x，那x会从1开始遍历，但实际上M此时已经很大了，不符合游戏逻辑
            mn=Math.min(mn,dfs(i+x,Math.max(m,x),s));
        }
        //抛去对手的，就是自己的
        return s[i]-mn;
    }

    //1140. 石子游戏 II
    //解法优化：记忆化搜索
    public int stoneGameII(int[] piles) {
        //计算后缀和，s[i]：包括 plies[i]的后缀和
        int[] s=piles;
        int n=piles.length;
        for(int i=n-2;i>=0;i--) s[i]+=s[i+1];
        int[][] memo=new int[n-1][(n+1)/4+1];
        for(int[] row:memo) Arrays.fill(row,-1);//-1表示没有计算过
        //Alice 先手，dfs结果即返回值
        return dfs(0,1,s,memo);
    }
    //dfs(i,m,s)：当前选手从 i 开始能拿到的最大石子
    private int dfs(int i,int m,int[] s,int[][] memo){
        //能全拿走(s[i]是剩下全部石子的总和)
        if(i+m*2>=s.length) return s[i];
        //之前计算过
        if(memo[i][m]!=-1) return memo[i][m];
        //mn：对手能拿走的最大收益的最小值
        int mn=0x3f3f3f3f;
        for(int x=1;x<=m*2;x++){
            //这里的dfs从i+1开始，代表对手的最大收益
            //为啥是Math.max(m,x)而不是x？
            //因为M只能变大，不能变小，在后续过程中M变大之后，再次重新循环的时候如果还是用x，那x会从1开始遍历，但实际上M此时已经很大了，不符合游戏逻辑
            mn=Math.min(mn,dfs(i+x,Math.max(m,x),s,memo));
        }
        //抛去对手的，就是自己的
        return memo[i][m]=s[i]-mn;//记忆化
    }
}

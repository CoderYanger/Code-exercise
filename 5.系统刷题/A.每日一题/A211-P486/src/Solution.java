import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-08-31
 * Time: 22:28
 */
class Solution {
    //486. 预测赢家
    //解法一：递归
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        //memo[i][j]:在[i,j]区间中玩家1领先玩家2的分数
        int[][] memo=new int[n][n];
        //初始化:-0x3f3f3f3f,标记为不可达
        for(int[] t:memo) Arrays.fill(t,-0x3f3f3f3f);
        return dfs(0,n-1,memo,nums)>=0;
    }
    private int dfs(int i,int j,int[][] memo,int[] nums){
        //之前计算过
        if(memo[i][j]!=-0x3f3f3f3f) return memo[i][j];
        //递归出口：最后数组中只剩下一个数
        if(i==j) return memo[i][j]=nums[i];
        //选择最左侧的数nums[i]，玩家2从[i+1,j]继续选
        int left=nums[i]-dfs(i+1,j,memo,nums);
        //选择最右侧的数nums[j]，玩家2从[i,j-1]继续选
        int right=nums[j]-dfs(i,j-1,memo,nums);
        return memo[i][j]=Math.max(left,right);
    }

    //486. 预测赢家
    //解法二：动态规划
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int[][] f=new int[n][n];
        for(int i=n-1;i>=0;i--){
            f[i][i]=nums[i];
            for(int j=i+1;j<n;j++){
                f[i][j]=Math.max(nums[i]-f[i+1][j],nums[j]-f[i][j-1]);
            }
        }
        return f[0][n-1]>=0;
    }
    
}

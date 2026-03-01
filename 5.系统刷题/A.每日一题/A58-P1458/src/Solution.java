import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-11
 * Time: 20:46
 */
class Solution {
    //1458. 两个子序列的最大点积
    //解法一：递归
    private int[][] memo;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        memo=new int[n][m];
        for(int[] row:memo) Arrays.fill(row,0x3f3f3f3f);
        return dfs(n-1,m-1,nums1,nums2);
    }
    //从nums1[0,i]和nums2[0,j]中选两个长度相同的非空子序列的最大点积
    private int dfs(int i,int j,int[] nums1,int[] nums2){
        //其中一个数组没有元素，无法选出非空子序列
        //标记为无解，返回最小值能保证下面取最大值时不会取到无解情况
        if(i<0||j<0) return -0x3f3f3f3f;
        //先往备忘录看看
        if(memo[i][j]!=0x3f3f3f3f) return memo[i][j];
        //选nums1和nums2
        //要么和前面的子序列拼起来，要是前面子序列的和<0，就不拼，自己单独作为子序列的第一个数
        int ret1=Math.max(dfs(i-1,j-1,nums1,nums2),0)+nums1[i]*nums2[j];
        //不选nums1[i]
        int ret2=dfs(i,j-1,nums1,nums2);
        //不选nums2[j]
        int ret3=dfs(i-1,j,nums1,nums2);
        //存进备忘录
        memo[i][j]=Math.max(ret1,Math.max(ret2,ret3));
        return memo[i][j];
    }

    //解法二：动态规划
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[][] dp=new int[n+1][m+1];
        for(int[] t:dp) Arrays.fill(t,-0x3f3f3f3f);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i+1][j+1]=Math.max(Math.max(dp[i][j],0)+nums1[i]*nums2[j],Math.max(dp[i][j+1],dp[i+1][j]));
            }
        }
        return dp[n][m];
    }
}
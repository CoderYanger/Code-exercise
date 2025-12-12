/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-29
 * Time: 18:41
 */
class Solution {
    //96. 不同的二叉搜索树
    //看着算法原理自己写的，一遍过，本质上还是线性dp，只是写状态表示的思考方式变了
    //跟吴小哲写的一样
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++)
            for(int j=1;j<=i;j++)
                dp[i]+=dp[j-1]*dp[i-j];
        return dp[n];
    }
}
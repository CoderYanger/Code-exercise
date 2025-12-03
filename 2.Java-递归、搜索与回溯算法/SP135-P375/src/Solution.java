/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-10
 * Time: 22:12
 */
class Solution {
    //375. 猜数字游戏
    //吴小哲的递归解法，会超时
    int[][] memo;
    public int getMoneyAmount(int n) {
        //记忆化搜索优化
        memo=new int[n+1][n+1];
        return dfs(1,n);
    }
    public int dfs(int left,int right){
        if(left>=right) return 0;
        //1.记忆化搜索优化：递归前先看看备忘录
        if(memo[left][right]!=0) return memo[left][right];
        int ret=Integer.MAX_VALUE;
        for(int head=left;head<=right;head++){
            int x=dfs(left,head-1);
            int y=dfs(head+1,right);
            //直接猜中head时不花钱，但仍需找两个最大值中的最小值
            ret=Math.min(Math.max(x,y)+head,ret);
        }
        //2.返回前存到备忘录里
        memo[left][right]=ret;
        return ret;
    }
}
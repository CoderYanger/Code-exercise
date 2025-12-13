import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-08
 * Time: 23:42
 */
class Solution {
    //45. 跳跃游戏 II
    //吴小哲的解法，我自己真敲不出来，看完代码还是思考了很久
    public int jump(int[] nums) {
        int n=nums.length;
        int left=0,right=0,maxpos=0,ret=0;
        while(left<=right){//以防跳不到n-1的位置
            //判断是否能跳到最后一个位置
            if(maxpos>=n-1) return ret;
            //更新下一层的最右端点
            for(int i=left;i<=right;i++) maxpos=Math.max(nums[i]+i,maxpos);
            left=right+1;
            right=maxpos;
            ret++;
        }
        return ret;
    }

    public int jump2(int[] nums) {
        //动态规划写法，自己功底还是好差，AI帮我弄的，主要不会的点在初始化、和dp[i]的更新上
        int n=nums.length;
        if(n<=1) return 0;
        int[] dp=new int[n];
        Arrays.fill(dp,0x3f3f3f3f);
        dp[0]=0;
        for(int i=1;i<n;i++)
            for(int j=0;j<i;j++)
                if(nums[j]+j>=i)
                    dp[i]=Math.min(dp[i],dp[j]+1);
        return dp[n-1];
    }
}
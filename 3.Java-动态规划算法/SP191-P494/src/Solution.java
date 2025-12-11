/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-28
 * Time: 19:38
 */
class Solution {
    //494. 目标和
    //看着算法原理自己写了一下，对比吴小哲的代码之后发现有几个没注意到的错误：
    //没注意到用a是正数来处理边界情况
    //没注意到有a是奇数时属于找不到目标值而返回
    //没注意到j要从0开始，直接跟往常一样写的1
    //没注意到下标映射关系
    //以下是未优化的版本
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        //b代表负数的和，取不取绝对值无所谓，因为消的就是b
        // for(int x:nums) if(x>=0) sum+=x; else sum+=(-x);//b取绝对值了
        for(int x:nums) sum+=x;//b没取绝对值
        int a=(target+sum)/2;//a表示所有正数的和
        if(a<0||(sum+target)%2==1) return 0;//处理边界情况
        //这个余数为1的情况我写的时候也注意到了，只是不知道咋解决
        int[][] dp=new int[n+1][a+1];
        //初始化
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            //这里j从0开始！需要用填表逻辑来填写
            for(int j=0;j<=a;j++){
                dp[i][j]=dp[i-1][j];
                //注意下标的映射关系
                if(j>=nums[i-1]) dp[i][j]+=dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][a];
    }
    
    //以下是空间优化的版本
    //二维降一维
    //修改遍历顺序
    public int findTargetSumWays1(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        //b代表负数的和，取不取绝对值无所谓，因为消的就是b
        // for(int x:nums) if(x>=0) sum+=x; else sum+=(-x);//b取绝对值了
        for(int x:nums) sum+=x;//b没取绝对值
        int a=(target+sum)/2;//a表示所有正数的和
        if(a<0||(sum+target)%2==1) return 0;//处理边界情况
        //这个余数为1的情况我写的时候也注意到了，只是不知道咋解决
        int[] dp=new int[a+1];
        //初始化
        dp[0]=1;
        for(int i=1;i<=n;i++){
            //这里j从0开始！需要用填表逻辑来填写
            for(int j=a;j>=nums[i-1];j--){//修改遍历顺序,时间上有常数级提升
                // dp[i][j]=dp[i-1][j];
                //注意下标的映射关系
                dp[j]+=dp[j-nums[i-1]];
            }
        }
        return dp[a];
    }
}
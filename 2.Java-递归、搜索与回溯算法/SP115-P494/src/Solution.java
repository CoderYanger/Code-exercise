/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-02
 * Time: 23:31
 */
class Solution {
    //自己写了一遍之后找豆包改的，注释处是改动点
    int[] path;
    int ret,n;
    public int findTargetSumWays(int[] nums, int target) {
        path=new int[nums.length];
        ret=0;n=0;
        dfs(nums,target);
        return ret;
    }
    public void dfs(int[] nums,int target){
        if(n==nums.length){//不是path.length==nums.length因为这一直成立
            int sum=0;
            for(int x:path) sum+=x;
            if(sum==target) ret++;
            return ;
        }
        //加号
        path[n]=nums[n++];
        dfs(nums,target);
        n--;//无需手动置为0：path[n--]=0;因为如果dfs时已经满足返回条件，那这一句就会数组越界
        //减号
        path[n]=-nums[n++];
        dfs(nums,target);
        n--;//回溯到当前索引
    }
    //吴小哲教的path全局变量写法
    int ret,aim,path;
    public int findTargetSumWays(int[] nums, int target) {
        ret=0;aim=target;
        dfs(nums,0);
        return ret;
    }
    public void dfs(int[] nums,int pos){
        if(pos==nums.length){
            if(path==aim) ret++;
            return ;
        }
        //加法
        path+=nums[pos];
        dfs(nums,pos+1);
        path-=nums[pos];//恢复现场
        //减法
        path-=nums[pos];
        dfs(nums,pos+1);
        path+=nums[pos];//恢复现场
    }
    //吴小哲教的path局部变量写法
    int ret,aim;
    public int findTargetSumWays(int[] nums, int target) {
        ret=0;aim=target;
        dfs(nums,0,0);
        return ret;
    }
    public void dfs(int[] nums,int pos,int path){
        if(pos==nums.length){
            if(path==aim) ret++;
            return ;
        }
        //加法
        dfs(nums,pos+1,path+nums[pos]);
        //减法
        dfs(nums,pos+1,path-nums[pos]);
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-06
 * Time: 16:09
 */
class Solution {
    //3891. 最大化特殊下标数目的最少增加次数
    //三元表达式写法
    public long minIncrease(int[] nums) {
        int n=nums.length;
        long ret=0;
        if(n%2==1) return checkmin(nums,1,n);
        //预处理cost数组
        long[] cost=new long[n];
        for(int i=1;i<n-1;i++){
            int t=Math.max(nums[i-1],nums[i+1])+1;
            cost[i]=t>nums[i]?t-nums[i]:0;
        }
        long[][] dpcnt=new long[n][2];
        long[][] dpcost=new long[n][2];
        dpcnt[1][0]=0;dpcnt[1][1]=1;
        dpcost[1][0]=0;dpcost[1][1]=cost[1];
        for(int i=2;i<n-1;i++){
            //不选
            dpcnt[i][0]=Math.max(dpcnt[i-1][0],dpcnt[i-1][1]);
            dpcost[i][0]=dpcnt[i-1][0]>dpcnt[i-1][1]?dpcost[i-1][0]:(dpcnt[i-1][0]<dpcnt[i-1][1]?dpcost[i-1][1]:Math.min(dpcost[i-1][0],dpcost[i-1][1]));
            //选
            dpcnt[i][1]=dpcnt[i-1][0]+1;
            dpcost[i][1]=dpcost[i-1][0]+cost[i];
        }
        return dpcnt[n-2][0]>dpcnt[n-2][1]?dpcost[n-2][0]:(dpcnt[n-2][0]<dpcnt[n-2][1]?dpcost[n-2][1]:Math.min(dpcost[n-2][0],dpcost[n-2][1]));
    }
    private long checkmin(int[] nums,int index,int n){
        long cnt=0;
        while(index+1<n){
            int t=Math.max(nums[index-1],nums[index+1])+1;
            cnt+=t>nums[index]?t-nums[index]:0;
            index+=2;
        }
        return cnt;
    }

    //if-else写法
    public long minIncrease(int[] nums) {
        int n=nums.length;
        long ret=0;
        if(n%2==1) return checkmin(nums,1,n);
        //预处理cost数组
        long[] cost=new long[n];
        for(int i=1;i<n-1;i++){
            int t=Math.max(nums[i-1],nums[i+1])+1;
            cost[i]=t>nums[i]?t-nums[i]:0;
        }
        long[][] dpcnt=new long[n][2];
        long[][] dpcost=new long[n][2];
        dpcnt[1][0]=0;dpcnt[1][1]=1;
        dpcost[1][0]=0;dpcost[1][1]=cost[1];
        for(int i=2;i<n-1;i++){
            //不选
            dpcnt[i][0]=Math.max(dpcnt[i-1][0],dpcnt[i-1][1]);
            if(dpcnt[i-1][0]>dpcnt[i-1][1]) dpcost[i][0]=dpcost[i-1][0];
            else if(dpcnt[i-1][0]<dpcnt[i-1][1]) dpcost[i][0]=dpcost[i-1][1];
            else dpcost[i][0]=Math.min(dpcost[i-1][0],dpcost[i-1][1]);
            //选
            dpcnt[i][1]=dpcnt[i-1][0]+1;
            dpcost[i][1]=dpcost[i-1][0]+cost[i];
        }
        if(dpcnt[n-2][0]>dpcnt[n-2][1]) return dpcost[n-2][0];
        else if(dpcnt[n-2][0]<dpcnt[n-2][1]) return dpcost[n-2][1];
        else return Math.min(dpcost[n-2][0],dpcost[n-2][1]);
    }
    private long checkmin(int[] nums,int index,int n){
        long cnt=0;
        while(index+1<n){
            int t=Math.max(nums[index-1],nums[index+1])+1;
            cnt+=t>nums[index]?t-nums[index]:0;
            index+=2;
        }
        return cnt;
    }


    //滚动数组空间优化
    public long minIncrease(int[] nums) {
        int n=nums.length;
        long ret=0;
        if(n%2==1) return checkmin(nums,1,n);
        //预处理cost数组
        long[] cost=new long[n];
        for(int i=1;i<n-1;i++){
            int t=Math.max(nums[i-1],nums[i+1])+1;
            cost[i]=t>nums[i]?t-nums[i]:0;
        }
        long dpcnt0=0,dpcnt1=1;
        long dpcost0=0,dpcost1=cost[1];
        for(int i=2;i<n-1;i++){
            long olddpcnt0=dpcnt0,olddpcnt1=dpcnt1;
            long olddpcost0=dpcost0,olddpcost1=dpcost1;
            //不选
            dpcnt0=Math.max(olddpcnt0,olddpcnt1);
            if(olddpcnt0>olddpcnt1) dpcost0=olddpcost0;
            else if(olddpcnt0<olddpcnt1) dpcost0=olddpcost1;
            else dpcost0=Math.min(olddpcost0,olddpcost1);
            //选
            dpcnt1=olddpcnt0+1;
            dpcost1=olddpcost0+cost[i];
        }
        if(dpcnt0>dpcnt1) return dpcost0;
        else if(dpcnt0<dpcnt1) return dpcost1;
        else return Math.min(dpcost0,dpcost1);
    }
    private long checkmin(int[] nums,int index,int n){
        long cnt=0;
        while(index+1<n){
            int t=Math.max(nums[index-1],nums[index+1])+1;
            cnt+=t>nums[index]?t-nums[index]:0;
            index+=2;
        }
        return cnt;
    }
}

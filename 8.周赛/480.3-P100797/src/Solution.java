/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-14
 * Time: 12:31
 */
class Solution {
    //100797. 使循环数组余额非负的最少移动次数
    public long minMoves(int[] nums) {
        long sum=0;int k=-1;//记录负数出现的位置
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<0) k=i;
            sum+=nums[i];
        }
        if(sum<0) return -1L;
        if(k==-1) return 0L;
        long need=-nums[k];
        long ret=0L;
        //d为距离负数的位置
        int d=1;
        while(need>0){
            //处理左侧位置
            int leftpos=(k-d+n)%n;
            int takeleft=Math.min(nums[leftpos],(int)need);
            ret+=(long)takeleft*d;
            need-=takeleft;
            if(need==0) break;
            //处理右侧位置
            int rightpos=(k+d+n)%n;
            int takeright=Math.min(nums[rightpos],(int)need);
            ret+=(long)takeright*d;
            need-=takeright;
            if(need==0) break;
            d++;
        }
        return ret;
    }
}
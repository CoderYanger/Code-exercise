/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-03
 * Time: 13:25
 */
class Solution {
    //3824. 减小数组使其满足条件的最小 K 值
    public int minimumK(int[] nums) {
        long sum=0;
        //右边界为数组最大值
        int left=1,right=0;
        int max=0;
        for(int x:nums){
            max=Math.max(max,x);
            sum+=x;
        }
        right=Math.max(max,(int)Math.sqrt(sum)+1);
        while(left<right){
            int mid=left+(right-left)/2;
            if(check(mid,nums)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    private boolean check(int mid,int[] nums){
        long sum=0;
        //计算所有元素的操作次数
        for(int x:nums) sum+=(x-1)/mid+1;
        return sum>(long)mid*mid;
    }
}
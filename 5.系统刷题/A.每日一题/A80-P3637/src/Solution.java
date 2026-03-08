/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-03
 * Time: 12:38
 */
class Solution {
    //3637. 三段式数组 I
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        if(n==3) return false;
        if(nums[0]>=nums[1]) return false;
        int[] d=new int[n-1];
        for(int i=0;i<n-1;i++) d[i]=nums[i+1]-nums[i];
        int count=0;
        for(int i=1;i<n-1;i++){
            if(d[i]==0) return false;
            if((d[i-1]>0&&d[i]>0)||(d[i-1]<0&&d[i]<0)) continue;
            count++;
        }
        return count==2;
    }
}
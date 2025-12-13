import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-02
 * Time: 17:56
 */
class Solution {
    //334. 递增的三元子序列
    //模仿着上一题的思路写的，基本上一模一样，就是加了个判断
    //对二分的知识有点遗忘了，一边看着300的题的代码一边写的
    public boolean increasingTriplet(int[] nums) {
        ArrayList<Integer> ret=new ArrayList<>();
        int n=nums.length;
        ret.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]>ret.get(ret.size()-1)) ret.add(nums[i]);
            else{
                int left=0,right=ret.size()-1;
                while(left<right){
                    int mid=left+(right-left)/2;
                    if(ret.get(mid)<nums[i]) left=mid+1;
                    else right=mid;
                }
                ret.set(left,nums[i]);
            }
            if(ret.size()==3) return true;
        }
        return false;
    }
    //吴小哲的解法，更易懂些
    public boolean increasingTriplet(int[] nums) {
        int a=nums[0],b=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>b) return true;
            else if(nums[i]>a) b=nums[i];
            else a=nums[i];
        }
        return false;
    }
}
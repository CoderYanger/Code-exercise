import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-01
 * Time: 00:02
 */
class Solution {
    //300.最长递增子序列
    public int lengthOfLIS(int[] nums) {
        //贪心解法：自己真写不出来，看了吴小哲的代码还琢磨琢磨才弄上的
        //当已经是2.4.7.13时再来个8是把13覆盖掉的
        ArrayList<Integer> ret=new ArrayList<>();
        int n=nums.length;
        ret.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]>ret.get(ret.size()-1)) ret.add(nums[i]);
            else{
                int left=0,right=ret.size()-1;
                while(left<right){
                    int mid=(left+right)/2;
                    if(ret.get(mid)<nums[i]) left=mid+1;
                    else right=mid;
                }
                ret.set(left,nums[i]);
            }
        }
        return ret.size();
    }
}
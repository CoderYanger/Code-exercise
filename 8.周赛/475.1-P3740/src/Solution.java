/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 14:38
 */
class Solution {
    //3740.三个相等元素之间的最小距离 I
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        if(n<3) return -1;
        int ret=0x3f3f3f3f;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]==nums[j]&&nums[j]==nums[k])
                        ret=Math.min(ret,Math.abs(i-j)+
                                Math.abs(j-k)+Math.abs(k-i));
                }
            }
        }
        return ret==0x3f3f3f3f?-1:ret;
    }
}
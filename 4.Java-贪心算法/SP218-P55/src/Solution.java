/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 15:04
 */
class Solution {
    //55.跳跃游戏
    //跟上一题45.跳跃游戏Ⅱ一样，就是改了个返回值
    //看完吴小哲的代码之后自己敲的
    public boolean canJump(int[] nums) {
        int left=0,right=0,n=nums.length,maxpos=0;
        while(left<=right){//循环每一层，left>right时，证明maxpos无法往后更新了，这题体现出来了
            if(maxpos>=n-1) return true;
            for(int i=left;i<=right;i++)//直至找到最远的位置
                maxpos=Math.max(nums[i]+i,maxpos);
            left=right+1;
            right=maxpos;
        }
        return false;
    }
}
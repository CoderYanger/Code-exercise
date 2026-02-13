/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-17
 * Time: 18:15
 */
class Solution {
    //1437. 是否所有 1 都至少相隔 k 个元素
    public boolean kLengthApart(int[] nums, int k) {
        //感觉跟2511题解题思路差不多，同样是找两个点之间的距离
        //可以用双指针优化
        int n=nums.length;
        int prev=-1;//记录上一个1的位置
        int dis=0;//记录两个1之间的距离
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                if(prev!=-1){
                    dis=i-prev-1;
                    if(dis<k) return false;
                }
                prev=i;//更新
            }
        }
        return true;
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-05
 * Time: 18:14
 */
class Solution {
    //3379. 转换数组
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] ret=new int[n];
        for(int i=0;i<n;i++){
            //计算新索引位置
            int index=i;
            if(nums[i]!=0) index+=nums[i];
            //处理越界情况
            if(index>=n||index<0) index=(index%n+n)%n;
            ret[i]=nums[index];
        }
        return ret;
    }
}
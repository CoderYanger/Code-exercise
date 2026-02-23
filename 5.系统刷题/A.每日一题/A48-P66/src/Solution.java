/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-01
 * Time: 12:56
 */
class Solution {
    //66. 加一
    public int[] plusOne(int[] nums) {
        int n=nums.length;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<9){
                nums[i]++;//进位
                return nums;
            }
            nums[i]=0;//进位数字右边全变成0
        }
        //全是9时
        int[] ret=new int[n+1];
        ret[0]=1;
        return ret;
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 14:42
 */
class Solution {
    //3688.偶数的按位或运算
    public int evenNumberBitwiseORs(int[] nums) {
        int ret=0;
        for(int x:nums){
            if(x%2==0){
                ret|=x;
            }
        }
        return ret;
    }
}
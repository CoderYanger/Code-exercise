/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-29
 * Time: 18:42
 */
class Solution {
    //3300. 替换为数位和以后的最小元素
    public int minElement(int[] nums) {
        int min=0x3f3f3f3f;
        for(int x:nums){
            int t=0;
            while(x>0){
                t+=x%10;
                x/=10;
            }
            min=Math.min(min,t);
        }
        return min;
    }
}

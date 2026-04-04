/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-12
 * Time: 20:22
 */
class Solution {
    //1470. 重新排列数组
    //0ms击败100.00%
    public int[] shuffle(int[] nums, int n) {
        int[] ret=new int[2*n];
        int index1=0,id=0;
        for(int i=0;i<n;i++,id+=2) ret[id]=nums[i];
        id=1;
        for(int i=n;i<2*n;i++,id+=2) ret[id]=nums[i];
        return ret;
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-15
 * Time: 10:13
 */
class Solution {
    //101014. 找到第一个唯一偶数
    public int firstUniqueEven(int[] nums) {
        int[] hash=new int[101];
        for(int x:nums) hash[x]++;
        for(int x:nums)
            if(x%2==0&&hash[x]==1)
                return x;
        return -1;
    }
}
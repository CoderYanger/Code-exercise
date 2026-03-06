import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-20
 * Time: 19:18
 */
class Solution {
    //3315. 构造最小位运算数组 II
    //解法二：位运算
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ret=new int[nums.size()];
        int index=0;
        for(int x:nums){
            if(x==2) ret[index++]=-1;
            else{
                //写法一
                //int lowbit=(x+1)&~x;
                //写法二
                int lowbit=(~x)&-(~x);
                ret[index++]=x^(lowbit>>1);
            }
        }
        return ret;
    }
}
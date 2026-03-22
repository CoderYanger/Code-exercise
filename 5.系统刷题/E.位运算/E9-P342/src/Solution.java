/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-04
 * Time: 13:50
 */
class Solution {
    //342. 4的幂
    //写法一：仅一个1+该1在第偶数位
    public boolean isPowerOfFour(int n) {
        return Integer.bitCount(n)==1&&((32-Integer.numberOfLeadingZeros(n))%2==1);
    }

    //写法二：类似A.每日一题——231. 2 的幂写法二：n&(n-1)
    public boolean isPowerOfFour(int n) {
        return n>0&&((n&(n-1))==0)&(n&0x55555555)>0;
    }

    //写法三：二项式定理
    public boolean isPowerOfFour(int n) {
        return n>0&&((n&(n-1))==0)&(n%3==1);
    }

}

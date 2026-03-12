/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-18
 * Time: 20:09
 */
class Solution {

    //解法一的写法一：
    public boolean isPowerOfTwo(int n) {
        return n>0&&Integer.bitCount(n)==1;
    }

    //解法一的写法二：
    public boolean isPowerOfTwo(int n) {
        return n>0&&(n&(n-1))==0;
    }

    //解法一的写法三：
    public boolean isPowerOfTwo(int n) {
        return n>0&&(n&-n)==n;
    }

    //解法二：判断是否为最大 2 的幂的约数
    public boolean isPowerOfTwo(int n) {
        return n>0&&(1<<30)%n==0;
    }

}

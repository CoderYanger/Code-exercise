/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-04
 * Time: 22:37
 */
class Solution {
    //191. 位1的个数
    //解法一：库方法
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    //解法二：循环检查二进制位
    public int hammingWeight(int n) {
        int ret=0;
        for(int i=0;i<32;i++)
            if((n&(1<<i))!=0) ret++;
        return ret;
    }

    //解法三：n&(n-1)
    public int hammingWeight(int n) {
        int ret=0;
        while(n!=0){
            n&=n-1;
            ret++;
        }
        return ret;
    }

}

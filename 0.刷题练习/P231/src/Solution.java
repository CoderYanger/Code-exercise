/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-17
 * Time: 11:20
 */
class Solution {
    //231. 2 的幂
    /*给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
    如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
    示例 1：
    输入：n = 1
    输出：true
    解释：20 = 1
    示例 2：
    输入：n = 16
    输出：true
    解释：24 = 16
    示例 3：
    输入：n = 3
    输出：false
    提示：
            -231 <= n <= 231 - 1*/
    public boolean isPowerOfTwo(int n) {
        if(n==1)return true;
        int num=n;
        int remainder=(n%2);
        int i=0;
        while(num!=0){
            remainder%=2;
            if(remainder!=0)return false;
            i++;
            if((int)Math.pow(2,i)==n)return true;
            num/=2;
        }
        return false;
    }
}
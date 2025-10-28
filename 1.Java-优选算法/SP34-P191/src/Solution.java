import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-02
 * Time: 18:56
 */
class Solution {
    //191. 位1的个数
    /*给定一个正整数 n，编写一个函数，
    获取一个正整数的二进制形式并返回其二进制表达式中 设置位 的个数（也被称为汉明重量）。
    示例 1：
    输入：n = 11
    输出：3
    解释：输入的二进制串 1011 中，共有 3 个设置位。
    示例 2：
    输入：n = 128
    输出：1
    解释：输入的二进制串 10000000 中，共有 1 个设置位。
    示例 3：
    输入：n = 2147483645
    输出：30
    解释：输入的二进制串 1111111111111111111111111111101 中，共有 30 个设置位。
    提示：
            1 <= n <= 231 - 1
    进阶：
    如果多次调用这个函数，你将如何优化你的算法？*/
    public int hammingWeight1(int n) {
        //用自己的想法写的，通过了
        int count=0;
        List<Integer> list = new ArrayList<>();
        while(n!=0){
            list.add(0,(n%2));
            n/=2;
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i)==1) count++;
        }
        return count;
    }
    public int hammingWeight2(int n) {
        //网友的思路，更简单
        int ret=0;
        while(n!=0){
            ret+=n&1;//这个1等同于0000~~001，n前面的全被1消掉了，
            //所以得到的是n的最后一个二进制位
            n>>=1;//>>左补符号位，>>>左补0，这里无所谓，因为n是正数，都是补0
        }
        return ret;
    }
    public int hammingWeight(int n) {
        //吴小哲的方法，只要n！=0就是还有1未统计
        //先给ret++
        //然后用n&(n-1)干掉最右边的1，以此循环
        int ret=0;
        while(n!=0){
            ret++;
            n&=(n-1);
        }
        return ret;
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-03
 * Time: 14:36
 */
class Solution {
    //371. 两整数之和
    /*给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
    示例 1：
    输入：a = 1, b = 2
    输出：3
    示例 2：
    输入：a = 2, b = 3
    输出：5
    提示：
            -1000 <= a, b <= 1000*/
    public int getSum(int a, int b) {
        while(b!=0){
            int x=a^b;//计算无进位结果
            int carry=(a&b)<<1;//计算进位
            a=x;
            b=carry;//b用过一次之后就没用了，正好拿来当进位
            //解决了carry在外部定义才能用的弊端
        }
        return a;
    }
}

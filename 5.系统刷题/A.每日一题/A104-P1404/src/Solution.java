/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-26
 * Time: 16:54
 */
import java.math.BigInteger;
class Solution {
    //1404. 将二进制表示减到 1 的步骤数
    //解法一：位运算思维
    public int numSteps(String s) {
        BigInteger x=new BigInteger(s,2);
        int ret=0;
        while(!x.equals(BigInteger.ONE)){
            //奇数：末位是1，需要+1
            if(x.testBit(0)) x=x.add(BigInteger.ONE);
                //偶数：右移一位=除以2
            else x=x.shiftRight(1);
            ret++;
        }
        return ret;
    }

    //解法二：模拟
    public int numSteps(String s) {
        int n=s.length();
        int ret=n-1;
        int carry=0;
        for(int i=n-1;i>0;i--){
            //当前位数字+进位
            int sum=s.charAt(i)-'0'+carry;
            //sum%2==1，是奇数，需要加上+1那步再÷2
            ret+=sum%2;
            //计算新进位
            //sum是奇数，+1后进位1，sum是偶数，不进位
            carry=(sum+sum%2)/2;
        }
        return ret+carry;
    }

    //解法三：找规律
    public int numSteps(String s) {
        //基础步数：所有位最终都要÷2移走
        int ret=s.length()-1;
        //找到最右边的那个1的位置i
        int i=s.lastIndexOf('1');
        //如果这个1不在最高位(i>0)，说明需要额外步数
        if(i>0){
            //统计：最高位~i左边之间有多少个0
            //'1'-s.charAt(j)：是0就+1，是1就+0
            for(int j=1;j<i;j++) ret+='1'-s.charAt(j);
            //最右边的1是奇数，固定多走2步（+1，÷2）
            ret+=2;
        }
        return ret;
    }
}

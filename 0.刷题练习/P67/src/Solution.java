import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-14
 * Time: 09:17
 */
class Solution {
    /*给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
    示例 1：
    输入:a = "11", b = "1"
    输出："100"
    示例 2：
    输入：a = "1010", b = "1011"
    输出："10101"
    提示：
            1 <= a.length, b.length <= 104
    a 和 b 仅由字符 '0' 或 '1' 组成
    字符串如果不是 "0" ，就不含前导零*/

    //自己的想法，但是被力扣难为住了，给我弄老大老大的数值，导致我这个溢出了
    public String addBinary2(String a, String b) {
        List<Long> ArrayList=new  java.util.ArrayList<>();
        long A=0;long B=0;
        long k=0;
        for(int i=a.length()-1;i>=0;i--){
            A+=(a.charAt(i)-'0')*Math.pow(2,k++);
        }
        k=0;
        for(int i=b.length()-1;i>=0;i--){
            B+=(b.charAt(i)-'0')*Math.pow(2,k++);
        }
        long C= A+B;
        if(C==0)return "0";
        while(C>0){
            ArrayList.add(C%2);
            C/=2;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=ArrayList.size()-1;i>=0;i--){
            sb.append(ArrayList.get(i));
        }
        return sb.toString();
    }
    //豆包给的，但我进行了小范围优化，更易懂些
        public String addBinary(String a, String b) {
            StringBuilder sb=new StringBuilder();
            int i=a.length()-1;
            int j=b.length()-1;
            int sum=0;//存总和，累计起来，没除完接着除
            while(i>=0||j>=0||sum>0){
                if(i>=0)sum+=a.charAt(i--)-'0';
                if(j>=0)sum+=b.charAt(j--)-'0';
                sb.append(sum%2);
                sum/=2;
            }
            return sb.reverse().toString();
        }
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101","110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}
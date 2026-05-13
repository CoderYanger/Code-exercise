/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:40
 */
import java.util.*;

public class Main {
    //类斐波那契循环数
    public static void main(String[] args) {
        for(int i=1000_0000;i>0;i--){
            if(check(i)){
                System.out.println(i);
                break;
            }
        }
    }
    private static boolean check(int x){
        //将数字转换成字符串
        String s=x+"";
        //获取数字位数
        int len=s.length();
        //dp数组：存储x拆分后的每一位数字
        int[] dp=new int[len];
        //将字符串的每一位字符转回数字存入dp数组
        for(int i=0;i<len;i++) dp[i]=s.charAt(i)-'0';
        //sum:每一轮迭代的数组和
        int sum=0;
        for(int i=len;sum<x;i++){
            //计算当前dp数组所有元素的和
            sum=0;
            for(int j=0;j<len;j++) sum+=dp[j];
            //把sum循环覆盖到dp数组的对应位置
            dp[i%len]=sum;
        }
        return sum==x;
    }
}
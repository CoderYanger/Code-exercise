/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:52
 */
import java.util.Scanner;
public class Main {
    //幸运数字
    //暴力模拟的超时代码
    private static final char[] chars={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public static void main(String[] args) {
        int cnt=10;
        for(int i=127;;i++){
            //获取该数2进制
            String tw=turn(i,2);
            if(!check(tw,i)) continue;
            if(!check(String.valueOf(i),i)) continue;
            //获取该数8进制
            String ei=turn(i,8);
            if(!check(ei,i)) continue;
            //获取该数16进制
            String si=turn(i,16);
            if(!check(si,i)) continue;
            cnt++;
            if(cnt==2023){
                System.out.println(i);
                break;
            }
        }
    }
    //转换进制
    private static String turn(int n,int r){
        StringBuffer cur=new StringBuffer();
        int t=n;
        while(t>0){
            int rem=t%r;
            if(r==16) cur.append(chars[rem]);
            else cur.append(rem+'0');
            t/=r;
        }
        return cur.reverse().toString();
    }
    //判断该数十进制能否能否整除该进制位各位数之和
    private static boolean check(String x,int n){
        //获取该数在该进制下各位数字之和
        int sum=0;
        for(int i=0;i<x.length();i++){
            char rem=x.charAt(i);
            sum+=(rem>='0'&&rem<='9')?rem-'0':rem-'a'+10;
        }
        return n%sum==0;
    }

    //优化后的AC代码
    public static void main(String[] args) {
        int cnt=10;
        for(int i=127;;i++){
            //判断2进制
            if(i%Integer.bitCount(i)!=0) continue;
            //判断10进制
            if(!check(i,10)) continue;
            //判断8进制
            if(!check(i,8)) continue;
            //判断16进制
            if(!check(i,16)) continue;
            cnt++;
            if(cnt==2023){
                System.out.println(i);
                break;
            }
        }
    }
    //判断该数十进制能否能否整除该进制位各位数之和
    private static boolean check(int n,int r){
        //获取该数在该进制下各位数字之和
        int sum=0;
        int t=n;
        while(t>0){
            int rem=t%r;
            sum+=rem;
            t/=r;
        }
        return n%sum==0;
    }
    
}
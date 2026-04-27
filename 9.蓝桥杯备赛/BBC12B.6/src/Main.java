/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:40
 */
import java.util.*;
public class Main {
    //时间显示
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        long n=sc.nextLong();
        //计算出当前的秒数
        long s=n/1000%(24*60*60);
        //计算出当前的分钟
        //先/60取出总分钟数，再%60取余数做最终分钟数
        long m=s/60%60;
        //计算出当前的小时
        //1h=3600s
        long h=s/3600;
        //秒用完了，取余数作最终秒数结果
        s%=60;
        System.out.print(adjust(h)+":"+adjust(m)+":"+adjust(s));
        sc.close();
    }
    //补前导0
    private static String adjust(long x){
        if(x<10) return "0"+String.valueOf(x);
        return String.valueOf(x);
    }
}

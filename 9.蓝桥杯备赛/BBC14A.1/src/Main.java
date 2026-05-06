/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:58
 */
import java.util.Scanner;

public class Main {
    //特殊日期
    public static void main(String[] args) {
        int ret=0;
        for(int i=1900;i<9999;i++){//枚举年份
            //计算年份各位的和
            String s=i+"";
            int sum=0;
            for(char c:s.toCharArray()) sum+=c-'0';
            for(int j=1;j<=12;j++){//枚举月份
                int n=0;//确定天数
                if(j==1||j==3||j==5||j==7||j==8||j==10||j==12) n=31;
                else if(j==2){
                    //闰年
                    boolean isleap=(i%4==0&&i%100!=0)||(i%400==0);
                    if(isleap) n=29;
                        //平年
                    else n=28;
                }else n=30;
                for(int k=1;k<=n;k++){
                    if(sum==getsum(j)+getsum(k)) ret++;
                }
            }
        }
        System.out.println(ret);
    }
    //获取各数位上的和
    private static int getsum(int n){
        int ret=0;
        while(n>0){
            ret+=n%10;
            n/=10;
        }
        return ret;
    }
}
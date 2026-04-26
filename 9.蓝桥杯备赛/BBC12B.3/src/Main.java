/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:37
 */
import java.util.*;
public class Main{
    //直线
    public static void main(String[] args){
        Set<String> hash=new HashSet<>();
        for(int x1=0;x1<20;x1++){
            for(int x2=0;x2<20;x2++){
                for(int y1=0;y1<21;y1++){
                    for(int y2=0;y2<21;y2++){
                        //横直线和竖直线后续处理，因为没办法代入公式
                        if(x1==x2||y1==y2) continue;
                        //计算直线斜率k
                        int Y=y2-y1;
                        int X=x2-x1;
                        //求最大公约数用于约分
                        int gcdK=gcd(X,Y);
                        //约分后的斜率
                        String k=(Y/gcdK)+"/"+(X/gcdK);
                        //通过y=kx+b推导出b
                        // 由y=kx+b推导：b=y1-k*x1=(y1*Δx-x1*Δy)/Δx
                        //b的分子
                        int b1=y1*X-x1*Y;
                        int b2=X;
                        //求最大公约数用于约分
                        int gcdb=gcd(b1,b2);
                        String b=(b1/gcdb)+"/"+(b2/gcdb);
                        String line=k+"+"+b;
                        //将直线加入Set，自动去重
                        hash.add(line);
                    }
                }
            }
        }
        //斜线数量+竖直线数量20+水平线数量21
        System.out.println(hash.size()+20+21);
    }
    //辗转相除法求最大公约数
    private static int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}

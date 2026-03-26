/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-10
 * Time: 21:02
 */
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    //数位倍数
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int cnt=0;
        for(int i=1;i<=202504;i++){
            int t=i,sum=0;
            while(t!=0){
                sum+=(t%10);
                t/=10;
            }
            if(sum%5==0) cnt++;
        }
        System.out.println(cnt);
        scan.close();
    }
}
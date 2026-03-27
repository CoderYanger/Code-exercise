/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-10
 * Time: 21:03
 */
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    //2025
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int cnt=0;
        for(int i=1;i<=20250412;i++){
            int t=i,cnt0=0,cnt2=0,cnt5=0;
            while(t!=0){
                int cur=t%10;
                if(cur==0) cnt0++;
                else if(cur==2) cnt2++;
                else if(cur==5) cnt5++;
                t/=10;
                if(cnt0>=1&&cnt2>=2&&cnt5>=1){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
        scan.close();
    }
}
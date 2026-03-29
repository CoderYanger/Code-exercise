/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-10
 * Time: 21:15
 */
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    //逃离高塔
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int cnt=0;
        for(int i=1;i<=2025;i++){
            long sum=1L*i*i*i;
            if(sum%10==3) cnt++;
        }
        System.out.println(cnt);
        scan.close();
    }
}

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
    //消失的蓝宝
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        //(N+20250412)=a*20240413
        //(N+20240413)=b*20250412
        //20250412-20240413=a*20240413-b*20250412
        //(a+1)*20240413=(b+1)*20250412
        //a=20250411
        System.out.println(20250411L*20240413L-20250412L);
        scan.close();
    }
}
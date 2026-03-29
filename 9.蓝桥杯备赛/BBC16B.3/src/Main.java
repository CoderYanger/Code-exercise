/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-10
 * Time: 21:16
 */
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    //电池分组
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //在此输入您的代码...
        //获取测试用例数量T
        int T=sc.nextInt();
        for(int i=0;i<T;i++){
            //获取此次测试用例的电池总数
            int N=sc.nextInt();
            int t=0;
            for(int j=0;j<N;j++){
                t^=sc.nextInt();
            }
            if(t==0) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }
}
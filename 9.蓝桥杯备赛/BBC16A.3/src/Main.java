/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-10
 * Time: 21:09
 */
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    //变换数组
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n=scan.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++) a[i]=scan.nextInt();
        int m=scan.nextInt();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[j]=a[j]*Integer.bitCount(a[j]);
            }
        }
        for(int i=0;i<n;i++){
            if(i>0) System.out.print(" ");
            System.out.print(a[i]);
        }
        scan.close();
    }
}

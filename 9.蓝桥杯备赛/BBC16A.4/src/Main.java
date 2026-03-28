/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-10
 * Time: 21:10
 */
import java.util.Scanner;
import java.util.Arrays;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    //最短距离
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n=scan.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;i++) a[i]=scan.nextInt();
        for(int i=0;i<n;i++) b[i]=scan.nextInt();
        long sum=0;
        //贪心：遇到就连
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0;i<n;i++) sum+=Math.abs(a[i]-b[i]);
        System.out.println(sum);
        scan.close();
    }
}

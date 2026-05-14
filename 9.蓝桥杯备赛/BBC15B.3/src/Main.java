/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:41
 */
import java.util.Scanner;
public class Main {
    //分布式队列
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int[] a=new int[N];
        while(sc.hasNext()){
            String s=sc.next();
            if("query".equals(s)){
                int mn=0x3f3f3f3f;
                for(int i=0;i<N;i++) mn=Math.min(mn,a[i]);
                System.out.println(mn);
            }else if("add".equals(s)){
                int n=sc.nextInt();
                a[0]++;
            }else if("sync".equals(s)){
                int n=sc.nextInt();
                a[n]=Math.min(a[n]+1,a[0]);
            }
        }
        sc.close();
    }
}

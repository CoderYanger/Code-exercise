/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-29
 * Time: 18:55
 */
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    //[模板]前缀和
    public static void main(String[] args) {
        Scanner sca=new Scanner(System.in);
        int n =sca.nextInt(),p=sca.nextInt();
        int[]arr=new int[n+1];
        for(int i=1;i<n;i++) arr[i]=sca.nextInt();
        int[]dp=new int[n+1];
        for(int i=1;i<n;i++) dp[i]=dp[i-1]+arr[i];
        while(p>0){
            int l=sca.nextInt(),r=sca.nextInt();
            System.out.println(dp[r]-dp[l-1]);
            p--;
        }
    }
}

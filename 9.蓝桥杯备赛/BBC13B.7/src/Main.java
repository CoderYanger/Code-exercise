/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:35
 */
import java.util.*;
public class Main {
    //数组切分
    private static final int MOD=1_000_000_007;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n+1];
        for (int i=1;i<=n;i++) nums[i]=sc.nextInt();
        //dp[i]：以nums[i]结尾的切分合法数组的方法数量
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            int mx=-0x3f3f3f3f,mn=0x3f3f3f3f;
            for(int j=i;j>0;j--){
                mx=Math.max(mx,nums[j]);
                mn=Math.min(mn,nums[j]);
                if(mx-mn==i-j) dp[i]=(dp[i]+dp[j-1])%MOD;
            }
        }
        System.out.println(dp[n]);
        sc.close();
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-10
 * Time: 21:17
 */
import java.lang.Math;
import java.util.*;
public class Main {
    //魔法科考试
    //解法一：暴力枚举（部分测试用例存在超时）
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> hash=new HashSet<>();
        int n=sc.nextInt();
        int[] a=new int[n];
        int m=sc.nextInt();
        int[] b=new int[m];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        for(int i=0;i<m;i++) b[i]=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i]+b[j]<=n+m&&islegal(a[i]+b[j]))
                    hash.add(a[i]+b[j]);
            }
        }
        System.out.println(hash.size());
        sc.close();
    }
    //判断是否为质数
    private static boolean islegal(int x){
        if(x<=1) return false;
        for(int i=2;i<=Math.sqrt(x);i++)
            if(x%i==0) return false;
        return true;
    }

    //解法二：埃氏筛
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int m=sc.nextInt();
        int[] b=new int[m];
        int cnt=0;
        //埃氏筛
        boolean[] isPrime=new boolean[m+n+1];
        for(int i=2;i<=m+n;i++) isPrime[i]=true;
        for(int i=2;i<=n+m;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=m+n;j+=i)
                    isPrime[j]=false;
            }
        }
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        for(int i=0;i<m;i++) b[i]=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i]+b[j]<=n+m&&isPrime[a[i]+b[j]]){
                    cnt++;
                    isPrime[a[i]+b[j]]=false;
                }
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}

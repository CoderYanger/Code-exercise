/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-18
 * Time: 13:38
 */
import java.util.*;
public class Main {
    //数学诗意
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        long ret=0;
        long[] a=new long[n];
        for(int i=0;i<n;i++){
            //用nextLong()接受，防止int溢出
            a[i]=sc.nextLong();
            if((a[i]&(a[i]-1))==0) ret++;
        }
        System.out.println(ret);
        sc.close();
    }
}

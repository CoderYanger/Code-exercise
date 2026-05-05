/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:34
 */
import java.util.Scanner;
public class Main {
    //求阶乘
    //直接复用LeetCode793题
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long k=sc.nextLong();
        long left=1,right=5L*k;
        while(left<right){
            long mid=left+(right-left)/2;
            if(check(mid)<k) left=mid+1;
            else right=mid;
        }
        System.out.println(check(left)==k?left:-1);
        sc.close();
    }
    private static long check(long mid){
        long cnt=0;
        while(mid>0){
            mid/=5;
            cnt+=mid;
        }
        return cnt;
    }
}

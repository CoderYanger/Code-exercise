/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:40
 */
import java.util.Scanner;
public class Main {
    //最少砝码
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long cnt=0,cur=0;
        while(cnt<n){
            cnt+=Math.pow(3,cur);
            cur++;
        }
        System.out.println(cur);
        sc.close();
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:30
 */
import java.util.Scanner;
public class Main {
    //GCD
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        long a=sc.nextLong();
        long b=sc.nextLong();
        long mod=Math.abs(b-a);
        System.out.println(mod-a%mod);
        sc.close();
    }
}

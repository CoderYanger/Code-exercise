/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:37
 */
import java.util.Scanner;
public class Main {
    //卡片
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int k=0;
        while(k*(k+1)<2*n) k++;
        System.out.println(k);
        sc.close();
    }
}

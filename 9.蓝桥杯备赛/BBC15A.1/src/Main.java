/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-18
 * Time: 13:36
 */
import java.util.Scanner;
public class Main {
    //拼正方形
    public static void main(String[] args) {
        long A=7385137888721L;
        long B=10470245L;
        long i=1;
        while(true){
            if(i*i>A+B/4) break;
            i++;
        }
        System.out.println(2*(i-1));
    }
}

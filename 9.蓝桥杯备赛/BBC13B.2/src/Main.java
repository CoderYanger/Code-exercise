/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:32
 */
import java.util.Scanner;
public class Main {
    //山
    public static void main(String[] args) {
        int cnt4=0,cnt5=0,cnt7=0,cnt9=0,cnt10=0;
        for(int i1=2;i1<=9;i1++)
            for(int i2=i1;i2<=9;i2++) cnt4++;
        for(int i1=1;i1<=9;i1++)
            for(int i2=i1;i2<=9;i2++)
                for(int i3=i2;i3<=9;i3++) cnt5++;
        for(int i1=1;i1<=9;i1++)
            for(int i2=i1;i2<=9;i2++)
                for(int i3=i2;i3<=9;i3++)
                    for(int i4=i3;i4<=9;i4++) cnt7++;
        for(int i1=1;i1<=9;i1++)
            for(int i2=i1;i2<=9;i2++)
                for(int i3=i2;i3<=9;i3++)
                    for(int i4=i3;i4<=9;i4++)
                        for(int i5=i4;i5<=9;i5++) cnt9++;
        for(int i1=1;i1<=9;i1++)
            for(int i2=i1;i2<=9;i2++)
                for(int i3=i2;i3<=9;i3++)
                    for(int i4=i3;i4<=9;i4++) cnt10++;
        System.out.println(cnt4+2*cnt5+2*cnt7+cnt9+cnt10);
    }
}

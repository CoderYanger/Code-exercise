/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:54
 */
import java.util.*;
public class Main {
    //矩形总面积
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x1=sc.nextInt(),y1=sc.nextInt();
        int x2=sc.nextInt(),y2=sc.nextInt();
        int x3=sc.nextInt(),y3=sc.nextInt();
        int x4=sc.nextInt(),y4=sc.nextInt();
        //转成long再接收，防止溢出
        long s1=1L*(x2-x1)*(y2-y1),s2=1L*(x4-x3)*(y4-y3);
        //判断是否有重叠部分
        //计算重叠部分的宽度
        //重叠区域左边界=max(两矩形左边界)，重叠区域右边界=min(两矩形右边界)
        int width=Math.max(0,Math.min(x2,x4)-Math.max(x1,x3));
        //计算重叠部分的高度
        int height=Math.max(0,Math.min(y2,y4)-Math.max(y1,y3));
        long s3=width>0&&height>0?1L*width*height:0;
        System.out.println(s1+s2-s3);
        sc.close();
    }
}
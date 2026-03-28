/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-10
 * Time: 21:11
 */
import java.util.Scanner;
import java.util.*;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    //冷热数据队列
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n1=scan.nextInt(),n2=scan.nextInt();
        int m=scan.nextInt();
        int[] v=new int[m];
        for(int i=0;i<m;i++) v[i]=scan.nextInt();
        List<Integer> q1=new ArrayList<>();
        List<Integer> q2=new ArrayList<>();
        //记录q1已淘汰的数据页
        int t=0;
        for(int x:v){
            if(!q1.contains(x)&&!q2.contains(x)){
                q2.add(0,x);
                //容量满了，q2移除尾数据
                if(q2.size()>n2) q2.remove(q2.size()-1);
            }
            else if(q1.contains(x)||q2.contains(x)){
                //移除这个元素
                if(q1.contains(x)) q1.remove(Integer.valueOf(x));
                else if(q2.contains(x)) q2.remove(Integer.valueOf(x));
                //添加这个元素
                q1.add(0,x);
                //q1容量满了，q1移除尾数据并临时存在t里
                if(q1.size()>n1){
                    t=q1.remove(q1.size()-1);
                    //q2还没满，将q1淘汰的放q2前面
                    if(q2.size()<n2){
                        q2.add(0,t);
                    }
                }
            }
        }
        //输出
        for(int i=0;i<q1.size();i++){
            if(i>0) System.out.print(" ");
            System.out.print(q1.get(i));
        }
        System.out.println();
        for(int i=0;i<q2.size();i++){
            if(i>0) System.out.print(" ");
            System.out.print(q2.get(i));
        }
        scan.close();
    }
}
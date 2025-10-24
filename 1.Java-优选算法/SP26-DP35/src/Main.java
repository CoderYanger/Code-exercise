/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-29
 * Time: 21:46
 */
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    //35.【模板】二维前缀和
    public static void main(String[] args) {
        //读入数据
        Scanner in = new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt(),q=in.nextInt();
        int[][] arr=new int[n+1][m+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                arr[i][j]=in.nextInt();
        //使用前缀和
        long[][] str=new long[n+1][m+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                str[i][j]=str[i-1][j]+str[i][j-1]+arr[i][j]-str[i-1][j-1];
        //输出
        while(q>0){
            int x1=in.nextInt(),y1=in.nextInt(),x2=in.nextInt(),y2=in.nextInt();
            System.out.println(str[x2][y2]-str[x1-1][y2]-str[x2][y1-1]+str[x1-1][y1-1]);
            q--;
        }
    }
}
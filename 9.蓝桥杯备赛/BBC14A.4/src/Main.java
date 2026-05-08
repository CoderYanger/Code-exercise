/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 21:02
 */
import java.util.*;
public class Main{
    //棋盘
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int[][] diff=new int[n+1][n+1];
        for(int i=0;i<m;i++){
            int x1=sc.nextInt()-1,y1=sc.nextInt()-1;
            int x2=sc.nextInt()-1,y2=sc.nextInt()-1;
            diff[x1][y1]+=1;
            diff[x2+1][y2+1]+=1;
            diff[x1][y2+1]-=1;
            diff[x2+1][y1]-=1;
        }
        int[][] mat=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //计算三个区域的前缀和
                int k1=(i==0?0:mat[i-1][j]);
                int k2=(j==0?0:mat[i][j-1]);
                int k3=(i==0||j==0)?0:mat[i-1][j-1];
                mat[i][j]=(diff[i][j]+k1+k2-k3)%2;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(Math.abs(mat[i][j]));
            }
            System.out.println();
        }
        sc.close();
    }
}

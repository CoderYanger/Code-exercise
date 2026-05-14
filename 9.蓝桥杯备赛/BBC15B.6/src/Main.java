/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:47
 */
import java.util.*;
public class Main{
    //星际旅行
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//图的总节点数
        int m=sc.nextInt();//图的总边数
        int q=sc.nextInt();//查询的总次数
        //distance[i][j]:i节点到j节点的最短路径长度
        int[][] distance=new int[n+1][n+1];
        //初始化为无穷大，表示未连通
        for(int i=0;i<=n;i++){
            Arrays.fill(distance[i],0x3f3f3f3f);
            //自己到自己距离为0
            distance[i][i]=0;
        }
        //处理m条边，给无向图的边赋权值
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            distance[a][b]=1;
            distance[b][a]=1;
        }
        //动态规划：枚举中间节点k，更新"i→k→j"是否比"i→j"更短
        for(int k=1;k<=n;k++)
            for(int i=1;i<=n;i++)
                for(int j=1;j<=n;j++)
                    distance[i][j]=Math.min(distance[i][k]+distance[k][j],distance[i][j]);
        //处理所有查询，统计总可达节点数，计算期望
        double cnt=0;
        //循环处理q个查询
        for(int i=0;i<q;i++){
            int start=sc.nextInt();
            int usecnt=sc.nextInt();//可用传送门次数
            int ret=0;
            for(int j=1;j<=n;j++)
                if(distance[start][j]<=usecnt)
                    ret++;
            cnt+=ret;
        }
        //计算并输出期望
        System.out.println(String.format("%.2f",cnt/q));
        sc.close();
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-18
 * Time: 13:28
 */
import java.util.*;

public class Main {
    //爆破
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //在此输入您的代码...
        int n=sc.nextInt();
        //存每个x、y、r
        double[] x=new double[n];
        double[] y=new double[n];
        double[] r=new double[n];
        //循环获取
        for(int i=0;i<n;i++){
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
            r[i]=sc.nextInt();
        }
        //只有1个魔法阵，直接输出0.00
        if(n==1){
            System.out.println("0.00");
            return ;
        }
        //构建图的邻接矩阵
        //graph[i][j]:第i个魔法阵和第j个魔法阵之间需要的连接长度
        double[][] graph=new double[n][n];
        //遍历所有i<j的组合，计算每两个魔法阵之间的边权
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                //计算两个圆心在x、y方向上的差值
                double dx=x[i]-x[j];
                double dy=y[i]-y[j];
                //计算两圆心间的直线距离
                double center=Math.sqrt(dx*dx+dy*dy);
                //核心公式：如果圆心距离>两圆半径之和→需要连接：长度=圆心距－半径和
                //否则就是相交或相切，不用连接，长度为0
                double weight=Math.max(center-(r[i]+r[j]),0.0);
                graph[i][j]=weight;
                graph[j][i]=weight;
            }
        }
        //调用Prim算法，计算最小生成树的总边权
        double len=prim(graph,n);
        System.out.printf("%.2f\n",len);
        sc.close();
    }
    private static double prim(double[][] graph,int n){
        //minEdge[i]:记录当前最小生成树到节点i的最小边权
        //初始化为无穷大，表示一开始没连接
        double[] minEdge=new double[n];
        Arrays.fill(minEdge,Double.MAX_VALUE);
        //used[i]:标记节点i是否已经加入最小生成树
        boolean[] used=new boolean[n];
        //从0号节点开始构建最小生成树，自己到自己的距离为0
        minEdge[0]=0.0;
        //记录最小生成树的总长度
        double total=0.0;
        //一共要选n个节点加入最小生成树
        for(int iter=0;iter<n;iter++){
            //①找到未加入树且minEdge最小的节点u
            int u=-1;//u存当前要选的节点编号，初始化为-1
            for(int i=0;i<n;i++){
                //如果i没加入树，且u未选或i的边权更小，就更新u
                if(!used[i]&&(u==-1||minEdge[i]<minEdge[u])){
                    u=i;
                }
            }
            //②把u加入到最小生成树
            used[u]=true;
            //把这条最小边的长度累加到总长度里
            total+=minEdge[u];
            //③用u更新其他未加入节点的最小边权
            for(int v=0;v<n;v++){
                //如果v没加入树，且u到v的边比原来记录的minEdge[v]更短
                if(!used[v]&&graph[u][v]<minEdge[v]){
                    //更新v到最小生成树的最小边权
                    minEdge[v]=graph[u][v];
                }
            }
        }
        return total;
    }
}

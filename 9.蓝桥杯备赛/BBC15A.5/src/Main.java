/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-18
 * Time: 14:14
 */
import java.util.*;
public class Main {
    //吊坠
    //并查集的父节点数组，用于记录每个节点的连通分量
    static int[] parent;
    //并查集的查找函数（带路径压缩）
    static int find(int u){
        //路径压缩：如果当前节点不是根节点，递归查找其父节点，并将父节点直接指向根节点
        if(parent[u]!=u) parent[u]=find(parent[u]);
        //返回根节点
        return parent[u];
    }
    //并查集的合并函数
    static void union(int u,int v){
        //先查找两个节点的根节点
        u=find(u);
        v=find(v);
        //如果根节点不同，说明不在同一个连通分量，将u的根节点指向v的根节点
        if(u!=v) parent[u]=v;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        //手动读取换行符
        sc.nextLine();
        //读取n个原始字符串，并处理环形特性
        s=new String[n+1];
        for(int i=1;i<=n;i++){
            String line=sc.nextLine();
            //环形字符串处理：字符串拼接自身：s+s
            s[i]=line+line;
        }
        //构建所有节点间的边：边的权重=两个环形字符串的最大公共长度
        List<int[]> edges=new ArrayList<>();//存储边：int[]{节点u,节点v,权重w}
        //遍历所有两两节点的组合
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                int maxR=maxlen(i,j,m);
                //将i-j的边加入列表，权重为maxR
                edges.add(new int[]{i,j,maxR});
            }
        }
        //对边按权重排序→Kruskal算法
        edges.sort((a,b)->Integer.compare(b[2],a[2]));
        //初始化并查集：每个节点的父节点初始化为自身
        parent=new int[n+1];
        for(int i=1;i<=n;i++) parent[i]=i;
        //执行Kruskal算法，构建最大生成树
        long ret=0;//存储最大生成树的总权重
        //遍历排序后的边：权重从大到小
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            //如果两个节点不在同一个连通分量（避免连成环）
            if(find(u)!=find(v)){
                union(u,v);//合并两个连通分量
                ret+=w;//累加权重到结果中
            }
        }
        System.out.println(ret);
        sc.close();
    }
    static String[] s;
    //获取i和j两个字符串的最大公共子串长度
    private static int maxlen(int i,int j,int m){
        int maxR=0;
        //遍历第一个字符串的所有环形起始位置，模拟环形移位
        for(int k=0;k<m;k++){
            int cnt=0;//临时记录当前连续匹配的字符数
            int maxsu=0;//记录当前起始位置下的最大连续匹配长度
            int qindex=k;//第一个字符串的当前匹配位置
            //遍历第二个字符串的拼接后所有位置(0~2m-1)，寻找最长匹配
            for(int p=0;p<2*m;p++){
                //字符匹配：连续长度+1
                if(s[i].charAt(qindex)==s[j].charAt(p)) cnt++;
                    //字符不匹配：重置连续长度为0
                else cnt=0;
                //更新当前起始位置下的最大匹配长度
                maxsu=Math.max(maxsu,cnt);
                //第一个字符串的位置环形移动，取模保证不越界
                qindex=(qindex+1)%(2*m);
            }
            //最大公共子串长度不能超过原字符串长度m，因为拼接后为2m，需限制
            maxsu=Math.min(maxsu,m);
            //更新i和j的全局最大公共子串长度；
            maxR=Math.max(maxR,maxsu);
        }
        return maxR;
    }
}

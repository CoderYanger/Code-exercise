import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-16
 * Time: 22:40
 */
class Solution {
    //3562. 折扣价交易股票的最大利润
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        //构建树形邻接表
        List<Integer>[] g=new ArrayList[n];//开了大小为n的长度
        Arrays.setAll(g, i->new ArrayList<>());
        //员工1对应索引0，因为恰好n的大小的空间
        for(int[] e:hierarchy)
            g[e[0]-1].add(e[1]-1);
        //从根节点开始dfs，根节点无父节点，状态为未购买（0）
        //f[j][0]:根节点预算j下的最大利润
        int[][] f0=dfs(0,g,present,future,budget);
        return f0[budget][0];
    }
    //x:当前处理节点，g:树形邻接表，present:当前股票价格数组，future:股票未来价格数组，budget:总预算
    private int[][] dfs(int x, List<Integer>[] g, int[] present, int[] future, int budget){
        //计算从x的所有儿子子树y中，能得到的最大利润之和（x不买，x买）
        //subF[j][k]:合并x的所有子树后，预算j下，x自身状态为k时的最大利润
        //初始化为0：没有子树时利润为0
        int[][] subF=new int[budget+1][2];
        //遍历x的每个直接子节点y，合并子树y的状态到subF
        for(int y:g[x]){
            //递归处理子节点y，得到y子树的状态数组fy
            int[][] fy=dfs(y,g,present,future,budget);
            //01背包的逆序遍历：避免重复选择，从大预算到小预算更新
            for(int j=budget;j>=0;j--){
                //枚举子树y的预算为jy
                //当作一个体积为jy，价值为fy[jy][k]的物品
                //把总预算j拆分成给子树y的运算jy和留给当前节点的剩余预算j-jy来合并子树状态
                for(int jy=0;jy<=j;jy++)
                    for(int k=0;k<2;k++)
                        //状态转移：总预算j=剩余j-jy+给y的jy
                        //剩余预算j-jy的利润(subF[j-jy][k])+y子树预算jy的利润(fy[jy][k])
                        subF[j][k]=Math.max(subF[j][k],subF[j-jy][k]+fy[jy][k]);
            }
        }
        //f[j][k]:最终返回的状态数组，k表示x的父节点状态
        //计算从子树x中，能得到的最大利润之和(x父节点不买，x父节点买)
        int[][] f=new int[budget+1][2];
        for(int j=0;j<=budget;j++){
            for(int k=0;k<2;k++){
                //k=0表示x父节点不买，k=1表示x父节点买
                int cost=present[x]/(k+1);
                if(j>=cost)
                    //不买x，转移源是subF[j][0]
                    //买x，转移源是subF[j-cost][1],因为对于子树来说,父节点一定买
                    f[j][k]=Math.max(subF[j][0],subF[j-cost][1]+future[x]-cost);
                else //只能不买x
                    f[j][k]=subF[j][0];
            }
        }
        return f;
    }
}
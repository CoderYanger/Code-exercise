import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-18
 * Time: 18:03
 */
class Solution {
    //3814. 预算下的最大总容量
    //解法一：暴力枚举(会超时)
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int ret=0;
        //暴力解法O(N²)
        int n=costs.length;
        //选一台机器
        for(int i=0;i<n;i++)
            if(costs[i]<budget)
                ret=Math.max(ret,capacity[i]);
        //选两台机器
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(costs[i]+costs[j]<budget)
                    ret=Math.max(ret,capacity[i]+capacity[j]);
            }
        }
        return ret;
    }

    //解法二：排序+二分查找+前缀和思想
    static class Machine{
        int cost;
        int capacity;
        Machine(int cost,int capacity){
            this.cost=cost;
            this.capacity=capacity;
        }
    }
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n=costs.length;
        if(n==0) return 0;
        //将机器按照成本升序
        Machine[] m=new Machine[n];
        for(int i=0;i<n;i++)
            m[i]=new Machine(costs[i],capacity[i]);
        Arrays.sort(m,(a,b)->a.cost-b.cost);
        //预处理前缀最大容量数组
        int[] prefix=new int[n];
        prefix[0]=m[0].capacity;
        for(int i=1;i<n;i++)
            prefix[i]=Math.max(prefix[i-1],m[i].capacity);
        int ret=0;
        //遍历每台机器，用二分查找来找到能和它组合的最优机器
        for(int i=0;i<n;i++){
            //先处理只选当前这台机器的情况
            if(m[i].cost<budget) ret=Math.max(ret,m[i].capacity);
            //再处理选当前机器+另一台机器的情况
            //由于先前我们已经按照成本升序排序了，所以越在右侧成本越大
            //我们通过成本总和<budget的约束来确定最大下标j的范围，j<i
            //然后通过前缀和的j就能找到在j之前出现的最大容量
            int t=budget-m[i].cost;
            //通过以上分析，可确定为最右端点模型
            int left=0,right=i-1;
            while(left<right){
                int mid=left+(right-left+1)/2;
                if(m[mid].cost>=t) right=mid-1;
                else left=mid;
            }
            //如果找到了有效下标就更新
            if(left<i&&m[left].cost<t) ret=Math.max(ret,m[i].capacity+prefix[left]);
        }
        return ret;
    }
}
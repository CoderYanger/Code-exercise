import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-07
 * Time: 20:58
 */
class Solution {
    //2144. 打折购买糖果的最小开销
    public int minimumCost(int[] cost) {
        int n=cost.length;
        Arrays.sort(cost);
        int ret=0;
        int id1=n-1,id2=n-2;
        for(;id1>=0&&id2>=0;id1-=3,id2-=3){
            ret+=(cost[id1]+cost[id2]);
        }
        if(id1>=0) ret+=cost[id1];//处理id2越界，但id1未越界的情况
        return ret;
    }
}

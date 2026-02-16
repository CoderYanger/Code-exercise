import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-02
 * Time: 10:40
 */
class Solution {
    //3623. 统计梯形的数目 I
    public int countTrapezoids(int[][] points) {
        int mod=1_000_000_007;
        Map<Integer,Integer> hash=new HashMap<>();
        //统计同一y值的点有多少个
        for(int[] p:points)
            hash.put(p[1],hash.getOrDefault(p[1],0)+1);
        long sum=0,ret=0;//sum保证只×遍历过的边，防止重复计算
        for(int num:hash.values()){
            long edges=(long)num*(num-1)/2;
            ret=(ret+sum*edges)%mod;
            sum=(sum+edges)%mod;
        }
        return (int)ret;
    }
}
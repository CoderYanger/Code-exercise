import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-08
 * Time: 19:16
 */
class Solution {
    //2615. 等值距离和
    //解法一：哈希表暴力计算（会超时）
    public long[] distance(int[] nums) {
        int n=nums.length;
        long[] ret=new long[n];
        Map<Integer, List<Integer>> hash=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!hash.containsKey(nums[i]))
                hash.put(nums[i],new ArrayList<>());
            hash.get(nums[i]).add(i);
            hash.put(nums[i],hash.get(nums[i]));
        }
        for(List<Integer> list:hash.values()){
            for(int x:list){
                int t=0;
                for(int y:list) t+=Math.abs(x-y);
                ret[x]=t;
            }
        }
        return ret;
    }

    //解法二：相同元素分组+前缀和
    public long[] distance(int[] nums) {
        int n=nums.length;
        //按元素分组，记录各个下标
        Map<Integer,List<Integer>> hash=new HashMap<>();
        for(int i=0;i<n;i++)
            hash.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        //对每个顺序表做一遍2602. 使数组元素全部相等的最少操作次数
        long[] ret=new long[n];
        long[] sum=new long[n];
        for(List<Integer> a:hash.values()){
            int m=a.size();
            //计算当前分组的前缀和(之前的用不到了，直接覆盖即可)
            //用m个即可，没必要n个全用
            sum[0]=a.get(0);
            for(int i=1;i<m;i++) sum[i]=sum[i-1]+a.get(i);
            //处理边界：首尾位置
            ret[a.get(0)]=sum[m-1]-1L*m*a.get(0);
            ret[a.get(m-1)]=1L*m*a.get(m-1)-sum[m-1];
            for(int i=1;i<m-1;i++){
                long target=a.get(i);
                long left=target*i-sum[i-1];
                long right=sum[m-1]-sum[i-1]-target*(m-i);
                ret[(int)target]=left+right;
            }
        }
        return ret;
    }

}
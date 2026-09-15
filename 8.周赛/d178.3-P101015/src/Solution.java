import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-15
 * Time: 10:15
 */
class Solution {
    //101015. 通过交换使数组相等的最小花费
    public int minCost(int[] nums1, int[] nums2) {
        int n=nums1.length;
        Map<Integer,Integer> hash=new HashMap<>();
        Map<Integer,Integer> hash1=new HashMap<>();
        Map<Integer,Integer> hash2=new HashMap<>();
        for(int x:nums1){
            hash.merge(x,1,Integer::sum);
            hash1.merge(x,1,Integer::sum);
        }
        for(int x:nums2){
            hash.merge(x,1,Integer::sum);
            hash2.merge(x,1,Integer::sum);
        }
        for(int val:hash.values())
            if(val%2!=0) return -1;
        int ret=0;
        for(int x:hash.keySet()){
            int need=hash.get(x)/2;
            int diff=hash1.getOrDefault(x,0)-need;
            //交换只累加一次，因为：移入=移出
            ret+=diff>0?diff:0;
        }
        return ret;
    }

    //优化
    public int minCost(int[] nums1, int[] nums2) {
        int n=nums1.length;
        //diff[x]:x元素在nums1中出现次数-在nums2出现次数
        Map<Integer,Integer> diff=new HashMap<>();
        for(int x:nums1) diff.merge(x,1,Integer::sum);//diff[x]++
        for(int x:nums2) diff.merge(x,-1,Integer::sum);//diff[x]--
        int ret=0;
        for(int d:diff.values()){
            if(d%2!=0) return -1;
            ret+=d>0?d/2:0;
        }
        return ret;
    }


    //进阶优化：数组代替哈希表
    public int minCost(int[] nums1, int[] nums2) {
        int n=nums1.length,max=0;
        for(int x:nums1) max=Math.max(max,x);
        for(int x:nums2) max=Math.max(max,x);
        //diff[x]:x元素在nums1中出现次数-在nums2出现次数
        int[] diff=new int[max+1];
        for(int x:nums1) diff[x]++;
        for(int x:nums2) diff[x]--;
        int ret=0;
        for(int d:diff){
            if(d%2!=0) return -1;
            ret+=d>0?d/2:0;
        }
        return ret;
    }
}

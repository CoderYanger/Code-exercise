import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-25
 * Time: 16:20
 */
class Solution {
    //1027. 最长等差数列
    public int longestArithSeqLength(int[] nums) {
        //吴小哲我俩写的大体一样
        Map<Integer,Integer> hash=new HashMap<>();
        int n=nums.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],2);
        //第二种填表方式
        int ret=2;
        //也可以i从1开始遍历，但要提前把nums[0],0扔哈希表里去
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int a=2*nums[i]-nums[j];
                if(hash.containsKey(a)){
                    //下面这个判断可以不加，因为这种遍历方式已经保证了a不会在i的后面
                    //if(hash.get(a)<i){
                    dp[i][j]=dp[hash.get(a)][i]+1;
                    ret=Math.max(ret,dp[i][j]);
                    //}
                }
                //一开始写错位置了，扔哈希表里的时机应该是在i移动的时候
                //hash.put(a,i);
            }
            hash.put(nums[i],i);
        }
        return ret;
    }
}
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-23
 * Time: 19:39
 */
class Solution {
    //646. 最长数对链
    //看完算法原理后照着笔记自己写的，就是预处理部分看了一下吴小哲的
    //一开始以为用的是Pair的数据结构呢
    //吴小哲跟我写的一样
    public int findLongestChain(int[][] pairs) {
        //预处理：按照第一个数字来排序，这里的pairs是数组，不是Pair
        //Pair属于数据结构，是数对（键值对）
        Arrays.sort(pairs,(a, b)->a[0]-b[0]);
        int n=pairs.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int ret=1;
        for(int x:dp) ret=Math.max(ret,x);
        return ret;
    }
}
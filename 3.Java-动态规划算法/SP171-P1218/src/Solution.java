import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-23
 * Time: 23:15
 */
class Solution {
    //1218. 最长的等差子序列
    //看完算法原理自己也没写出来，还是看了吴小哲写的，确实很有技巧
    public int longestSubsequence(int[] arr, int difference) {
        //把arr[i]和dp[i]绑定在哈希表
        HashMap<Integer,Integer> hash =new HashMap<>();
        int ret=1;
        for(int a:arr){
            //这一句话干了三件事
            //初始化：第一次进时必为0+1-->初始化为1
            //完成状态转移方程：找到了+1，没找到还是1
            //保证每次找的都是最后一个b：会覆盖掉前面的记录
            hash.put(a,hash.getOrDefault(a-difference,0)+1);
            ret=Math.max(ret,hash.get(a));
        }
        return ret;
    }
}
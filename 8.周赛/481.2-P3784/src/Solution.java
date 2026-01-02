/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-21
 * Time: 16:57
 */
class Solution {
    //3784. 使所有字符相等的最小删除代价
    public long minCost(String ss, int[] cost) {
        //问题转换：保留总代价最大的字母，其余全删
        int n=cost.length;
        //存<字母，总代价>避免贪心出错
        long[] total=new long[26];
        char[] s=ss.toCharArray();
        long sum=0;//记录总和
        long max=0;//记录最大值
        for(int i=0;i<n;i++){
            sum+=cost[i];
            total[s[i]-'a']+=cost[i];
        }
        for(int i=0;i<26;i++)
            max=Math.max(max,total[i]);
        return sum-max;
    }
}
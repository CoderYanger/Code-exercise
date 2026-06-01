/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-12
 * Time: 23:09
 */
class Solution {
    //1310. 子数组异或查询
    //解法一：暴力计算（会超时）
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=queries.length;
        int[] ret=new int[n];
        for(int i=0;i<n;i++)
            for(int j=queries[i][0];j<=queries[i][1];j++) ret[i]^=arr[j];
        return ret;
    }
    //解法二：前缀异或
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=arr.length;
        int[] pre=new int[n+1];
        for(int i=0;i<n;i++) pre[i+1]=pre[i]^arr[i];
        int[] ret=new int[queries.length];
        for(int i=0;i<queries.length;i++) ret[i]=pre[queries[i][1]+1]^pre[queries[i][0]];
        return ret;
    }
}
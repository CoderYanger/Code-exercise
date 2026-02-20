import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-22
 * Time: 13:18
 */
class Solution {
    //960. 删列造序 III
    public int minDeletionSize(String[] s) {
        int m=s[0].length();
        int n=s.length;
        //状态表示：dp[i]:以i位置元素为结尾的所有子序列中，最长的递增子序列的长度
        int[] dp=new int[m];
        Arrays.fill(dp,1);
        //遍历每一列
        for(int i=0;i<m;i++){
            for(int j=i-1;j>=0;j--){
                if(islegal(s,i,j)){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        //找到以每一列元素结尾的递增子序列的最大长度
        int max=0;
        for(int x:dp) max=Math.max(max,x);
        return m-max;
    }
    private boolean islegal(String[] s,int i,int j){
        //遍历每一列，看第j列是否都小于i列
        for(String str:s){
            if(str.charAt(j)>str.charAt(i))
                return false;
        }
        return true;
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 14:53
 */
class Solution {
    //3707. 相等子字符串分数
    public boolean scoreBalance(String s) {
        int n=s.length();
        int[] sumf=new int[n+1];
        for(int i=0;i<n;i++){
            sumf[i+1]=sumf[i]+s.charAt(i)-'a'+1;
        }
        //遍历每一个可能的分割点
        for(int i=1;i<n;i++){
            int left=sumf[i];
            int right=sumf[n]-sumf[i];
            if(left==right) return true;
        }
        return false;
    }
}
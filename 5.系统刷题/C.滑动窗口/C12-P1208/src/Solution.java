/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-24
 * Time: 23:44
 */
class Solution {
    //1208. 尽可能使字符串相等
    public int equalSubstring(String ss, String tt, int maxCost) {
        char[] s=ss.toCharArray();
        char[] t=tt.toCharArray();
        int n=s.length,ret=0,left=0,cost=0;
        //定义差值数组，方便出窗口
        int[] diff=new int[n];
        for(int i=0;i<n;i++) diff[i]=Math.abs(s[i]-t[i]);
        for(int right=0;right<n;right++){
            //进窗口
            cost+=diff[right];
            //更新
            if(cost<=maxCost) ret=Math.max(ret,right-left+1);
            //出窗口
            while(cost>maxCost) cost-=diff[left++];
        }
        return ret;
    }
}
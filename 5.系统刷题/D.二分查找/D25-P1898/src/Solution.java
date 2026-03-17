/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-06
 * Time: 22:20
 */
class Solution {
    //1898. 可移除字符的最大数目
    public int maximumRemovals(String s, String p, int[] r) {
        int left=0,right=r.length;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(!check(mid,s,p,r)) right=mid-1;
            else left=mid;
        }
        return left;
    }
    //移除前mid个下标对应字符后，子序列还有p就返回true
    private boolean check(int mid,String s, String p, int[] r){
        int n=s.length();
        boolean[] removed=new boolean[n];
        for(int i=0;i<mid;i++) removed[r[i]]=true;
        int pindex=0;
        for(int i=0;i<n&&pindex<p.length();i++)
            if(!removed[i]&&s.charAt(i)==p.charAt(pindex))
                pindex++;
        return pindex==p.length();
    }
}

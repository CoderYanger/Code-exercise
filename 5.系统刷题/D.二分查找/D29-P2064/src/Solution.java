/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-13
 * Time: 18:42
 */
class Solution {
    //2064. 分配给商店的最多商品的最小值
    public int minimizedMaximum(int n,int[] q) {
        if(n==0||q.length==0) return 0;
        int left=1,right=0;
        for(int x:q) right=Math.max(right,x);
        while(left<right){
            int mid=left+(right-left)/2;
            if(!check(mid,n,q)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    private boolean check(int mid,int n,int[] q){
        int cnt=0;
        for(int x:q){
            if(x%mid==0) cnt+=(x/mid);
            else cnt+=(x/mid)+1;
        }
        return cnt<=n;
    }
}

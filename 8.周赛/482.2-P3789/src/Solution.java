/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-28
 * Time: 12:15
 */
class Solution {
    //3789. 采购的最小花费
    public long minimumCost(int c1, int c2, int c, int n1, int n2) {
        if(n1==0&&n2==0) return 0;
        long kmax=Math.max(n1,n2);
        long kmin=Math.min(n1,n2);
        long ca=(long)n1*c1+(long)n2*c2;
        long cb=(long)kmin*c+(long)(n1-kmin)*c1+(long)(n2-kmin)*c2;
        long cc=(long)kmax*c;
        return Math.min(ca,Math.min(cb,cc));
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-27
 * Time: 16:42
 */
class Solution {
    //793. 阶乘函数后 K 个零
    public int preimageSizeFZF(int k) {
        long left=0,right=5L*k;
        while(left<right){
            long mid=left+(right-left)/2;
            if(check(mid)<k) left=mid+1;
            else right=mid;
        }
        return check(left)==k?5:0;
    }
    private int check(long mid){
        int cnt=0;
        while(mid>0){
            mid/=5;
            cnt+=mid;
        }
        return cnt;
    }
}

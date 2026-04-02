/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-12
 * Time: 20:21
 */
class Solution {
    //263. 丑数
    //0ms击败100.00%
    public boolean isUgly(int n) {
        if(n<=0) return false;
        while(n%3==0) n/=3;
        while(n%5==0) n/=5;
        return (n&(n-1))==0;
    }
}

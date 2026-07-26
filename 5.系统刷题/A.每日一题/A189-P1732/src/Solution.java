/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-26
 * Time: 15:55
 */
class Solution {
    //1732. 找到最高海拔
    public int largestAltitude(int[] gain) {
        int t=0;
        int mx=t;
        for(int x:gain){
            t+=x;
            mx=Math.max(mx,t);
        }
        return mx;
    }
}
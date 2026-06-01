/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-12
 * Time: 23:08
 */
class Solution {
    //2433. 找出前缀异或的原始数组
    public int[] findArray(int[] pref) {
        int n=pref.length;
        int[] ret=new int[n];
        ret[0]=pref[0];
        for(int i=1;i<n;i++) ret[i]=pref[i-1]^pref[i];
        return ret;
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-12
 * Time: 23:08
 */
class Solution {
    //1720. 解码异或后的数组
    public int[] decode(int[] encoded, int first) {
        //异或消消乐
        int n=encoded.length;
        int[] ret=new int[n+1];
        ret[0]=first;
        for(int i=1;i<n+1;i++) ret[i]=encoded[i-1]^ret[i-1];
        return ret;
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-21
 * Time: 16:56
 */
class Solution {
    //100942. 整数的镜像距离
    public int mirrorDistance(int n) {
        String s=String.valueOf(n);
        StringBuffer sb=new StringBuffer(s);
        int r=Integer.valueOf(sb.reverse().toString());
        return Math.abs(n-r);
    }
}
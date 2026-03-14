/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-01
 * Time: 08:44
 */
class Solution {
    //1689. 十-二进制数的最少数目
    public int minPartitions(String n) {
        int max=0;
        for(char c:n.toCharArray()) max=Math.max(max,c-'0');
        return max;
    }
}

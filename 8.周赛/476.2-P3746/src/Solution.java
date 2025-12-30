/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-16
 * Time: 12:47
 */
public class Solution {
    //3746. 等量移除后的字符串最小长度
    public int minLengthAfterRemovals(String s) {
        int a=0,b=0;
        for(char c:s.toCharArray()){
            if(c=='a') a++;
            else b++;
        }
        return Math.abs(a-b);
    }
}

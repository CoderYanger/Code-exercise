import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-30
 * Time: 12:47
 */
class Solution {
    //3760. 不同首字母的子字符串数目
    public int maxDistinct(String ss) {
        int ret=0;
        char[] s=ss.toCharArray();
        int n=s.length;
        Set<Character> hash=new HashSet<>();
        for(char c:s){
            if(!hash.contains(c)){
                hash.add(c);
                ret++;
            }
        }
        return ret;
    }
}
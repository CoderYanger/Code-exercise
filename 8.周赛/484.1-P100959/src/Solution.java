import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-11
 * Time: 14:56
 */
class Solution {
    //100959. 统计残差前缀
    public int residuePrefixes(String ss) {
        char[] s=ss.toCharArray();
        int ret=0;
        Set<Character> hash=new HashSet<>();
        for(int i=0;i<s.length;i++){
            hash.add(s[i]);
            if(hash.size()==(i+1)%3) ret++;
        }
        return ret;
    }
}
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-15
 * Time: 13:46
 */
class Solution {
    //3839. 前缀连接组的数目
    public int prefixConnected(String[] words, int k) {
        int ret=0;
        Map<String,Integer> hash=new HashMap<>();
        for(String s:words){
            if(s.length()<k) continue;
            String t=s.substring(0,k);
            hash.put(t,hash.getOrDefault(t,0)+1);
        }
        for(Map.Entry<String,Integer> entries:hash.entrySet())
            if(entries.getValue()>=2) ret++;
        return ret;
    }
}

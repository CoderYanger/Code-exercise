import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-14
 * Time: 17:25
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] chars=strs[i].toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);//用toString得到的是哈希地址
            if(!hash.containsKey(key)) hash.put(key,new ArrayList<String>());
            hash.get(key).add(strs[i]);
        }
        return new ArrayList(hash.values());
    }
}
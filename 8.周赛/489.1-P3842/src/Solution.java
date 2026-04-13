import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-15
 * Time: 13:49
 */
class Solution {
    //3842. 切换灯泡开关
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        Map<Integer,Integer> hash=new HashMap<>();
        for(int x:bulbs) hash.put(x,hash.getOrDefault(x,0)+1);
        List<Integer> ret=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entries:hash.entrySet())
            if(entries.getValue()%2==1) ret.add(entries.getKey());
        Collections.sort(ret);
        return ret;
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-15
 * Time: 13:50
 */
class Solution {
    //3843. 频率唯一的第一个元素
    public int firstUniqueFreq(int[] nums) {
        //hash1:存<数字，频率>
        Map<Integer,Integer> hash1=new HashMap<>();
        //hash2:存<频率，出现次数>
        Map<Integer,Integer> hash2=new HashMap<>();
        for(int x:nums) hash1.put(x,hash1.getOrDefault(x,0)+1);
        for(Map.Entry<Integer,Integer> entries:hash1.entrySet())
            hash2.put(entries.getValue(),hash2.getOrDefault(entries.getValue(),0)+1);
        for(int x:nums)
            if(hash2.get(hash1.get(x))==1) return x;
        return -1;
    }
}

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-29
 * Time: 20:05
 */
class Solution {
    //3692. 最频繁的字符分组
    public String majorityFrequencyGroup(String s) {
        //统计字符频率
        int[] freq=new int[26];
        for(char c:s.toCharArray()) freq[c-'a']++;
        //按频率分组字符
        Map<Integer, List<Character>> group=new HashMap<>();
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                //group.computeIfAbsent(freq[i],k->new ArrayList<>()).add((char)(i+'a'));
                if(!group.containsKey(freq[i])) group.put(freq[i],new ArrayList<>());
                group.get(freq[i]).add((char)(i+'a'));
            }
        }
        //找出最优频率数组
        int maxChars=-1,bestFreq=-1;//记录对应频率
        for(Map.Entry<Integer,List<Character>> e:group.entrySet()){
            int f=e.getKey(),cnt=e.getValue().size();
            if(cnt>maxChars||cnt==maxChars&&f>bestFreq){
                //这里体现出组大小优先
                maxChars=cnt;
                bestFreq=f;
            }
        }
        //排序并构建结果
        List<Character> chars = group.get(bestFreq);
        Collections.sort(chars);//按字典顺序排序字符
        StringBuilder res=new StringBuilder();
        for(char c:chars) res.append(c);
        return res.toString();
    }
}
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-11
 * Time: 14:58
 */
class Solution {
    //3805. 统计凯撒加密对数目
    //解法一
    public long countPairs(String[] words) {
        //存储偏移量特征码
        Map<String,Integer> hash=new HashMap<>();
        for(String s:words){
            char ch=s.charAt(0);
            StringBuffer sb=new StringBuffer();
            for(char c:s.toCharArray()){
                int offset=(c-ch+26)%26;
                sb.append(offset).append(",");
            }
            hash.put(sb.toString(),hash.getOrDefault(sb.toString(),0)+1);
        }
        long ret=0;
        for(int count:hash.values()) ret+=(long)count*(count-1)/2;
        return ret;
    }

    //解法二
    public long countPairs(String[] words) {
        Map<String,Integer> hash=new HashMap<>();
        long ret=0;
        for(String s:words){
            char[] t=s.toCharArray();
            char base=t[0];
            for(int i=0;i<t.length;i++)
                t[i]=(char)((t[i]-base+26)%26);
            s=new String(t);
            int c=hash.getOrDefault(s,0);
            ret+=c;
            hash.put(s,c+1);
        }
        return ret;
    }
}

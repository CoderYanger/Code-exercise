import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-12
 * Time: 18:57
 */
class Solution {
    //3306. 元音辅音字符串计数 II
    public long countOfSubstrings(String word, int k) {
        char[] s=word.toCharArray();
        return solve(s,k)-solve(s,k+1);
    }
    //两个至少相减
    private long solve(char[] s,int k){
        long ret=0,n=s.length,count=0;//统计辅音字母的个数
        Map<Character,Integer> hash=new HashMap<>();
        for(int left=0,right=0;right<n;right++){
            //进窗口
            if(islegal(s[right]))
                hash.put(s[right],hash.getOrDefault(s[right],0)+1);
            else count++;
            //出窗口
            while(hash.keySet().size()==5&&count>=k){
                if(islegal(s[left])){
                    hash.put(s[left],hash.get(s[left])-1);
                    if(hash.get(s[left])==0) hash.remove(s[left]);
                }else count--;
                left++;
            }
            //更新
            ret+=left;
        }
        return ret;
    }
    //判断是否是元音字母
    private boolean islegal(char c){
        return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
    }
}
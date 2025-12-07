import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-22
 * Time: 23:42
 */
class Solution {
    //139. 单词拆分
    //自己写了一遍，发现在匹配字典中字符串上出现了问题
    //一开始打算另外封装个方法，一个个找，后来发现太麻烦了，改用哈希表了
    //我原本用的StringBuffer拼接来找，豆包说不用，直接在原字符串上截取就行substring
    public boolean wordBreak2(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        HashMap<String,Integer> hash=new HashMap<>();
        for(String str:wordDict) hash.put(str,hash.getOrDefault(str,0)+1);
        // StringBuffer sb=new StringBuffer(" ");
        // sb.append(s);
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){//修改处
                // char ch=sb.charAt(j);
                // sb.append(ch);
                // if(hash.get(sb.toString())==1&&dp[i-1]==true) dp[i]=true;
                if(hash.containsKey(s.substring(j,i))&&dp[j]==true)//修改处
                {dp[i]=true;break;}//修改处
                //else {dp[i]=false;break;}
            }
        }
        return dp[n];
    }
    //吴小哲的写法（更简单些），优化一涨知识了，我一直以为不能这么写
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        //优化一：将字典中的单词存放在哈希表里
        Set<String> hash=new HashSet<>(wordDict);
        boolean[]dp=new boolean[n+1];
        dp[0]=true;//初始化，保证后续填表正确
        s=" "+s;//处理下标的映射关系
        for(int i=1;i<=n;i++){
            for(int j=i;j>=1;j--){//最后一个单词的起始位置
                if(dp[j-1]&&hash.contains(s.substring(j,i+1))){
                    dp[i]=true;
                    break;//优化二
                }
            }
        }
        return dp[n];
    }
}
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-13
 * Time: 14:46
 */
class Solution {
    //3714. 最长的平衡子串 II
    public int longestBalanced(String ss) {
        char[] s=ss.toCharArray();
        int n=s.length;
        if(n==0) return 0;
        int ret=1;
        //①字串中只有一种字母→对应1466.连续字符
        int count=1;
        for(int i=1;i<n;i++){
            if(s[i]==s[i-1]){
                count++;
                ret=Math.max(ret,count);
            }else count=1;
        }
        //②子串中有两种字母，分别检查3种组合：a&b、b&c、a&c
        //对应525.连续数组
        ret=Math.max(ret,f(s,'a','b'));
        ret=Math.max(ret,f(s,'b','c'));
        ret=Math.max(ret,f(s,'a','c'));
        //③子串中包含三种字母
        //核心思路：类似②，用前缀和表示三个字符的计数差，将两个差值压缩为一个long值，存入哈希表
        //当两个位置差值组合相同时，则这两个位置间的子串满足计数a=b=c
        //哈希表：<差值组合，第一次出现的位置索引>
        Map<Long,Integer> hash=new HashMap<>();
        hash.put((long)n<<20|n,-1);
        //cnt[0]:a的个数、cnt[1]:b的个数、cnt[2]:c的个数
        int[] cnt=new int[3];
        for(int i=0;i<n;i++){
            cnt[s[i]-'a']++;
            //将两个差值压缩进一个long里形成差值组合,+n保证差值非负
            long d=(long)(cnt[0]-cnt[1]+n)<<20|(cnt[1]-cnt[2]+n);
            if(hash.containsKey(d)) ret=Math.max(ret,i-hash.get(d));
            else hash.put(d,i);//记录第一次出现的位置
        }
        return ret;
    }
    private int f(char[] s,char x,char y){
        int ret=0;
        for(int i=0;i<s.length;){
            if(s[i]!=x&&s[i]!=y){
                i++;
                continue;
            }
            //开始统计仅含x、y的子串
            //每段初始化独立的hash和sum
            Map<Integer,Integer> hash=new HashMap<>();
            int sum=0;
            hash.put(0,i-1);
            while(i<s.length&&(s[i]==x||s[i]==y)){
                sum+=(s[i]==x?-1:1);
                if(hash.containsKey(sum)) ret=Math.max(ret,i-hash.get(sum));
                else hash.put(sum,i);
                i++;
            }
        }
        return ret;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-06
 * Time: 18:43
 */
class Solution {
    //2982. 找出出现至少三次的最长特殊子字符串 II
    private static List<Integer>[] groups;
    public int maximumLength(String ss) {
        //统计每个字符的连续长度
        char[] s=ss.toCharArray();
        groups=new ArrayList[26];
        Arrays.setAll(groups, _->new ArrayList<>());
        int count=0;
        for(int i=0;i<s.length;i++){
            count++;
            if(i+1==s.length||s[i]!=s[i+1]){
                //把这一段的长度添加进去
                groups[s[i]-'a'].add(count);
                //重新计数
                count=0;
            }
        }
        //二分框架
        int left=0,right=s.length;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(check(mid)) right=mid-1;
            else left=mid;
        }
        //如果所有都不能凑出就返回-1
        return check(left)?-1:left;
    }
    //判断能否存在某个字符，能凑出至少3个长度为mid的相同子串
    //若不能凑出，则返回true向左调整mid
    private boolean check(int mid){
        if(mid==0) return true;
        //遍历每个小写字母，看看每段的长度能否凑出来
        for(List<Integer> word:groups){
            //该字符无连续段，直接跳过
            if(word.isEmpty()) continue;
            //统计该字符当前段能凑出mid长度子串的总数
            int sum=0;
            for(int l:word){
                if(l<mid) continue;
                sum+=l+1-mid;//累加该段的贡献量
                if(sum>=3) return false;
            }
        }
        return true;
    }
}

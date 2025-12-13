import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-06
 * Time: 18:59
 */
class Solution {
    //455. 分发饼干
    //看完算法原理自己写的，主要问题在越界上，一开始我以为g和s的长度一样呢
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ns=s.length,ng=g.length;
        int i=0,j=0;
        while(i<ng&&j<ns){
            if(g[i]<=s[j]){ i++;j++;}
            else j++;
        }
        return i;
    }

    //吴小哲的解法，跟我的差不多
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        //用双指针找答案
        int ret=0,m=g.length,n=s.length;
        for(int i=0,j=0;i<m&&j<n;i++,j++){
            //直至找到符合胃口的饼干
            while(j<n&&s[j]<g[i]) j++;
            if(j<n) ret++;
        }
        return ret;
    }
}
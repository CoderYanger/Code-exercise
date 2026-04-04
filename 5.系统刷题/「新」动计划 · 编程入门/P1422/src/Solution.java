/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-12
 * Time: 20:23
 */
class Solution {
    //1422. 分割字符串的最大得分
    //1ms击败98.61%
    public int maxScore(String ss) {
        char[] s=ss.toCharArray();
        int n=s.length,ret=0;
        //记录前缀和
        int[] prefix=new int[n];
        prefix[0]=s[0]=='0'?1:0;
        //记录后缀和
        int[] suffix=new int[n];
        suffix[n-1]=s[n-1]-'0';
        //统计前缀和
        for(int i=1;i<n;i++) prefix[i]=prefix[i-1]+(s[i]=='0'?1:0);
        for(int i=n-2;i>=0;i--){
            //统计后缀和
            suffix[i]=suffix[i+1]+s[i]-'0';
            //更新结果最大值
            ret=Math.max(ret,suffix[i+1]+prefix[i]);
        }
        return ret;
    }
}

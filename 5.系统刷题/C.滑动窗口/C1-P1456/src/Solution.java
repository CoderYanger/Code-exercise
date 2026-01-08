/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-19
 * Time: 19:14
 */
class Solution {
    //1456. 定长子串中元音的最大数目
    public int maxVowels(String ss, int k) {
        int ret=0;
        int tmp=0;//记录当前窗口内的元音数
        char[] s=ss.toCharArray();
        int n=s.length;
        //枚举右端点
        for(int right=0;right<n;right++){
            //入窗口
            if(islegal(s[right])) tmp++;
            //找到对应左端点
            int left=right-k+1;
            //left<0时说明还未形成大小为k的窗口
            if(left<0) continue;
            //更新
            ret=Math.max(ret,tmp);
            //小优化:统计结果=k时直接返回
            if(ret==k) return ret;
            //出窗口
            char out=s[left];
            if(islegal(out)) tmp--;
        }
        return ret;
    }
    public boolean islegal(char c){
        if(c=='a'||c=='e'||c=='i'
                ||c=='o'||c=='u') return true;
        return false;
    }
}
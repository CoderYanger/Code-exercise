/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-02
 * Time: 19:59
 */
class Solution {
    //3258. 统计满足 K 约束的子字符串数量 I
    public int countKConstraintSubstrings(String ss, int k) {
        char[] s=ss.toCharArray();
        int n=s.length,zero=0,one=0,ret=0;
        for(int left=0,right=0;right<n;right++){
            //进窗口
            if(s[right]=='0') zero++;
            else one++;
            //出窗口
            while(zero>k&&one>k){
                char out=s[left];
                if(out=='0') zero--;
                else one--;
                left++;
            }
            //更新
            ret+=right-left+1;
        }
        return ret;
    }
}
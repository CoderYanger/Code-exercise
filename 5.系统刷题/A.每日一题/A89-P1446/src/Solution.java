/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-13
 * Time: 09:46
 */
class Solution {
    //写法一：用cnt计数更新
    public int maxPower(String s) {
        int ret=1,cnt=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                cnt++;
                ret=Math.max(ret,cnt);
            }else cnt=1;
        }
        return ret;
    }

    //写法二：直接用长度更新
    public int maxPower(String s) {
        int ret=0,n=s.length();
        for(int i=0;i<n;){
            int start=i;
            i++;
            while(i<n&&s.charAt(i)==s.charAt(i-1)) i++;
            ret=Math.max(ret,i-start);
        }
        return ret;
    }
}
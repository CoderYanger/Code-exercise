/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-29
 * Time: 15:27
 */
class Solution {
    //2904. 最短且字典序最小的美丽子字符串
    public String shortestBeautifulSubstring(String ss, int k) {
        //先统计1的个数，无解直接返回空串
        int one=0;
        char[] s=ss.toCharArray();
        for(char c:s) if(c=='1') one++;
        if(one<k) return "";
        int n=s.length,count=0;
        int len=n;
        String ret=ss;
        for(int right=0,left=0;right<n;right++){
            //进窗口
            if(s[right]=='1') count++;
            //出窗口
            while(count>k||s[left]=='0')
                if(s[left++]=='1') count--;
            //更新
            if(count==k){
                //[left,right+1)->[left,right]
                String t=ss.substring(left,right+1);
                //长度更小或者字典序更小就更新
                if(t.length()<ret.length()||t.length()==ret.length()&&t.compareTo(ret)<0)
                    ret=t;
            }
        }
        return ret;
    }
}
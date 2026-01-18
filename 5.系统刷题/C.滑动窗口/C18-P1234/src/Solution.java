/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-29
 * Time: 18:05
 */
class Solution {
    //1234. 替换子串得到平衡字符串
    public int balancedString(String s) {
        //大小选择128可以覆盖所有ASCII字符
        int[] hash=new int[128];
        for(char c:s.toCharArray()) hash[c]++;
        //先判断是否已经符合条件
        int n=s.length();
        int m=n/4;
        if(hash['Q']==m&&hash['W']==m&&hash['E']==m&&hash['R']==m) return 0;
        //滑动窗口：窗口大小即可替换子串大小
        //保证窗口外的四个字符数量都<=m
        //这样窗口内更改之后才能保证四个字符数量=m
        //否则窗口外若字符>m，那么窗口内怎么更改都不能平衡
        int ret=n;
        for(int left=0,right=0;right<n;right++){
            //进窗口
            hash[s.charAt(right)]--;//hash统计的是子串[left,right]外面的字母个数
            while(hash['Q']<=m&&hash['W']<=m&&hash['E']<=m&&hash['R']<=m){
                //更新
                ret=Math.min(ret,right-left+1);
                //出窗口
                hash[s.charAt(left++)]++;//缩小子串，把left的字母放外面
            }
        }
        return ret;
    }
}
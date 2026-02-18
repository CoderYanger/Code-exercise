/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-20
 * Time: 12:39
 */
class Solution {
    //解法：暴力枚举模拟
    public int minDeletionSize(String[] strs) {
        String[] s=new String[1001];
        //遍历一个字符串的长度
        for(int i=0;i<strs[0].length();i++){
            //遍历每个字符串，获取第j个字符拼接在一起
            StringBuffer sb=new StringBuffer();
            for(int j=0;j<strs.length;j++)
                sb.append(strs[j].charAt(i));
            s[i]=sb.toString();
        }
        //检查是否符合升序
        int ret=0;
        for(String ss:s)
            if(ss!=null&&!islegal(ss))
                ret++;
        return ret;
    }
    private boolean islegal(String s){
        for(int i=1;i<s.length();i++)
            if(s.charAt(i)<s.charAt(i-1))
                return false;
        return true;
    }

    //优化后的代码
    public int minDeletionSize(String[] strs) {
        int n=strs.length,m=strs[0].length();
        int ret=0;
        //遍历每一列
        for(int i=0;i<m;i++){
            //遍历每一个字符串
            for(int j=1;j<n;j++){
                if(strs[j-1].charAt(i)>strs[j].charAt(i)){
                    ret++;
                    break;
                }
            }
        }
        return ret;
    }
}
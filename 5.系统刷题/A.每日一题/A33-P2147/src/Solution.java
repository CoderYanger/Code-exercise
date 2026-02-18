/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-14
 * Time: 13:45
 */
class Solution {
    //2147. 分隔长廊的方案数
    public int numberOfWays(String ss) {
        int MOD=1_000_000_007;
        //统计座位的数量
        char[] s=ss.toCharArray();
        int count=0;
        for(char c:s) if(c=='S'){count++;count%=MOD;}
        if(count<2||count%2==1) return 0;
        long ret=1;
        int cnt=0,last=0;
        for(int i=0;i<s.length;i++){
            if(s[i]=='S'){
                cnt++;
                if(cnt>2&&cnt%2==1)
                    ret=ret*(i-last)%MOD;
                last=i;//记录上一个座位的位置
            }
        }
        return (int)ret;
    }
}
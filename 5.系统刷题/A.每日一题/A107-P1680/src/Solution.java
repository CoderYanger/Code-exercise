/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-28
 * Time: 07:46
 */
class Solution {
    //1680. 连接连续二进制数字
    private int MOD=1_000_000_007;
    public int concatenatedBinary(int n) {
        long ret=0;
        for(int i=1;i<=n;i++)
            ret=((ret<<count(i))|i)%MOD;
        return (int)ret;
    }
    //计算二进制位数
    private int count(int n){
        int cnt=0;
        while(n!=0){
            n/=2;
            cnt++;
        }
        return cnt;
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-06
 * Time: 23:20
 */
class Solution {
    //2266. 统计打字方案数
    private static final int MOD=1_000_000_007;
    //预处理到题目最大字符串范围，足够覆盖所有情况
    private static final int MX=100_001;
    //f数组：预处理连续n个对应3个字母的数字(非7非9)的组合数
    private static final long[] f=new long[MX];
    //f数组：预处理连续n个对应4个字母的数字(7/9)的组合数
    private static final long[] g=new long[MX];
    //初始化标记：避免重复预处理
    private static boolean done=false;
    //预处理f和g数组，仅执行一次
    private void init(){
        //已初始化过直接返回
        if(done) return;
        done=true;
        //空按键（长度0）：1种方案，什么都不按
        f[0]=g[0]=1;
        //按1次：1种方案
        f[1]=g[1]=1;
        //按2次：2种方案=11+2
        f[2]=g[2]=2;
        //按3次：4种方案=111+12+21+3
        f[3]=g[3]=4;
        //从4开始递推计算所有长度的方案数
        for(int i=4;i<MX;i++){
            //3字母键：方案数=前1次+前2次+前3次的方案数之和
            f[i]=(f[i-1]+f[i-2]+f[i-3])%MOD;
            //4字母键：方案数=前1次+前2次+前3次+前4次的方案数之和
            g[i]=(g[i-1]+g[i-2]+g[i-3]+g[i-4])%MOD;
        }
    }
    public int countTexts(String ss) {
        init();
        long ret=1;//乘法单位元
        int cnt=0;//统计当前连续相同按键的长度
        char[] s=ss.toCharArray();
        for(int i=0;i<s.length;i++){
            char c=s[i];
            //当前连续段+1
            cnt++;
            //判断当前连续段是否结束：
            //1.到达字符串末尾：i==s.length-1
            //2.下一个字符与当前字符不同：c!=s[i+1]
            if(i==s.length-1||c!=s[i+1]){
                //3字母键用f数组，4字母键用g数组
                ret=ret*(c!='7'&&c!='9'?f[cnt]:g[cnt])%MOD;
                cnt=0;
            }
        }
        return (int)ret;
    }
}

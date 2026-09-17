/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:22
 */
class Solution {
    //3881. 恰好看到 K 个人的方向选择
    private final int MOD=1_000_000_007;
    public int countVisiblePeople(int n, int pos, int k) {
        return (int)(2*comb(n-1,k)%MOD);
    }
    private long pow(long a,long b){
        long ret=1;
        for(;b>0;b>>=1){
            if((b&1)==1) ret=ret*a%MOD;
            a=a*a%MOD;
        }
        return ret%MOD;
    }
    private long comb(int n,int k){
        if(k==0||k==n) return 1;
        k=Math.min(k,n-k);
        long ret=1;
        for(int i=1;i<=k;i++){
            //先乘分子取模，避免溢出
            ret=ret*(n-k+i)%MOD;
            //÷i:直接/i会算错，因此×i的倒数，费马小定理：i的倒数=iᴹᴼᴰ⁻²
            ret=ret*pow(i,MOD-2)%MOD;
        }
        return ret;
    }

    //优化
    //3881. 恰好看到 K 个人的方向选择
    private static final int MOD=1_000_000_007;
    private static final int MX=100_001;
    //记录各数阶乘
    private static final long[] F=new long[MX];
    //记录各数逆元
    private static final long[] INV_F=new long[MX];
    //标记是否预处理过
    private static boolean init=false;
    public Solution(){
        if(init) return;
        init=true;
        F[0]=1;//0!=1
        //预处理所有阶乘：递推计算1!~1e5!
        for(int i=1;i<MX;i++) F[i]=F[i-1]*i%MOD;
        //预处理所有阶乘的逆元
        INV_F[MX-1]=pow(F[MX-1],MOD-2);
        //倒着推出所有逆元
        for(int i=MX-1;i>0;i--) INV_F[i-1]=INV_F[i]*i%MOD;
    }
    public int countVisiblePeople(int n, int pos, int k) {
        return (int)(2*comb(n-1,k)%MOD);
    }
    private long pow(long a,long b){
        long ret=1;
        for(;b>0;b>>=1){
            if((b&1)==1) ret=ret*a%MOD;
            a=a*a%MOD;
        }
        return ret%MOD;
    }
    private long comb(int n,int k){
        return F[n]*INV_F[k]%MOD*INV_F[n-k]%MOD;
    }
    
}

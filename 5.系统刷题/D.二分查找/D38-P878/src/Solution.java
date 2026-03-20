/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-26
 * Time: 21:47
 */
class Solution {
    //878. 第 N 个神奇数字
    //超时且错误的参考代码
    private int MOD=1_000_000_007;
    int[] memo;
    public int nthMagicalNumber(int k, int a, int b) {
        int left=a>b?b:a,right=k*Math.min(a,b);
        memo=new int[right+1];
        memo[0]=0;
        Arrays.fill(memo,-1);
        while(left<right){
            int mid=left+(right-left)/2;
            if(!check(mid,k,a,b)) left=mid+1;
            else right=mid;
        }
        return left%=MOD;
    }
    //判断mid内神奇的数字是否≥k
    private boolean check(int mid,int k,int a,int b){
        int min=a>b?b:a;
        int cnt=0;
        for(int i=mid;i>=min;i--){
            if(memo[i]!=-1){
                cnt+=memo[i];
                cnt%=MOD;
                break;
            }
            if(i%a==0||i%b==0){
                cnt++;
                cnt%=MOD;
            }
        }
        memo[mid]=cnt;
        return cnt>=k;
    }


    //正确解法：二分查找+容斥原理
    private int MOD=1_000_000_007;
    public int nthMagicalNumber(int k, int a, int b) {
        //用最大公因数算计算最小公倍数
        long lcm=a/gcd(a,b)*b;
        long left=Math.min(a,b)+k-2;
        long right=(long)Math.min(a,b)*k;
        while(left<right){
            long mid=left+(right-left)/2;
            if(!check(k,a,b,mid,lcm)) left=mid+1;
            else right=mid;
        }
        return (int)(left%MOD);
    }
    private boolean check(int k,long a,long b,long mid,long lcm){
        return mid/a+mid/b-mid/lcm>=k;
    }
    //辗转相除法计算a和b的最大公约数gcd
    private int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

}

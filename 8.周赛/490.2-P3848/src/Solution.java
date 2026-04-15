/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-22
 * Time: 16:02
 */
class Solution {
    //3848. 阶数数字排列
    public boolean isDigitorialPermutation(int n) {
        int[] hash=new int[10];
        int sum=0,m=n;
        while(m!=0){
            int t=m%10;
            hash[t]++;
            sum+=fac(t);
            m/=10;
        }
        while(sum!=0){
            int t=sum%10;
            hash[t]--;
            sum/=10;
        }
        for(int x:hash) if(x!=0) return false;
        return true;
    }
    private int fac(int n){
        if(n==0||n==1) return 1;
        int ret=1;
        for(int i=2;i<=n;i++) ret*=i;
        return ret;
    }
}
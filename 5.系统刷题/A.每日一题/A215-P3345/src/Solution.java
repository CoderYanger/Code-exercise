/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-09-01
 * Time: 20:09
 */
class Solution {
    //3345. 最小可整除数位乘积 I
    public int smallestNumber(int n, int t) {
        for(int i=n;i<n+10;i++){
            int ret=1,x=i;
            while(x>0){
                int tmp=x%10;
                ret*=tmp;
                x/=10;
            }
            if(ret%t==0) return i;
        }
        //照顾编译器
        return 0;
    }
}

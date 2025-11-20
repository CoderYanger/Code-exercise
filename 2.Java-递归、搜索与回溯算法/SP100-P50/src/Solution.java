/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-23
 * Time: 20:13
 */
class Solution {
    //50. Pow(x, n)
    public double myPow(double x, int n) {
        //自己按着思路写的，但是可能溢出的不知道咋写
        if(n==0) return 1;
        double tmp=0;
        if(n>=0) tmp= myPow(x,n/2);
        else tmp=1/myPow(x,n/2);
        return n%2==0?tmp*tmp:tmp*tmp*x;
    }
    public double myPow2(double x, int n) {
        //还是封装起来好些，这样能保证传入的n是正数
        return n<0?1.0/pow(x,-n):pow(x,n);
    }
    public double pow(double x, int n){
        if(n==0) return 1.0;
        double tmp=pow(x,n/2);
        return n%2==0?tmp*tmp:tmp*tmp*x;
    }
}

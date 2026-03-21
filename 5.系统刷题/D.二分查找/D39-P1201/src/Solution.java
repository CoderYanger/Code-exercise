/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-27
 * Time: 07:52
 */
class Solution {
    //1201. 丑数 III
    public int nthUglyNumber(int k, int a, int b, int c) {
        //转为long类型，避免后续计算溢出
        long A=a,B=b,C=c;
        long left=1,right=2_000_000_000;
        while(left<right){
            long mid=left+(right-left)/2;
            if(!check(mid,a,b,c,k)) left=mid+1;
            else right=mid;
        }
        return (int)left;
    }
    private boolean check(long mid,long a,long b,long c,long k){
        //计算两两之间最小公倍数
        long lcmab=lcm(a,b),lcmbc=lcm(b,c),lcmac=lcm(a,c);
        //计算三个数的最小公倍数
        long lcmabc=lcm(lcmab,c);
        //容斥原理：三个集合并集大小=单个集合和-两两交集和+三个集合交集
        return mid/a+mid/b+mid/c-mid/lcmab-mid/lcmbc-mid/lcmac+mid/lcmabc>=k;
    }
    //计算两数间最小公倍数
    private long lcm(long a,long b){
        return a/gcd(a,b)*b;
    }
    //计算两数间最大公因数
    private long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-31
 * Time: 20:45
 */
class Solution {
    //3296. 移山所需的最少秒数
    public long minNumberOfSeconds(int m, int[] w) {
        //找到最慢的工人
        int maxT=0;
        for(int t:w) maxT=Math.max(maxT,t);
        //山高均分给所有工人，计算每个工人至少要挖的高度
        int h=(m-1)/w.length+1;
        long left=0;
        //最慢工人挖h层的总时间
        //挖k层公式：t*(1+2+……+k)=t*k(k+1)/2
        long right=(long)maxT*h*(h+1)/2;
        while(left<right){
            long mid=left+(right-left)/2;
            //只要挖不完就往右调整mid
            if(check(mid,m,w)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    private boolean check(long mid,int m,int[] w){
        //遍历每个工人，累加总挖掘高度
        for(int t:w){
            //公式推导：t*k*(k+1)/2<=mid->解一元二次方程得k=[√(8mid/t+1)-1]/2
            //①计算8mid/t+1
            long calc=8*mid/t+1;
            //②开平方后转int
            int sqrtVal=(int)Math.sqrt(calc);
            //③代入公式得到最终层数k
            int k=(sqrtVal-1)/2;
            m-=k;//扣除当前工人挖的高度
        }
        return m>0;
    }
}
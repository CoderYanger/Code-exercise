/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-29
 * Time: 20:27
 */
class Solution {
    //1011. 在 D 天内送达包裹的能力
    public int shipWithinDays(int[] weights, int days) {
        int left=0,right=0;
        for(int x:weights){
            left=Math.max(left,x);
            right+=x;
        }
        while(left<right){
            int mid=left+(right-left)/2;
            //运载能力越小，需要天数越大，要让天数逐渐变小到恰好小于等于题述days，这个过程中mid不断右移，属于最左端点模型
            if(check(weights,mid,days)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    //mid对应的最小天数>题述days时返回true,对应二分区间中最左端点的左边
    private boolean check(int[] weights,int mid,int t){
        //贪心获取运载能力为mid时需要的天数
        int days=0;//至少需要一天
        long sum=0;
        //只要当前包裹重量<mid，就按顺序一直装，当超过的时候，就拿出来，放到明天装
        for(int x:weights){
            sum+=x;
            if(sum>mid){
                sum-=x;
                days++;
                sum=x;
            }
        }
        //拿出一天，把剩下的运走
        if(sum!=0) days++;
        return days>t;
    }
}
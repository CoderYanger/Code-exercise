/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-19
 * Time: 20:05
 */
class Solution {
    //LCP 12. 小张刷题计划
    public int minTime(int[] time,int m) {
        int n=time.length;
        if(n<=m) return 0;
        int left=0,right=0x3f3f3f3f;
        while(left<right){
            int mid=left+(right-left)/2;
            if(!check(mid,time,m)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    //判断每天耗时≤mid时，能否在m天内刷完题
    private boolean check(int mid,int[] time,int m){
        int days=1;//至少需要1天
        int daysum=0;//当天刷题的总耗时
        int daymax=0;//当天刷题的最大耗时
        for(int t:time){
            daysum+=t;
            daymax=Math.max(daymax,t);
            if(daysum-daymax>mid){
                days++;//开启新的一天
                daysum=t;//新的一天从当天开始
                daymax=t;//新一天最大耗时初始化
                if(days>m) return false;
            }
        }
        return days<=m;
    }
}

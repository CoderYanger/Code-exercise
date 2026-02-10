/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-04
 * Time: 18:16
 */
class Solution {
    //1870. 准时到达的列车最小时速
    public int minSpeedOnTime(int[] dist, double hour) {
        int left=1,right=10_000_000;
        //边界预处理：每段至少一小时，若hour不够直接返回-1
        if(hour<=dist.length-1) return -1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(check(mid,dist,hour)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    private boolean check(int mid,int[] dist, double hour){
        double time=0;
        int n=dist.length;
        for(int i=0;i<n;i++){
            //只有前n-1段需要向上取整，最后一段直接累加
            if(i!=n-1) time+=(double)((dist[i]-1)/mid+1);
            else time+=(double)dist[i]/mid;
            //如果超时了，说明速度太慢，要提速，向右移动，所以返回true
            if(time>hour) return true;
        }
        return time>hour;
    }
}
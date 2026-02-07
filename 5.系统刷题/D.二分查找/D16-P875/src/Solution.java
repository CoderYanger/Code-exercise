/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-30
 * Time: 13:38
 */
class Solution {
    //875. 爱吃香蕉的珂珂
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=0;
        for(int x:piles)
            right=Math.max(right,x);
        while(left<right){
            int mid=left+(right-left)/2;
            if(check(piles,mid,h)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    private boolean check(int[] piles,int mid,int t){
        int h=0;
        for(int x:piles){
            //mid的速度吃若干次能恰好吃完当前堆的香蕉
            if(x%mid==0) h+=(int)(x/mid);
                //mid的速度吃若干次当前堆香蕉后仍有剩余，需要再来一小时吃剩下的
            else h+=(int)(x/mid)+1;
        }
        return h>t;
    }
}
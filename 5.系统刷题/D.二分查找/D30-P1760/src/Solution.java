/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-15
 * Time: 21:30
 */
class Solution {
    //1760. 袋子里最少数目的球
    public int minimumSize(int[] nums, int m) {
        int left=1,right=0;
        for(int x:nums) right=Math.max(right,x);
        while(left<right){
            int mid=left+(right-left)/2;
            if(!check(mid,nums,m)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    //判断经过最多maxOperations次操作后，能否让所有袋子的球都≤mid
    private boolean check(int mid,int[] nums,int m){
        long r=0;//累计操作次数
        for(int x:nums){
            //对每个袋子x，计算需要的操作次数累加
            r+=(x-1)/mid;
            //次数超过m，直接返回false
            if(r>m) return false;
        }
        //总操作次数≤m，说明mid可行
        return r<=m;
    }
}

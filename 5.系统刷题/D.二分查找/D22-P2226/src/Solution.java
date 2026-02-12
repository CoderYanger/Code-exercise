/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-06
 * Time: 10:45
 */
class Solution {
    //2226. 每个小孩最多能分到多少糖果
    public int maximumCandies(int[] candies, long k) {
        long left=1,right=0,sum=0;
        for(int x:candies) sum+=x;
        //糖果不够分直接返回0
        if(sum<k) return 0;
        right=sum/k;
        while(left<right){
            long mid=left+(right-left+1)/2;
            if(check(mid,candies,k)) right=mid-1;
            else left=mid;
        }
        return (int)left;
    }
    //判断每人分mid个苹果，能否分给k个孩子
    private boolean check(long mid,int[] candies, long k){
        long count=0;
        //计算每堆按mid分，能分给多少孩子
        for(int x:candies) count+=x/mid;
        //如果有孩子没捞着，说明前面孩子糖果给多了，需要减少些
        return count<k;
    }
}
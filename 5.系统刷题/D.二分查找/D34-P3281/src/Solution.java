import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-22
 * Time: 15:02
 */
class Solution {
    //3281. 范围内整数的最大得分
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int n=start.length;
        //最大可能得分=最右端点-最左端点
        int left=0,right=start[n-1]+d-start[0];
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(!check(mid,start,d)) right=mid-1;
            else left=mid;
        }
        return left;
    }
    private boolean check(int mid,int[] start,int d){
        int n=start.length;
        //贪心策略：第一个数选区间左端点，给后续留最大选择空间
        long prev=start[0];
        for(int i=1;i<n;i++){
            //①当前数必须比上个数大mid，保证相邻差≥mid
            //②当前数必须在区间内，不能小于区间左端点start[i]
            //取①和②的最大值以保证满足①②
            long cur=Math.max(prev+mid,start[i]);
            //如果超过区间右端点，说明mid不可行
            if(cur>start[i]+d) return false;
            prev=cur;//更新prev，处理后续区间
        }
        return true;
    }
}
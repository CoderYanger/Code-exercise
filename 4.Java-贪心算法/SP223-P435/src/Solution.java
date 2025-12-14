import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-11
 * Time: 17:59
 */
class Solution {
    //435. 无重叠区间
    //跟56题合并区间非常相似，甚至在返回值上更简单，就是条件改了下，一开始忘记排序导致报错了一次，其余一遍过
    //跟吴小哲写的一样
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        //按照左端点排序
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);//一开始忘记写了
        int ret=0;
        int right=intervals[0][1];
        for(int i=1;i<n;i++){
            int a=intervals[i][0],b=intervals[i][1];
            if(a<right){//有重叠区间
                ret++;
                right=Math.min(right,b);//贪心：删除右端点较大的区间
            }
            else right=b;//没有重叠区间
        }
        return ret;
    }
}
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-19
 * Time: 15:18
 */
class Solution {
    //1288. 删除被覆盖区间
    public int removeCoveredIntervals(int[][] intervals) {
        //按区间左端点从小到大排序
        //区间左端点相同时，按区间右端点从大到小排序，这样会先遍历大区间，再遍历被大区间覆盖的小区间
        Arrays.sort(intervals,(a, b)->a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]);
        int ret=0;
        int maxRight=0;//已遍历区间中的最大右端点
        for(int[] p:intervals){
            //由于区间左端点是从小到大排序的，已遍历区间的左端点都<=当前区间的左端点
            //如果当前区间右端点<=maxRight，说明当前区间被另一个区间覆盖，否则没被覆盖
            if(p[1]>maxRight){
                maxRight=p[1];
                ret++;//当前区间没被覆盖
            }
        }
        return ret;
    }
}

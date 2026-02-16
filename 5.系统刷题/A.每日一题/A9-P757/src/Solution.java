import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-20
 * Time: 23:07
 */
class Solution {
    //757. 设置交集大小至少为2
    public int intersectionSizeTwo(int[][] nums) {
        //按右端点升序，右端点相同则左端点降序
        Arrays.sort(nums,(a, b)->a[1]!=b[1]?a[1]-b[1]:b[0]-a[0]);
        int ret = 2;
        int n = nums.length;
        //初始化为第一个区间的最右侧两个数
        //（贪心核心：选最右两数覆盖更多后续区间）
        int last2=nums[0][1]-1;//上一轮选择的较小数
        int last1=nums[0][1];//上一轮选择的较大数
        for (int i = 1; i < n; i++) {
            int a = nums[i][0], b = nums[i][1];
            //重叠判断逻辑：基于上一轮的两个选择数
            if (a > last1) {
                //无重叠，需新增2个数（当前区间最右侧两数）
                ret += 2;
                last2 = b - 1;
                last1 = b;
            } else if (a > last2) {
                //仅重叠1个数（last1），需新增1个数（当前区间右端点）
                ret += 1;
                last2 = last1;
                last1 = b;
            }
            //否则：a<=last2，两个数都重叠，无需新增
        }
        return ret;
    }
}
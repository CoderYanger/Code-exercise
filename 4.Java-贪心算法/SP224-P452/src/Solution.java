import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-11
 * Time: 20:45
 */
class Solution {
    //452. 用最少数量的箭引爆气球
    //自己看着算法写了一下，第一次报错是因为忘记Arrays.sort排序了
    //第二次报错是因为这次的测试用例边界是最大值和最小值，单单用a[0]-b[0]会导致溢出，很小的数一下子变成很大的数，影响排序，从而影响结果
    //其余跟吴小哲的一样
    public int findMinArrowShots(int[][] nums) {
        int n=nums.length;
        Arrays.sort(nums,(a,b)->{
            return a[0]>b[0]?1:-1;//这里要改动一下
        });
        int ret=1;
        int right=nums[0][1];
        for(int i=1;i<n;i++){
            int a=nums[i][0],b=nums[i][1];
            if(a<=right) right=Math.min(right,b);
            else {right=b;ret++;}
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] nums={{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(new Solution().findMinArrowShots(nums));
    }
}
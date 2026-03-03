import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-16
 * Time: 14:52
 */
class Solution {
    //2943. 最大化网格图中正方形空洞的面积
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int side=Math.min(f(hBars),f(vBars))+1;
        return side*side;
    }
    //返回a排序后的最长递增子数组的长度
    private int f(int[] a){
        Arrays.sort(a);
        int ret=1;//题目保证了数组中一定有数
        //计算当前统计的连续子数组的长度
        int count=1;
        for(int i=1;i<a.length;i++){
            //当前数能和上一个数连续上就更新
            if(a[i]==a[i-1]+1){
                count++;
                ret=Math.max(ret,count);
            }else count=1;//从当前数重新计数
        }
        return ret;
    }

    //优化写法
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int side=Math.min(longestConsecutive(hBars),longestConsecutive(vBars))+1;
        return side*side;
    }
    //直接把128题的代码搬过来用
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        //把nums里的元素全扔哈希表里
        for (int x : nums) hash.add(x);
        int ret = 0;
        for (int x : hash) {
            //如果x前面还有更小的，那么当前x一定不能作最长连续子序列的起点，直接跳过
            if (hash.contains(x - 1)) continue;
            //x是序列的起点
            int y = x + 1;
            while (hash.contains(y)) y++;
            //循环结束之后，y-1是最后一个在哈希集合的数
            //从x到y-1一共y-x个数
            ret = Math.max(ret, y - x);
            //小优化：当前连续子序列长度超过原数组的一半时
            //不可能再有比这个长的了，直接返回
            if (ret * 2 >= hash.size()) break;
        }
        return ret;
    }
}

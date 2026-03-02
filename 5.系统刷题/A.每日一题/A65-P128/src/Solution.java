import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-16
 * Time: 14:35
 */
class Solution {
    //128. 最长连续序列
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash=new HashSet<>();
        //把nums里的元素全扔哈希表里
        for(int x:nums) hash.add(x);
        int ret=0;
        for(int x:hash){
            //如果x前面还有更小的，那么当前x一定不能作最长连续子序列的起点，直接跳过
            if(hash.contains(x-1)) continue;
            //x是序列的起点
            int y=x+1;
            while(hash.contains(y)) y++;
            //循环结束之后，y-1是最后一个在哈希集合的数
            //从x到y-1一共y-x个数
            ret=Math.max(ret,y-x);
            //小优化：当前连续子序列长度超过原数组的一半时
            //不可能再有比这个长的了，直接返回
            if(ret*2>=hash.size()) break;
        }
        return ret;
    }
}
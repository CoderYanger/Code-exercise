import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 14:39
 */
class Solution {
    //3741.三个相等元素之间的最小距离 II
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        if(n<3) return -1;
        int ret=0x3f3f3f3f;
        //利用哈希表优化
        HashMap<Integer, List<Integer>> hash=new HashMap<>();
        //统计每个数值的所有下标
        for(int i=0;i<n;i++){
            List<Integer> index=hash.getOrDefault(nums[i],new ArrayList<>());
            index.add(i);
            hash.put(nums[i],index);
        }
        //遍历每个数值的下标列表，计算最小距离
        for(Map.Entry<Integer,List<Integer>> entry:hash.entrySet()){
            List<Integer> index=entry.getValue();
            int len=index.size();
            if(len>=3){
                for(int i=0;i<=len-3;i++){
                    int dist=index.get(i+2)-index.get(i);
                    //此处是去掉绝对值之后，相加得到的简化2*(i+2的位置-i的位置)
                    if(2*dist<ret) ret=2*dist;
                }
            }
        }
        return ret==0x3f3f3f3f?-1:ret;
    }
}
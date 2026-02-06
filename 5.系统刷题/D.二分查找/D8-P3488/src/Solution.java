import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-15
 * Time: 18:27
 */
class Solution {
    //3488. 距离最小相等元素查询
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer,List<Integer>> hash=new HashMap<>();
        int n=nums.length;
        List<Integer> ret=new ArrayList<>();
        for(int i=0;i<n;i++)
            hash.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        for(int i:queries){
            //i是nums的下标
            List<Integer> p=hash.get(nums[i]);
            int k=p.size();
            //这个元素只出现一次
            if(k==1){ret.add(-1);continue;}
            //找到当前i在列表p中的位置
            //由于当前索引一定在p中存在，所以用最左端点和最右端点的模型均可
            int left=0,right=p.size()-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if(p.get(mid)<i) left=mid+1;
                else right=mid;
            }
            int prev=(left-1+k)%k;
            int next=(left+1)%k;
            //计算原数组索引的距离
            int disprev = Math.min(Math.abs(i-p.get(prev)), n - Math.abs(i-p.get(prev))); // nums环形距离
            int disnext = Math.min(Math.abs(i-p.get(next)), n - Math.abs(i-p.get(next))); // nums环形距离
            ret.add(Math.min(disnext,disprev));
        }
        return ret;
    }
}
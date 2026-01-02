import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-21
 * Time: 16:53
 */
class Solution {
    //3779. 得到互不相同元素的最少操作次数
    public int minOperations(int[] nums) {
        int n=nums.length;
        Queue<Integer> q=new LinkedList<>();
        //存<数，出现次数>
        Map<Integer,Integer> hash=new HashMap<>();
        for(int x:nums){
            q.offer(x);
            hash.put(x,hash.getOrDefault(x,0)+1);
        }
        //所有元素均不重复就立刻返回
        if(hash.keySet().size()==q.size()) return 0;
        int ret=0;
        //数组不空且不包含任何重复元素才进入循环
        while(!q.isEmpty()&&hash.keySet().size()!=q.size()){
            if(q.size()<3) return ret+1;
            for(int i=0;i<3;i++){
                int out=q.poll();
                hash.put(out,hash.get(out)-1);
                if(hash.get(out)==0) hash.remove(out);
            }
            ret++;
            //如果剩余元素均不重复，直接返回结果
            if(hash.keySet().size()==q.size()) return ret;
        }
        return ret;
    }
}
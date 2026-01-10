import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-22
 * Time: 14:45
 */
class Solution {
    //2841. 几乎唯一子数组的最大和
    public long maxSum(List<Integer> nums, int m, int k) {
        long ret=0,sum=0;
        long n=nums.size();
        Map<Integer,Integer> hash=new HashMap<>();
        for(int right=0;right<n;right++){
            int left=right-k+1;
            //进窗口
            int in=nums.get(right);
            sum+=in;
            hash.put(in,hash.getOrDefault(in,0)+1);
            if(left<0) continue;
            if(hash.keySet().size()>=m)
                ret=Math.max(ret,sum);
            //出窗口
            int out=nums.get(left);
            sum-=out;
            hash.put(out,hash.get(out)-1);
            if(hash.get(out)==0) hash.remove(out);
        }
        return ret;
    }

    //转成数组优化：数组的下标访问速度>List.get()
    public long maxSum2(List<Integer> nums, int m, int k) {
        long ret=0,sum=0;
        long n=nums.size();
        Integer[] s=nums.toArray(new Integer[0]);
        //也可以写成Integer[] s=nums.toArray(Integer[]::new);
        //二者本质没有区别，第二种写法是更为现代的构造器写法，第一种明确告诉创建Integer数组
        Map<Integer,Integer> hash=new HashMap<>();
        for(int right=0;right<n;right++){
            int left=right-k+1;
            //进窗口
            int in=s[right];
            sum+=in;
            hash.put(in,hash.getOrDefault(in,0)+1);
            if(left<0) continue;
            if(hash.keySet().size()>=m)
                ret=Math.max(ret,sum);
            //出窗口
            int out=s[left];
            sum-=out;
            hash.put(out,hash.get(out)-1);
            if(hash.get(out)==0) hash.remove(out);
        }
        return ret;
    }
}

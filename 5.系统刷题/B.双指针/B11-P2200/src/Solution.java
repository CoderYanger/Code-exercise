import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-16
 * Time: 20:15
 */
class Solution {
    //2200. 找出数组中的所有 K 近邻下标
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ret=new ArrayList<>();
        Set<Integer> hash=new HashSet<>();
        int n=nums.length;
        //把等于key的下标放进hash表里
        for(int i=0;i<n;i++) if(nums[i]==key) hash.add(i);
        for(int i=0;i<n;i++){//枚举nums的每一个位置进行判断
            for(int x:hash)
                if(Math.abs(i-x)<=k){
                    ret.add(i);
                    break;
                }
        }
        return ret;
    }

    //一次遍历
    public List<Integer> findKDistantIndices2(int[] nums, int key, int k) {
        List<Integer> ret=new ArrayList<>();
        int r=0;//未被判断的最小下标（右边界）
        int n=nums.length;
        for(int j=0;j<n;j++){
            if(nums[j]==key){
                int l=Math.max(r,j-k);//计算左边界
                r=Math.min(n-1,j+k)+1;//计算右边界
                for(int i=l;i<r;i++) ret.add(i);
            }
        }
        return ret;
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-01
 * Time: 08:29
 */
class Solution {
    //540. 有序数组中的单一元素
    //解法一：位运算
    public int singleNonDuplicate(int[] nums) {
        int ret=0;
        for(int x:nums) ret^=x;
        return ret;
    }

    //解法二：哈希表
    public int singleNonDuplicate(int[] nums) {
        Map<Integer,Integer> hash=new HashMap<>();
        for(int x:nums) hash.put(x,hash.getOrDefault(x,0)+1);
        for(Map.Entry<Integer,Integer> entry:hash.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();
            if(val==1) return key;
        }
        //照顾编译器
        return -1;
    }

    //解法三：二分查找
    public int singleNonDuplicate(int[] nums) {
        int left=0,right=nums.length/2;
        while(left<right){
            int mid=left+(right-left)/2;
            if(check(mid,nums)) left=mid+1;
            else right=mid;
        }
        return nums[left*2];
    }
    private boolean check(int mid,int[] nums){
        return nums[mid*2]==nums[mid*2+1];
    }
}

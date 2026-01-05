import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-16
 * Time: 20:41
 */
class Solution {
    //2441. 与对应负数同时存在的最大正整数
    public int findMaxK(int[] nums) {
        int ret=0;
        for(int i=0;i<nums.length;i++)
            for(int x:nums)
                if(x==-nums[i])
                    ret=Math.max(ret,Math.abs(x));
        return ret==0?-1:ret;
    }

    //哈希表解法
    public int findMaxK(int[] nums) {
        Set<Integer> hash=new HashSet<>();
        int ret=-1;
        for(int x:nums) hash.add(x);
        for(int x:nums) if(hash.contains(-x)) 
            ret=Math.max(ret,Math.abs(x));
        return ret;
    }

    //排序+双指针
    public int findMaxK2(int[] nums) {
        int n=nums.length;
        int left=0,right=n-1;
        Arrays.sort(nums);
        while(left<right){
            while(left<right&&nums[left]<-nums[right]) left++;
            if(nums[left]==-nums[right]) return nums[right];
            right--;
        }
        return -1;
    }
}
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-16
 * Time: 22:34
 */
class Solution {
    //2465. 不同的平均值数目
    public int distinctAverages(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int left=0,right=n-1;
        Set<Double> set=new HashSet<>();
        double sum=0;
        while(left<right){
            sum=((double)nums[left]+(double)nums[right])/2;
            set.add(sum);
            left++;right--;
        }
        return set.size();
    }
    //优化：哈希表不用真的存平均值，直接存和就行
    public int distinctAverages2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int left=0,right=n-1;
        Set<Integer> set=new HashSet<>();
        while(left<right){
            set.add(nums[left]+nums[right]);
            left++;right--;
        }
        return set.size();
    }

    public int distinctAverages3(int[] nums) {
        Arrays.sort(nums);
        boolean set[]=new boolean[201];
        int ret=0;
        int n=nums.length;
        for(int i=0;i<n/2;i++) {
            int t=nums[i]+nums[n-i-1];
            if(!set[t]) {
                ret++;
                set[t]=true;
            }
        }
        return ret;
    }
}
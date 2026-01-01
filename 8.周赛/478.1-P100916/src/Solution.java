import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-30
 * Time: 12:46
 */
class Solution {
    //100916. 统计合格元素的数目
    public int countElements(int[] nums, int k) {
        int n=nums.length;
        if(n==0) return 0;
        if(k==0) return n;
        Arrays.sort(nums);
        int ret=0,i=0;
        while(i<n){
            int j=i;
            //保证相同元素不漏算
            while(j<n&&nums[j]==nums[i]) j++;
            if(n-j>=k) ret+=(j-i);
            i=j;
        }
        return ret;
    }
}

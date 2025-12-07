import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-23
 * Time: 19:37
 */
class Solution {
    //376.摆动序列
    //看完算法原理后自己写的，一遍过，跟第24题（978.最长的湍流子数组）思路一样
    //就是区别在这个可以不连续，所以要逐步更新，只在最长的长度上+1
    //吴小哲跟我写的一样
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        int[] f=new int[n];
        int[] g=new int[n];
        Arrays.fill(f,1);
        Arrays.fill(g,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) f[i]=Math.max(f[i],g[j]+1);
                else if(nums[j]>nums[i]) g[i]=Math.max(g[i],f[j]+1);
            }
        }
        int ret=1;
        for(int x:f) ret=Math.max(ret,x);
        for(int x:g) ret=Math.max(ret,x);
        return ret;
    }
}
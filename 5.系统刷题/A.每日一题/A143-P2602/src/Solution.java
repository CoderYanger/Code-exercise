import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-08
 * Time: 17:38
 */
class Solution {
    //2602. 使数组元素全部相等的最少操作次数
    //解法一：暴力枚举（会超时）
    public List<Long> minOperations(int[] _nums, int[] queries) {
        List<Long> ret=new ArrayList<>();
        for(int x:queries){
            int[] nums=_nums.clone();
            long cnt=0;
            for(int y:nums) cnt+=Math.abs(y-x);
            ret.add(cnt);
        }
        return ret;
    }
    //解法二：前缀和+二分查找
    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> ret=new ArrayList<>();
        int n=nums.length;
        int m=queries.length;
        Arrays.sort(nums);
        //预处理前缀和
        long[] sum=new long[n];
        sum[0]=nums[0];
        for(int i=1;i<n;i++) sum[i]=sum[i-1]+nums[i];
        for(int x:queries){
            //最左端点模型：找第一个≥x的位置
            int left=0,right=n-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if(nums[mid]<x) left=mid+1;
                else right=mid;
            }
            //判断left在首尾位置的特殊情况
            //left==0：所有数都≥x
            //left==n-1：所有数都<x
            if(left==0||left==n-1) ret.add(Math.abs(1L*x*n-sum[n-1]));
            else ret.add(1L*x*left-sum[left-1]+(sum[n-1]-sum[left-1])-1L*(n-left)*x);
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,6,8};
        int[] queries = {1,5};
        Solution solution = new Solution();
        System.out.println(solution.minOperations(nums, queries));
    }
}

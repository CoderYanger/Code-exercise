import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 15:00
 */
class Solution {
    //3727. 最大交替平方和
    public long maxAlternatingSum(int[] arr) {
        Integer[] nums=new Integer[arr.length];
        for(int i=0;i<arr.length;i++)
            nums[i]=(Integer)arr[i];
        //按绝对值，从小到大排序
        Arrays.sort(nums,(a, b)->Math.abs(a)-Math.abs(b));
        int n=nums.length;
        int mid=n/2;
        int[] mi=new int[n];
        int[] ma=new int[n];
        for(int i=0;i<mid;i++) mi[i]=-1*nums[i]*nums[i];
        for(int i=mid;i<n;i++) ma[i]=nums[i]*nums[i];
        long ret=0;
        for(int i=0;i<n;i++)
            ret+=(long)ma[i]+(long)mi[i];
        return ret;
    }
}
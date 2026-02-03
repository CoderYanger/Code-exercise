import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-14
 * Time: 18:35
 */
class Solution {
    //2389. 和有限的最长子序列
    public int[] answerQueries(int[] nums, int[] queries) {
        int n=nums.length,m=queries.length;
        int[] ret=new int[m];int index=0;
        //定义前缀和数组
        int[] pre=new int[n];
        Arrays.sort(nums);
        pre[0]=nums[0];
        for(int i=1;i<n;i++) pre[i]=pre[i-1]+nums[i];
        for(int x:queries){
            int left=0,right=n-1;
            //找最右端点
            while(left<right){
                int mid=left+(right-left+1)/2;
                if(pre[mid]>x) right=mid-1;
                else left=mid;
            }
            ret[index++]=pre[left]<=x?left+1:0;
        }
        return ret;
    }
}

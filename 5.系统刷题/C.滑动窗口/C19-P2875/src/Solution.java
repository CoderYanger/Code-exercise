/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-30
 * Time: 22:46
 */
class Solution {
    //2875. 无限数组的最短子数组
    public int minSizeSubarray(int[] fnums, int target) {
        int n=fnums.length;
        int total=0;
        for(int x:fnums) total+=x;
        //拼接2倍长度数组
        int[] nums=new int[2*n];
        int index=0;
        for(int i=0;i<2*n;i++){
            if(i==n) index=0;
            nums[i]=fnums[index++];
        }
        int rem=target%total,sum=0,ret=2*n;
        for(int right=0,left=0;right<2*n;right++){
            //进窗口
            sum+=nums[right];
            //出窗口
            while(sum>rem) sum-=nums[left++];
            //更新
            if(sum==rem) ret=Math.min(ret,right-left+1);
        }
        return ret==2*n?-1:(ret+(target/total)*n);
    }
}
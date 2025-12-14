import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-12
 * Time: 15:10
 */
class Solution {
    //354. 俄罗斯套娃信封问题
    //动态规划解法（会超时）
    //看着算法原理自己写的
    //逻辑上是对的，除了忘记排序，其余跟吴小哲写的一样
    public int maxEnvelopes(int[][] nums) {
        Arrays.sort(nums,(a, b)->a[0]-b[0]);//一开始忘记排序了
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++)
            for(int j=0;j<i;j++)
                if(nums[i][0]>nums[j][0]&&nums[i][1]>nums[j][1])
                    dp[i]=Math.max(dp[j]+1,dp[i]);
        int ret=1;
        for(int i=0;i<n;i++) ret=Math.max(ret,dp[i]);
        return ret;
    }

    //就是重写排序+贪心+二分
    //二分是300求最长递增子序列的二分，我有些忘了，就自己没写出来，看的吴小哲的
    //我没太理解透彻的点在：为什么等号在右边，这样就是左边没等号->求最左端点->mid在其左边就让left往里靠，还要超过left=mid+1
    public int maxEnvelopes2(int[][] e) {
        Arrays.sort(e,(a,b)->{
            return a[0]!=b[0]?a[0]-b[0]:b[1]-a[1];
        });
        int n=e.length;
        //左端点已经排好序了，只需要找到右端点有几个符合条件的就行
        List<Integer> ret=new ArrayList<>();
        ret.add(e[0][1]);
        for(int i=1;i<n;i++){
            int b=e[i][1];
            //b比最后一个元素大直接加后面
            if(b>ret.get(ret.size()-1)) ret.add(b);
            else{
                int left=0,right=ret.size()-1;
                while(left<right){
                    int mid=left+(right-left)/2;
                    if(ret.get(mid)<b) left=mid+1;
                    else right=mid;
                }
                ret.set(left,b);
            }
        }
        return ret.size();
    }
}
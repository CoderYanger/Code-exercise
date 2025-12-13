/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-03
 * Time: 20:35
 */
class Solution {
    //122. 买卖股票的最佳时机 II
    //解法一：双指针，自己看完算法原理后写的
    //错误处，i=j已经帮i更新了，for循环内就没必要i++了
    //跟吴小哲的差不多
    public int maxProfit(int[] nums) {
        int n=nums.length;
        int ret=0;
        for(int i=0;i<n;){
            int j=i+1;
            while(j<n&&nums[j]>nums[j-1]) j++;
            ret+=nums[j-1]-nums[i];
            i=j;
        }
        return ret;
    }

    //解法二：拆分交易，把一段交易拆分成一天一天
    //自己写的，跟上一个解法基本一样，一遍过
    //跟吴小哲写的基本一样
    public int maxProfit2(int[] nums) {
        int n=nums.length;
        int ret=0;
        for(int i=0;i<n;){
            int j=i+1;
            if(j<n&&nums[j]>nums[j-1]) ret+=nums[j]-nums[i];
            i=j;
        }
        return ret;
    }
}
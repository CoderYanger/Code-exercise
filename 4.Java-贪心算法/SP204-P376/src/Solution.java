/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-30
 * Time: 19:45
 */
class Solution {
    //376. 摆动序列
    //看着吴小哲的算法原理自己写出来的
    //跟吴小哲的差不多
    public int wiggleMaxLength(int[] nums) {
        int left=0;
        int ret=1;//先把最后一个点算上
        for(int i=0;i+1<nums.length;i++){
            int right=nums[i+1]-nums[i];//计算接下来的趋势
            if(right==0) continue;//如果水平，直接跳过
            if(left*right<=0) ret++;//累加波峰或者波谷
            left=right;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wiggleMaxLength(new int[]{1,7,4,9,2,5}));
    }
}
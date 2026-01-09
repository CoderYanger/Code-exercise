/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-20
 * Time: 23:56
 */
class Solution {
    //2090. 半径为 k 的子数组平均值
    public int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        long sum=0;//改为long，因为最后一个测试用例会整型溢出
        int[] ret=new int[n];
        //先把前k个数放进去
        for(int i=0;i<n&&i<k;i++) sum+=nums[i];
        for(int i=0;i<n;i++){
            if(i+k>=n){ret[i]=-1;continue;}
            //入窗口
            sum+=nums[i+k];
            if(i-k<0){ret[i]=-1;continue;}
            //更新
            ret[i]=(int)(sum/(2*k+1));
            //出窗口
            sum-=nums[i-k];
        }
        return ret;
    }
}

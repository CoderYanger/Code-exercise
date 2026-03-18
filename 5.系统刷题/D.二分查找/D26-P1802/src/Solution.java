/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-11
 * Time: 14:25
 */
class Solution {
    //1802. 有界数组中指定下标处的最大值
    public int maxValue(int n, int index, int maxSum) {
        int left=1,right=maxSum;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(!check(n,mid,maxSum,index)) right=mid-1;
            else left=mid;
        }
        return left;
    }
    //判断nums[index]=mid时是否符合条件
    private boolean check(int n,int mid,int maxSum,int index){
        //先算上中间元素
        long sum=mid;
        int L=index;//左边元素个数
        int R=n-1-index;//右边元素个数
        //计算左边和:不可连续递减就递减到1后保持1
        if(mid-1>=L) sum+=(long)L*(2*mid-1-L)/2;
        else sum+=(long)(mid-1)*mid/2+(L-(mid-1));
        //计算右边和:逻辑与左边一致
        if(mid-1>=R) sum+=(long)R*(2*mid-1-R)/2;
        else sum+=(long)(mid-1)*mid/2+(R-(mid-1));
        return sum<=maxSum;
    }
}

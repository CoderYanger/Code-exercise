/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-16
 * Time: 22:06
 */
class Solution {
    //2460. 对数组执行操作
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        //先按要求更改数组
        for(int i=0;i+1<n;i++)
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]=0;
            }
        //移动0
        int dest=-1;//一开始cur左面没有0元素
        //[0,dest][dest+1,cur-1][cur,n-1]
        for(int cur=0;cur<n;cur++){
            if(nums[cur]!=0){
                dest++;//dest先++
                //交换
                int tmp=nums[cur];
                nums[cur]=nums[dest];
                nums[dest]=tmp;
            }
        }
        return nums;
    }
}
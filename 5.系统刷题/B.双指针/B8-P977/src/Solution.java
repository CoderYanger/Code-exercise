import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-15
 * Time: 21:15
 */
class Solution {
    //977. 有序数组的平方
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++) nums[i]=nums[i]*nums[i];
        Arrays.sort(nums);
        return nums;
    }

    //双指针优化
    public int[] sortedSquares2(int[] nums) {
        int n=nums.length;
        int mid=-1;//用于把负数和正数分开
        for(int i=0;i<n;i++){
            if(nums[i]<0) mid=i;
            else break;
        }
        int[] ret=new int[n];
        int index=0,i=mid,j=mid+1;
        while(i>=0||j<n){//只要不越界就走
            //都是正数时，mid依旧是-1
            //正数平方后依旧升序，往后遍历
            if(i<0){ret[index]=nums[j]*nums[j];j++;}
            //都是负数时，mid走到了最后一个位置
            //因为负数平方后变成降序，所以往前遍历
            else if(j==n){ret[index]=nums[i]*nums[i];i--;}
            //正数和负数都有时，mid处于中间位置
            //正数的j往右走，负数的i往左走，挑平方小的放ret里
            else if(nums[i]*nums[i]<nums[j]*nums[j]){
                ret[index]=nums[i]*nums[i];i--;
            }else{ret[index]=nums[j]*nums[j];j++;}
            index++;//统一++
        }
        return ret;
    }
}

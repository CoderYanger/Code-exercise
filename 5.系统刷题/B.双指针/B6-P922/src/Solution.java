/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-15
 * Time: 20:57
 */
class Solution {
    //922. 按奇偶排序数组 II
    //一遍过
    public int[] sortArrayByParityII(int[] nums) {
        int[] ret=new int[nums.length];
        //先放偶数
        int index=0;
        for(int x:nums) if(x%2==0){ret[index]=x;index+=2;}
        //再放奇数
        index=1;
        for(int x:nums) if(x%2==1){ret[index]=x;index+=2;}
        return ret;
    }

    //解法二：双指针实现原地交换
    public int[] sortArrayByParityII2(int[] nums) {
        int n=nums.length;
        int j=1;
        for(int i=0;i<n;i+=2){
            if(nums[i]%2==1){//偶数位出现了奇数
                while(nums[j]%2==1) j+=2;//跳过在奇数位的奇数
                //找到在奇数为的偶数，进行交换
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
            }
        }
        return nums;
    }
}
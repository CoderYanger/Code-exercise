/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-15
 * Time: 20:47
 */
class Solution {
    //905. 按奇偶排序数组
    public int[] sortArrayByParity(int[] nums) {
        //int[]不是对象，要先转化成Integer[]
        // Arrays.sort(nums,(a,b)->(b%2)-(a%2));
        int[] ret=new int[nums.length];
        int index=0;
        //先放偶数
        for(int x:nums) if(x%2==0) ret[index++]=x;
        //再放奇数
        for(int x:nums) if(x%2==1) ret[index++]=x;
        return ret;
    }

    public int[] sortArrayByParity2(int[] nums) {
        int n=nums.length;
        int left=0,right=n-1;
        int[] ret=new int[n];
        for(int x:nums){
            if(x%2==0) ret[left++]=x;
            else ret[right--]=x;
        }
        return ret;
    }

    //解法三：原地交换
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int left=0,right=n-1;
        while(left<right){
            while(left<right&&nums[left]%2==0) left++;
            while(left<right&&nums[right]%2==1) right--;
            if(left<right){
                //交换
                int tmp=nums[left];
                nums[left]=nums[right];
                nums[right]=tmp;
                left++;right--;
            }
        }
        return nums;
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-13
 * Time: 22:00
 */
class Solution {
    //2529. 正整数和负整数的最大计数
    //思路一：将二分查找的值设为定值，间接找到不确定的值
    public int maximumCount(int[] nums) {
        //利用题目的按 非递减顺序 排列的条件就可以二分处理了
        //找到负数的最右端点和正数的最左端点
        int n=nums.length;
        if(n==0) return 0;
        //利用0来决定二段性：负数 0 正数
        //先找最后一个负数(通过最左侧的0来找)
        int left=0,right=n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<0) left=mid+1;
            else right=mid;
        }
        //此时在0或者0的右侧（正数）
        int neg=0;
        //全是负数
        if(nums[left]<0) neg=n;
            //是0或者正数
        else neg=left;
        //再找第一个正数(通过最右侧的0来找)
        left=0;right=n-1;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(nums[mid]>0) right=mid-1;
            else left=mid;
        }
        //此时在0或者0的左侧
        int pos=0;
        //全是正数
        if(nums[left]>0) pos=n;
            //是0或者负数
        else pos=n-(left+1);
        return Math.max(neg,pos);
    }

    //思路二：直接将二分查找的值设为要找的不确定值
    public int maximumCount(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int left=0,right=n-1;
        //找到负数的最后一个位置
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(nums[mid]>=0) right=mid-1;
            else left=mid;
        }
        int neg=nums[left]<0?left+1:0;
        //找到正数的第一个位置
        left=0;right=n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<=0) left=mid+1;
            else right=mid;
        }
        int pos=nums[left]>0?n-left:0;
        return Math.max(neg,pos);
    }
}

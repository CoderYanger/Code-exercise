/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-09
 * Time: 21:07
 */
class Solution {
    //493. 翻转对
    /*给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
    你需要返回给定数组中的重要翻转对的数量。
    示例 1:
    输入: [1,3,2,3,1]
    输出: 2
    示例 2:
    输入: [2,4,3,5,1]
    输出: 3
    注意:
    给定数组的长度不会超过50000。
    输入数组中的所有数字都在32位整数的表示范围内。*/

    //升序版本
    int[]tmp;
    public int reversePairs(int[] nums) {
        int n=nums.length;
        tmp=new int[n];
        return mergesort(nums,0,n-1);
    }
    public int mergesort(int[]nums,int left,int right){
        if(left>=right) return 0;
        int mid=(left+right)/2,ret=0;
        ret+=mergesort(nums,left,mid);
        ret+=mergesort(nums,mid+1,right);
        int cur1=left,cur2=mid+1;
        while(cur2<=right){//先写个升序的
            while(cur1<=mid&&nums[cur2]>=nums[cur1]/2.0) cur1++;
            //当nums[cur1]>2*nums[cur2]的时候才直接统计一堆
            //因为当nums[cur1]>它的时候，因为是升序，cur1的之后比cur1更大，更能满足＞2*nums[cur2]
            //就是2倍的nums[cur2]也比不过当前数
            if(cur1>mid) break;
            ret+=mid-cur1+1;
            cur2++;
        }
        //合并
        cur1=left;cur2=mid+1;
        int i=0;
        while(cur1<=mid&&cur2<=right) tmp[i++]=nums[cur1]<=nums[cur2]?nums[cur1++]:nums[cur2++];
        while(cur1<=mid) tmp[i++]=nums[cur1++];
        while(cur2<=right) tmp[i++]=nums[cur2++];
        //还原
        for(int j=left;j<=right;j++) nums[j]=tmp[j-left];
        return ret;
    }
    //降序版本
    int[]tmp;
    public int reversePairs(int[] nums) {
        int n=nums.length;
        tmp=new int[n];
        return mergesort(nums,0,n-1);
    }
    public int mergesort(int[]nums,int left,int right){
        if(left>=right) return 0;
        int mid=(left+right)/2,ret=0;
        ret+=mergesort(nums,left,mid);
        ret+=mergesort(nums,mid+1,right);
        int cur1=left,cur2=mid+1;
        while(cur1<=mid){//再写个降序的
            while(cur2<=right&&nums[cur2]>=nums[cur1]/2.0) cur2++;
            //总结出来了，看笔记吧
            if(cur2>right) break;
            ret+=right-cur2+1;
            cur1++;
        }
        //合并
        cur1=left;cur2=mid+1;
        int i=0;
        while(cur1<=mid&&cur2<=right) tmp[i++]=nums[cur1]>nums[cur2]?nums[cur1++]:nums[cur2++];
        while(cur1<=mid) tmp[i++]=nums[cur1++];
        while(cur2<=right) tmp[i++]=nums[cur2++];
        //还原
        for(int j=left;j<=right;j++) nums[j]=tmp[j-left];
        return ret;
    }
}
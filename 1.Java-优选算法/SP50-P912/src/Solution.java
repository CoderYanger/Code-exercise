/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-07
 * Time: 16:52
 */
class Solution {
    //归并排序的解法
    //把临时数组定义为全局变量，避免多次创建，比原来快4ms
    int[]tmp;
    public int[] sortArray(int[] nums) {
        tmp=new int[nums.length];
        mergesort(nums,0,nums.length-1);
        return nums;
    }
    public void mergesort(int[]nums,int left,int right){
        if(left>=right) return;
        int mid=(left+right)/2;
        //先给左右排个序
        mergesort(nums,left,mid);
        mergesort(nums,mid+1,right);
        //合并后放在临时数组里
        // int[] tmp=new int[right-left+1];
        int cur1=left,cur2=mid+1,i=0;
        while(cur1<=mid&&cur2<=right)  tmp[i++]=nums[cur1]<=nums[cur2]?nums[cur1++]:nums[cur2++];
        //处理没有遍历完的数组
        while(cur1<=mid) tmp[i++]=nums[cur1++];
        while(cur2<=right) tmp[i++]=nums[cur2++];
        //还原：当前处理区间为[left,right]
        for(int j=left;j<=right;j++) nums[j]=tmp[j-left];//临时数组下标是从0开始的
    }
}

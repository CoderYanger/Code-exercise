import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-07
 * Time: 10:51
 */
class Solution {
    //215. 数组中的第K个最大元素
    /*给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
    示例 1:
    输入: [3,2,1,5,6,4], k = 2
    输出: 5
    示例 2:
    输入: [3,2,3,1,2,4,5,5,6], k = 4
    输出: 4
    提示：
            1 <= k <= nums.length <= 105
            -104 <= nums[i] <= 104
*/
    public int findKthLargest(int[] nums, int k) {
        return qsort(nums,0,nums.length-1,k);
    }
    public int qsort(int[]nums,int l,int r,int k){
        int key=nums[new Random().nextInt(r-l+1)+l];
        int left=l-1,right=r+1,i=l;
        while(i<right){//数组分三块
            if(nums[i]<key) swap(nums,++left,i++);
            else if(nums[i]==key) i++;
            else swap(nums,--right,i);
        }
        //此时为了定位k的位置将数组临时分为三部分，之后只递归存在k的区间，并不会完全排序
        //[l,left][left+1,right-1][right,r]
        int b=right-left-1,c=r-right+1;
        if(c>=k) return qsort(nums,right,r,k);
        else if(b+c>=k) return key;
        else return qsort(nums,l,left,k-b-c);
    }
    public void swap(int[]nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}

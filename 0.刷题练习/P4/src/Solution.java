/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-03
 * Time: 12:46
 */
class Solution {
    //4. 寻找两个正序数组的中位数
    /*给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
    算法的时间复杂度应该为 O(log (m+n)) 。
    示例 1：
    输入：nums1 = [1,3], nums2 = [2]
    输出：2.00000
    解释：合并数组 = [1,2,3] ，中位数 2
    示例 2：
    输入：nums1 = [1,2], nums2 = [3,4]
    输出：2.50000
    解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
    提示：
    nums1.length == m
    nums2.length == n
0 <= m <= 1000
            0 <= n <= 1000
            1 <= m + n <= 2000
            -106 <= nums1[i], nums2[i] <= 106*/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //确保nums1是较小的那个
        if(nums1.length>nums2.length){
            int[]temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int m=nums1.length;
        int n=nums2.length;
        //分割线左边的所有元素需要满足的个数m+(n-m+1)/2;
        int totalleft=(m+n+1)/2;
        //在nums1的区间[0,m]里查找恰当的分割线
        //使得nums1[i-1]<=nums2[j]&&nums2[j-1]<=nums1[i]
        int left=0;
        int right=m;
        //调整分割线位置
        while(left<right){//left=right时代表找到分割线了
            int i=left+(right-left+1)/2;
            int j=totalleft-i;
            if(nums1[i-1]>nums2[j]){//分割线太靠右了
                //下一轮搜索区间[left,i-1],往左找
                right=i-1;
            }else{//分割线太靠左了
                //下一轮搜索区间[i,right]，往右找
                left=i;
            }
        }
        int i=left;
        int j=totalleft-i;
        //排除极端情况，使其为不可选中状态
        int nums1LeftMax=i==0?Integer.MIN_VALUE:nums1[i-1];
        int nums1RightMin=i==m?Integer.MAX_VALUE:nums1[i];
        int nums2LeftMAX=j==0?Integer.MIN_VALUE:nums2[j-1];
        int nums2RightMin=j==n?Integer.MAX_VALUE:nums2[j];
        //奇偶性判断
        if(((m+n)%2)==1){
            return Math.max(nums1LeftMax,nums2LeftMAX);
        }else{
            return (double)((Math.max(nums1LeftMax,nums2LeftMAX)+Math.min(nums1RightMin,nums2RightMin)))/2;
        }
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-14
 * Time: 10:56
 */
class Solution {
    //88. 合并两个有序数组
    //完全自己写的
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ret=new int[m+n];
        int i=0,j=0,k=0;
        while(i<m&&j<n)
            ret[k++]=nums1[i]>nums2[j]?nums2[j++]:nums1[i++];
        //处理剩余没遍历的，两个while只会走一个
        while(i<m) ret[k++]=nums1[i++];
        while(j<n) ret[k++]=nums2[j++];
        //按照题意，转移到nums1身上
        for(int a=0;a<m+n;a++) nums1[a]=ret[a];
    }
}
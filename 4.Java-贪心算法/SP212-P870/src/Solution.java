import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-04
 * Time: 20:20
 */
class Solution {
    //870.优势洗牌(田忌赛马)
    //自己写的时候if判定的方向反着写的，导致出错，对照吴小哲的代码后把错误原因放注释上了
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n=nums1.length;
        Integer[] index=new Integer[n];
        Arrays.sort(nums1);//nums1忘记排序了
        for(int i=0;i<n;i++) index[i]=i;
        Arrays.sort(index,(a,b)->nums2[a]-nums2[b]);
        int[] ret=new int[n];
        int left=0,right=n-1;
        //总是用当前nums1元素去和最大的剩余nums2元素比较，浪费了可能赢得机会
        // for(int i=0;i<n;i++){
        //     if(nums1[i]<=nums2[index[right]]) ret[index[right--]]=nums1[i];
        //     else ret[index[left++]]=nums1[i];
        // }
        //田忌赛马策略
        for(int x:nums1){
            if(x>nums2[index[left]]) ret[index[left++]]=x;
            else ret[index[right--]]=x;
        }
        return ret;
    }
}
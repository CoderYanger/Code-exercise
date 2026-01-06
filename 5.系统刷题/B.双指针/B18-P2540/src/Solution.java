/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-18
 * Time: 17:50
 */
public class Solution {
    //2540. 最小公共值
    public int getCommon(int[] nums1, int[] nums2) {
        int index1=0,index2=0;
        int n1=nums1.length,n2=nums2.length;
        while(index1<n1&&index2<n2){
            int num1=nums1[index1],num2=nums2[index2];
            if(num1==num2) return num1;
            else if(num1<num2) index1++;
            else index2++;
        }
        return -1;
    }
}

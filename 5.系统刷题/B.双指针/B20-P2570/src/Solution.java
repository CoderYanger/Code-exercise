import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-18
 * Time: 18:10
 */
public class Solution {
    //2570. 合并两个二维数组 - 求和法
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        //利用id严格递增的性质：双指针
        int n1=nums1.length,n2=nums2.length,index=0;
        int[][] ret=new int[n1+n2][2];
        int i=0,j=0;
        while(i<n1&&j<n2){
            int id1=nums1[i][0],id2=nums2[j][0],
                    val1=nums1[i][1],val2=nums2[j][1];
            if(id1==id2){
                ret[index][0]=id1;
                ret[index][1]=val1+val2;
                i++;j++;
            }else if(id1<id2){
                ret[index][0]=id1;
                ret[index][1]=val1;
                i++;
            }else{
                ret[index][0]=id2;
                ret[index][1]=val2;
                j++;
            }
            index++;
        }
        //处理有剩余任一个没有遍历完的情况
        while(i<n1){
            ret[index][0]=nums1[i][0];
            ret[index][1]=nums1[i][1];
            index++;i++;
        }
        while(j<n2){
            ret[index][0]=nums2[j][0];
            ret[index][1]=nums2[j][1];
            index++;j++;
        }
        return Arrays.copyOfRange(ret,0,index);
    }
}

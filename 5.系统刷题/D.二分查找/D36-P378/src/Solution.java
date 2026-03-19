/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-23
 * Time: 20:27
 */
class Solution {
    //378. 有序矩阵中第 K 小的元素
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int left=matrix[0][0],right=matrix[n-1][n-1];
        while(left<right){
            int mid=left+(right-left)/2;
            if(!check(mid,matrix,k)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    //判断≤mid的数量是否≥k
    private boolean check(int mid,int[][] matrix,int k){
        int m=matrix.length,cnt=0;
        int row=0,col=matrix[0].length-1;
        while(row<m&&col>=0){
            if(matrix[row][col]<=mid){
                cnt+=(col+1);
                row++;
            }
            else col--;
        }
        return cnt>=k;
    }
}
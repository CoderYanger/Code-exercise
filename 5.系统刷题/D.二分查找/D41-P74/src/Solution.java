/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-27
 * Time: 18:55
 */
class Solution {
    //74. 搜索二维矩阵
    //解法一：双指针
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0,col=matrix[0].length-1;
        while(row<matrix.length&&col>=0){
            //找到target
            if(matrix[row][col]==target) return true;
                //这一行剩余元素全<target，排除
            else if(matrix[row][col]<target) row++;
                //这一列剩余元素全<target，排除
            else col--;
        }
        return false;
    }

    //解法二：二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int left=0,right=m*n;
        while(left<right){
            int mid=left+(right-left)/2;
            int x=matrix[mid/n][mid%n];
            if(x==target) return true;
            else if(x<target) left=mid+1;
            else right=mid;
        }
        return false;
    }
    
}
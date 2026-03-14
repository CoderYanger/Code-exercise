/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-23
 * Time: 19:51
 */
class Solution {
    //240. 搜索二维矩阵 II
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0,col=matrix[0].length-1;
        while(row<matrix.length&&col>=0){
            //找到target
            if(matrix[row][col]==target) return true;
                //这一行剩余元素全<target，排除
            else if(matrix[row][col]<target) row++;
                //这一列剩余元素全>target，排除
            else col--;
        }
        return false;
    }
}

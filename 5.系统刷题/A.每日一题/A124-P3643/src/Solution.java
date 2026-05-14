/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-21
 * Time: 13:44
 */
class Solution {
    //3643. 垂直翻转子矩阵
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int left=x,right=x+k-1;
        while(left<right){
            for(int j=y;j<y+k;j++){
                int t=grid[left][j];
                grid[left][j]=grid[right][j];
                grid[right][j]=t;
            }
            left++;
            right--;
        }
        return grid;
    }
}

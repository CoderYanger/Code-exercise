/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-22
 * Time: 16:32
 */
class Solution {
    //1886. 判断矩阵经轮转后是否一致
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int k=0;k<4;k++)
            if(check(target,rotate(mat)))
                return true;
        return false;
    }
    //直接调用48题代码
    public int[][] rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            int[] row=matrix[i];
            //转置：调整为遍历主对角线上方元素
            for(int j=i+1;j<n;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
            //行翻转
            for(int j=0;j<n/2;j++){
                int t=row[j];
                row[j]=row[n-1-j];
                row[n-1-j]=t;
            }
        }
        return matrix;
    }
    private boolean check(int[][] mat,int[][] target){
        int n=mat.length;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(mat[i][j]!=target[i][j])
                    return false;
        return true;
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-22
 * Time: 16:31
 */
class Solution {
    //48. 旋转图像
    //写法一：两个for循环
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        //转置
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
        //行翻转
        for(int[] row:matrix){
            for(int i=0;i<n/2;i++){
                int t=row[i];
                row[i]=row[n-1-i];
                row[n-1-i]=t;
            }
        }
    }

    //写法二：一个for循环
    public void rotate(int[][] matrix) {
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
    }
    
}

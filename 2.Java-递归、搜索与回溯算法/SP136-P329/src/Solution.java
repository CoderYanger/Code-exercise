/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-10
 * Time: 23:37
 */
class Solution {
    //329. 矩阵中的最长递增路径
    //吴小哲跟我写的一样
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n;
    int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        m=matrix.length;n=matrix[0].length;
        memo=new int[m][n];
        int ret=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ret=Math.max(dfs(matrix,i,j),ret);
            }
        }
        return ret;
    }
    public int dfs(int[][] matrix,int i,int j){
        if(memo[i][j]!=0) return memo[i][j];
        int ret=1;
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x<m&&y<n&&x>=0&&y>=0&&matrix[x][y]>matrix[i][j]){
                ret=Math.max(dfs(matrix,x,y)+1,ret);
            }
        }
        memo[i][j]=ret;
        return memo[i][j];
    }
}
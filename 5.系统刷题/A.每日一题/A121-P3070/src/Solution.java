/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-18
 * Time: 12:58
 */
class Solution {
    //3070. 元素和小于等于 k 的子矩阵的数目
    //解法一：二维前缀和
    public int countSubmatrices(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length,cnt=0;
        //计算前缀和pre[i][j]:[1][1]到[i][j]的前缀和，0下标映射到1
        int[][] pre=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                pre[i][j]=pre[i-1][j]+pre[i][j-1]+grid[i-1][j-1]-pre[i-1][j-1];
                if(pre[i][j]<=k) cnt++;
            }
        }
        return cnt;
    }

    //解法二：维护每列元素和
    public int countSubmatrices(int[][] grid, int k) {
        int n=grid[0].length,cnt=0;
        int[] colsum=new int[n];
        for(int[] row:grid){
            int s=0;
            for(int i=0;i<n;i++){
                colsum[i]+=row[i];
                s+=colsum[i];
                if(s<=k) cnt++;
            }
        }
        return cnt;
    }
    
}

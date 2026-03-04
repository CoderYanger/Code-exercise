/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-19
 * Time: 13:27
 */
class Solution {
    //1895. 最大的幻方
    public int largestMagicSquare(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        //初始化前缀和
        int[][] rowsum=new int[m][n+1];//→
        int[][] colsum=new int[m+1][n];//↓
        int[][] diagsum=new int[m+1][n+1];//↘
        int[][] antisum=new int[m+1][n+1];//↙
        //填充前缀和
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int x=grid[i][j];//当前元素值
                //行前缀和
                rowsum[i][j+1]=rowsum[i][j]+x;
                //列前缀和
                colsum[i+1][j]=colsum[i][j]+x;
                //主对角前缀和
                diagsum[i+1][j+1]=diagsum[i][j]+x;
                //副对角前缀和:存从最右上元素到当前元素的和
                antisum[i+1][j]=antisum[i][j+1]+x;
            }
        }
        //从最大可能的k开始检查（贪心剪枝，找到最大的即返回）
        for(int k=Math.min(m,n);k>=1;k--){
            //遍历右下角位置，对应原矩阵(i,j)位置，前缀和(i-1,j-1)位置
            for(int i=k;i<=m;i++){
                next:
                for(int j=k;j<=n;j++){
                    //先判断子矩阵的主对角前缀和是否等于副对角前缀和
                    int sum=diagsum[i][j]-diagsum[i-k][j-k];
                    if(sum!=antisum[i][j-k]-antisum[i-k][j]) continue;
                    //检查子矩阵每一行是否等于sum
                    for(int r=i-k;r<i;r++) if(rowsum[r][j]-rowsum[r][j-k]!=sum) continue next;
                    //检查子矩阵每一列是否等于sum
                    for(int c=j-k;c<j;c++) if(colsum[i][c]-colsum[i-k][c]!=sum) continue next;
                    //所有检查通过，返回
                    return k;
                }
            }
        }
        //若没有找到更大幻方，最小为1×1
        return 1;
    }
}
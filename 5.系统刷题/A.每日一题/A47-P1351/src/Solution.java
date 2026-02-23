/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-31
 * Time: 22:45
 */
class Solution {
    //1351. 统计有序矩阵中的负数
    public int countNegatives(int[][] grid) {
        //这里把m看成列数，把n看成行数
        int m=grid.length,n=grid[0].length;
        if(grid[0][0]<0) return m*n;
        int ret=0;
        int i=m-1,j=0;
        while(i>=0&&j<n){//还有剩余元素
            if(grid[i][j]<0){
                ret+=n-j;//这一列剩余元素都是负数
                i--;//取该行的前一列继续找负数
            }else j++;//该行的此列没有负数，去下一行的此列找，因为是递减，所以没必要再返回去重新找
        }
        return ret;
    }
}
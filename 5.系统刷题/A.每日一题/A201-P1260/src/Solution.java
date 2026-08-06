import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-26
 * Time: 16:40
 */
class Solution {
    //1260. 二维网格迁移
    //解法一：暴力模拟
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        k=k%(m*n);//计算净迁移次数
        int[][] t=new int[m][n];
        while(k-->0){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(j<n-1) t[i][j+1]=grid[i][j];
                    else if(i!=m-1&&j==n-1) t[i+1][0]=grid[i][j];
                    else if(i==m-1&&j==n-1) t[0][0]=grid[i][j];
                }
            }
            //更细 gird
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=t[i][j];
                }
            }
        }
        List<List<Integer>> ret=new ArrayList<>();
        for(int i=0;i<m;i++){
            List<Integer> a=new ArrayList<>();
            for(int j=0;j<n;j++){
                if(k==-1) a.add(grid[i][j]);//k为0时自减后为-1
                else a.add(t[i][j]);
            }
            ret.add(a);
        }
        return ret;
    }

    //1260. 二维网格迁移
    //解法二：化为一维
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        List<List<Integer>> ret=new ArrayList<>();
        //初始化
        for(int i=0;i<m;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<n;j++) row.add(0);
            ret.add(row);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int index=(i*n+j+k)%(m*n);
                ret.get(index/n).set(index%n,grid[i][j]);
            }
        }
        return ret;
    }
}

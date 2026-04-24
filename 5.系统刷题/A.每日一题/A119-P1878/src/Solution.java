import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-16
 * Time: 18:10
 */
class Solution {
    //1878. 矩阵中最大的三个菱形和
    //存最大、次大、第三大的菱形和
    private int x,y,z;
    public int[] getBiggestThree(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //①预处理两个方向的对角线前缀和，快速计算菱形边的和
        int[][] diagsum=new int[m][n];
        int[][] antisum=new int[m][n];
        //填充两个前缀和数组
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                diagsum[i][j]=grid[i][j];
                if(i>0&&j>0) diagsum[i][j]+=diagsum[i-1][j-1];
                antisum[i][j]=grid[i][j];
                if(i>0&&j<n-1) antisum[i][j]+=antisum[i-1][j+1];
            }
        }
        //②枚举每一个格子作为菱形正中心
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //边长为0的菱形：只有中心自己，直接更新最大值
                update(grid[i][j]);
                //③枚举菱形的半径k
                //计算最大可行k：保证菱形四个顶点都不越界
                int mx=Math.min(
                        Math.min(i,m-1-i),//上下不越界
                        Math.min(j,n-1-j)//左右不越界
                );
                //k从1开始，到最大可行mx
                for(int k=1;k<=mx;k++){
                    //用前缀和O(1)计算菱形四条边的和
                    int a=diagsum[i+k][j]-diagsum[i][j-k];
                    int b=diagsum[i][j+k]-diagsum[i-k][j];
                    int c=antisum[i+k][j]-antisum[i][j+k];
                    int d=antisum[i][j-k]-antisum[i-k][j];
                    update(a+b+c+d-grid[i+k][j]+grid[i-k][j]);
                }
            }
        }
        //处理不足三个的情况
        int[] ret=new int[]{x,y,z};
        int len=3;
        //有效数字不足3个时，去掉末尾的0
        while(ret[len-1]==0) len--;
        return Arrays.copyOf(ret,len);
    }
    //维护全局x,y,z
    private void update(int v){
        //注意x,y,z互不相同
        if(v>x){
            z=y;y=x;x=v;
        }else if(v<x&&v>y){
            z=y;y=v;
        }else if(v<y&&v>z){
            z=v;
        }
    }
}
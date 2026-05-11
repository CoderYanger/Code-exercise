/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:57
 */
import java.util.*;
public class Main {
    //合并区域
    //旋转矩阵90度
    private static int[][] rotate(int[][] grid){
        int n=grid.length;
        int[][] ret=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ret[i][j]=grid[j][n-1-i];
            }
        }
        return ret;
    }
    private static int dfs(int[][] grid,int x,int y){
        int ret=0;
        if(x>=grid.length||x<0||y>=grid.length||y<0||grid[x][y]==0) return 0;
        grid[x][y]=0;
        ret+=1;
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        for(int i=0;i<4;i++) ret+=dfs(grid,x+dx[i],y+dy[i]);
        return ret;
    }
    //清空画布
    private static void erase(int[][] map){
        for(int[] row:map) Arrays.fill(row,0);
    }
    //绘制拼接后的网格到画布map
    private static void draw(int[][] base,int[][] grid,int[][] map,int n,int k,int con){
        int x,y;//绘制起点坐标
        //左：grid在base左侧，行对齐，列偏移k
        if(con==0){x=k;y=0;}
        //上：grid在base上侧，列对齐，行偏移k
        else if(con==1){y=k;x=0;}
        //右：grid在base右侧，行对齐，列偏移k，起始列2N
        else if(con==2){x=k;y=2*n;}
        //下：grid在base下侧，列对齐，行偏移k，其实行2N
        else{y=k;x=2*n;}
        //绘制待拼接矩阵grid到map的(x,y)开始的N×N区域
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i+x][j+y]=grid[i][j];
                map[n+i][n+j]=base[i][j];
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] grid1=new int[n][n];
        int[][] grid2=new int[n][n];
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) grid1[i][j]=sc.nextInt();
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) grid2[i][j]=sc.nextInt();
        int ret=0;
        //n=1时直接判断两个格子是否连通
        if(n==1){
            if(grid1[0][0]==1){
                if(grid2[0][0]==1) ret=2;
                else ret=1;
            }
        }else{
            //生成grid2的四个旋转版本
            int[][] grid2_1=rotate(grid2);//90度旋转
            int[][] grid2_2=rotate(grid2_1);//180度旋转
            int[][] grid2_3=rotate(grid2_2);//270度旋转
            int[][][] spin={grid2,grid2_1,grid2_2,grid2_3};
            int[] contral={0,1,2,3};
            //创建3n×3n大画布
            int[][] map=new int[3*n][3*n];
            //枚举所有可能的拼接情况
            for(int dir=0;dir<4;dir++){//遍历四个拼接方向
                for(int s=0;s<4;s++){//遍历grid的四个旋转版本
                    for(int k=1;k<2*n;k++){//遍历所有偏移量
                        //绘制当前拼接情况到画布
                        draw(grid1,spin[s],map,n,k,contral[dir]);
                        //遍历画布所有格子，用DFS求当前拼接后的最大连通块
                        for(int i=0;i<3*n;i++){
                            for(int j=0;j<3*n;j++){
                                ret=Math.max(ret,dfs(map,i,j));
                            }
                        }
                        erase(map);//清空画布，准备下一次拼接
                    }
                }
            }
        }
        System.out.println(ret);
        sc.close();
    }
}

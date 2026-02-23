/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-01
 * Time: 19:29
 */
class Solution {
    //1970. 你能穿过矩阵的最后一天
    //方法一：反向dfs
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n;
    public int latestDayToCross(int _m, int _n, int[][] cells) {
        m=_m;n=_n;
        //0=水，1=已恢复但未验证连通性的陆地，2=已恢复且有连通性的陆地
        byte[][] state=new byte[m][n];
        //从最后一天开始逐步恢复陆地
        for(int day=cells.length-1;;day--){
            //获取第day天被淹没的单元格,正确映射下标
            int[] cell=cells[day];
            int r=cell[0]-1;
            int c=cell[1]-1;
            //将该单元格恢复为陆地，待验证连通性
            state[r][c]=1;
            //核心判断：新恢复的陆地能否连通第一行和最后一行
            if(dfsup(r,c,state)&&dfsdown(r,c,state)) return day;
        }
    }
    //判断能否连通第一行
    private boolean dfsup(int r,int c,byte[][] state){
        //如果当前单元格本身就在第一行，直接返回
        if(r==0) return true;
        //遍历四个方向，看能否连通上
        for(int k=0;k<4;k++){
            int x=r+dx[k],y=c+dy[k];
            //坐标合法+邻域能连通上
            if(x>=0&&x<m&&y>=0&&y<n&&state[x][y]==2) return true;
        }
        return false;
    }
    //判断能否连通最后一行
    private boolean dfsdown(int r,int c,byte[][] state){
        //本身就在最后一行，直接返回
        if(r==m-1) return true;
        //标记当前单元格为能连通的单元格
        state[r][c]=2;
        //遍历四个方向，递归检查连通性
        for(int k=0;k<4;k++){
            int x=r+dx[k],y=c+dy[k];
            //保证坐标合法+邻域是待验证的陆地
            if(x>=0&&x<m&&y>=0&&y<n&&state[x][y]==1)
                //如果邻域能连接最后一行，则当前单元格也能
                if(dfsdown(x,y,state)) return true;
        }
        return false;
    }

    //方法二：正向dfs
    int[] dx=new int[]{0,0,1,-1,1,1,-1,-1};
    int[] dy=new int[]{1,-1,0,0,1,-1,1,-1};
    int m,n;
    public int latestDayToCross(int _m, int _n, int[][] cells) {
        m=_m;n=_n;
        //0=陆地，1=未连通的水，2=已连通的水
        byte[][] state=new byte[m][n];
        //从第一天开始连通水
        for(int day=0;;day++){
            //获取第day天被淹没的单元格,正确映射下标
            int[] cell=cells[day];
            int r=cell[0]-1;
            int c=cell[1]-1;
            //将该单元格用水淹没，待验证连通性
            state[r][c]=1;
            //核心判断：新水能否连接最左列和最右列
            if(dfsleft(r,c,state)&&dfsright(r,c,state)) return day;
        }
    }
    //判断能否连通最左列
    private boolean dfsleft(int r,int c,byte[][] state){
        //如果当前单元格本身就在最左列，直接返回
        if(c==0) return true;
        //遍历八个方向，看能否连通上
        for(int k=0;k<8;k++){
            int x=r+dx[k],y=c+dy[k];
            //坐标合法+邻域能连通上
            if(x>=0&&x<m&&y>=0&&y<n&&state[x][y]==2) return true;
        }
        return false;
    }
    //判断能否连通最右列
    private boolean dfsright(int r,int c,byte[][] state){
        //本身就在最后一行，直接返回
        if(c==n-1) return true;
        //标记当前单元格为能连通的单元格
        state[r][c]=2;
        //遍历八个方向，递归检查连通性
        for(int k=0;k<8;k++){
            int x=r+dx[k],y=c+dy[k];
            //保证坐标合法+邻域是待验证的水
            if(x>=0&&x<m&&y>=0&&y<n&&state[x][y]==1)
                //如果邻域能连接最右列，则当前单元格也能
                if(dfsright(x,y,state)) return true;
        }
        return false;
    }
}

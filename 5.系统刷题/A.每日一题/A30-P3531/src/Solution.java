import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-11
 * Time: 18:01
 */
class Solution {
    //3531. 统计被覆盖的建筑
    public int countCoveredBuildings(int n, int[][] b) {
        int[] rowmax=new int[n+1];
        int[] rowmin=new int[n+1];
        int[] colmax=new int[n+1];
        int[] colmin=new int[n+1];
        //初始化最小值
        Arrays.fill(rowmin,0x3f3f3f3f);
        Arrays.fill(colmin,0x3f3f3f3f);
        //找每行每列的最大值和最小值
        for(int[] t:b){
            //x是横坐标，也是此坐标所在列，y是纵坐标，也是此坐标所在行
            int x=t[0],y=t[1];
            colmax[x]=Math.max(colmax[x],y);
            colmin[x]=Math.min(colmin[x],y);
            rowmax[y]=Math.max(rowmax[y],x);
            rowmin[y]=Math.min(rowmin[y],x);
        }
        int ret=0;
        for(int[] t:b){
            int x=t[0],y=t[1];
            if(rowmin[y]<x&&x<rowmax[y]&&colmin[x]<y&&y<colmax[x])
                ret++;
        }
        return ret;
    }
}
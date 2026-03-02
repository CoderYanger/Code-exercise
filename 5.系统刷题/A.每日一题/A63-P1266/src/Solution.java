/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-13
 * Time: 21:51
 */
class Solution {
    //1266. 访问所有点的最小时间
    public int minTimeToVisitAllPoints(int[][] points) {
        int ret=0;
        for(int i=1;i<points.length;i++){
            //获取前一个坐标(a,b)
            int a=points[i-1][0],b=points[i-1][1];
            //获取当前坐标(x,y)
            int x=points[i][0],y=points[i][1];
            ret+=Math.max(Math.abs(x-a),Math.abs(y-b));
        }
        return ret;
    }
}
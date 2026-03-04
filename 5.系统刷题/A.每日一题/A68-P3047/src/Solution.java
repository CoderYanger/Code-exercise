/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-19
 * Time: 13:25
 */
class Solution {
    //3047. 求交集区域内的最大正方形面积
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int maxside=0;
        for(int i=0;i<bottomLeft.length;i++){
            int[] b1=bottomLeft[i];
            int[] t1=topRight[i];
            for(int j=0;j<i;j++){
                int[] b2=bottomLeft[j];
                int[] t2=topRight[j];
                int width=Math.min(t1[0],t2[0])-Math.max(b1[0],b2[0]);
                int height=Math.min(t1[1],t2[1])-Math.max(b1[1],b2[1]);
                int side=Math.min(width,height);
                maxside=Math.max(maxside,side);
            }
        }
        return (long)maxside*maxside;
    }

    //优化
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int maxside=0;
        for(int i=0;i<bottomLeft.length;i++){
            int[] b1=bottomLeft[i];
            int[] t1=topRight[i];
            if(t1[0]-b1[0]<=maxside||t1[1]-b1[1]<=maxside) continue;
            for(int j=0;j<i;j++){
                int[] b2=bottomLeft[j];
                int[] t2=topRight[j];
                int width=Math.min(t1[0],t2[0])-Math.max(b1[0],b2[0]);
                int height=Math.min(t1[1],t2[1])-Math.max(b1[1],b2[1]);
                int side=Math.min(width,height);
                maxside=Math.max(maxside,side);
            }
        }
        return (long)maxside*maxside;
    }
}

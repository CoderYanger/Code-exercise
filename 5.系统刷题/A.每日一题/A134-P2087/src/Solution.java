/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 23:22
 */
class Solution {
    //2087. 网格图中机器人回家的最小代价
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int m=rowCosts.length,n=colCosts.length;
        int ret=0;
        int rmx=Math.max(startPos[0],homePos[0]),rmn=Math.min(startPos[0],homePos[0]);
        if(rmx>rmn) ret+=rowCosts[homePos[0]];
        int cmx=Math.max(startPos[1],homePos[1]),cmn=Math.min(startPos[1],homePos[1]);
        if(cmx>cmn) ret+=colCosts[homePos[1]];
        for(int i=rmn+1;i<rmx;i++) ret+=rowCosts[i];
        for(int i=cmn+1;i<cmx;i++) ret+=colCosts[i];
        return ret;
    }
}
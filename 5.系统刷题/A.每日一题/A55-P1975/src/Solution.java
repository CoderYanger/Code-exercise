/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-10
 * Time: 18:49
 */
class Solution {
    //1975. 最大方阵和
    public long maxMatrixSum(int[][] nums) {
        int count=0,m=0x3f3f3f3f;
        long ret=0;boolean mark=false;
        for(int[] t:nums){
            for(int x:t){
                ret+=Math.abs(x);
                if(x<0) count++;
                m=Math.min(m,Math.abs(x));
                if(x==0) mark=true;
            }
        }
        if(count%2==0||(count%2==0&&mark)) return ret;
        else return ret-=2*m;
    }
}
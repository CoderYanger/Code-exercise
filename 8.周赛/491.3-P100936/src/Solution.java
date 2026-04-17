/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-01
 * Time: 16:28
 */
class Solution {
    //100936. 按位或的最小值
    public int minimumOR(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        if(m==0||n==0) return 0;
        //初始化为所有数的按位或，找出最大可能值
        int ret=0;
        for(int[] row:grid)
            for(int x:row)
                ret|=x;
        //从最高位到最低位尝试移除每一位
        for(int bit=30;bit>=0;bit--){
            int can=ret&~(1<<bit);
            boolean val=true;
            //检查每一行是否存在满足条件的数
            for(int[] row:grid){
                boolean hasval=false;
                for(int x:row){
                    if((x&(~can))==0){
                        hasval=true;
                        break;
                    }
                }
                if(!hasval){
                    val=false;
                    break;
                }
            }
            if(val) ret=can;
        }
        return ret;
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-02
 * Time: 12:30
 */
class Solution {
    //1536. 排布二进制网格的最少交换次数
    public int minSwaps(int[][] grid) {
        //1.先求出方阵的边长n
        int n=grid.length;
        //2.tail[i]:第i行末尾连续0的个数
        int[] tail=new int[n];
        //遍历每一行，计算该行末尾0的个数
        for(int i=0;i<n;i++){
            //由于我们通过第一个1来计算0的个数，那要是没有1就算不了了
            //因此tail[i]初始化为n
            tail[i]=n;
            //从该行末尾开始搜索
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==1){
                    //[j+1,n-1]全是0
                    tail[i]=n-1-j;
                    break;
                }
            }
        }
        //记录最小交换次数
        int ret=0;
        //打标签，方便切换到下一行
        next:
        //最后一行不用处理
        for(int i=0;i<n-1;i++){
            int need=n-1-i;
            for(int j=i;j<n;j++){
                if(tail[j]>=need){
                    //j行换到i行需要交换j-i次
                    ret+=j-i;
                    //模拟交换，
                    System.arraycopy(tail,i,tail,i+1,j-i);
                    continue next;
                }
            }
            return -1;
        }
        return ret;
    }
}

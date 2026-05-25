import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-09
 * Time: 21:33
 */
class Solution {
    //2033. 获取单值网格的最小操作数
    public int minOperations(int[][] grid, int x) {
        int n=grid.length*grid[0].length;
        int[] a=new int[n];
        int index=0;
        int target=grid[0][0]%x;
        //判断是否无解
        for(int[] row:grid){
            for(int v:row){
                if(v%x!=target) return -1;
                a[index++]=v;
            }
        }
        //计算中位数
        Arrays.sort(a);
        int mid=a[n/2];
        //计算操作次数
        int ret=0;
        for(int v:a) ret+=Math.abs(v-mid);
        return ret/x;
    }
}

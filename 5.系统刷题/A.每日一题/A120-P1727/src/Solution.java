import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-18
 * Time: 12:56
 */
class Solution {
    //1727. 重新排列后的最大子矩阵
    public int largestSubmatrix(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int ret=0;
        int[] heights=new int[n];
        for(int[] row:matrix){
            for(int i=0;i<n;i++){
                if(row[i]==1) heights[i]++;
                else heights[i]=0;
            }
            //为保证heights能够继续正常计数，不串位，需要重新拷贝出来一个用来判断
            int[] hs=heights.clone();
            Arrays.sort(hs);
            for(int i=0;i<n;i++)
                ret=Math.max(ret,(n-i)*hs[i]);
        }
        return ret;
    }

    //优化版
    public int largestSubmatrix(int[][] matrix) {
        int n=matrix[0].length;
        int[] heights=new int[n];
        //idx数组：存储列号，后续按heights[idx[i]]升序排序，避免频繁排序
        int[] idx=new int[n];
        //初始时按0,1,……,n-1排序
        for(int i=0;i<n;i++) idx[i]=i;
        int[] nonzeros=new int[n];
        int ret=0;
        for(int[] row:matrix){
            //p:记录idx数组中高度为0的列号的存放位置，前p个位置存0高度列
            int p=0;
            //q:记录nonzeros数组中高度非0的列号的存放位置
            int q=0;
            //遍历上一轮排序后的列号
            for(int i:idx){
                if(row[i]==0){
                    //当前列i在本行是0，高度重置为0
                    heights[i]=0;
                    //0高度的列号存进前p位
                    idx[p++]=i;
                }else{
                    //当前列i在本行是1，高度累加
                    heights[i]++;
                    //非0高度的列号临时存到nonzeros数组
                    nonzeros[q++]=i;
                }
            }
            //此时idx前p位是0高度列，接下来把nonzeros的非0高度列挪到idx的[p,n-1]位
            //填充后，由于上一轮已经排好了序，本轮仅重置0高度列，因此heights[idx[i]]从idx[i]开始是升序的
            for(int i=p;i<n;i++){
                //填充
                idx[i]=nonzeros[i-p];
                //更新最大面积
                ret=Math.max(ret,(n-i)*heights[idx[i]]);
            }
        }
        return ret;
    }
}

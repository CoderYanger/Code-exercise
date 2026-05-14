import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-21
 * Time: 13:42
 */
class Solution {
    //3567. 子矩阵的最小绝对差
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        int[][] ret=new int[m-k+1][n-k+1];
        for(int i=0;i<m-k+1;i++){
            for(int j=0;j<n-k+1;j++){
                Set<Integer> hash=new HashSet<>();
                for(int a=0;a<k;a++){
                    for(int b=0;b<k;b++){
                        hash.add(grid[i+a][j+b]);
                    }
                }
                List<Integer> list=new ArrayList<>();
                for(int x:hash) list.add(x);
                Collections.sort(list);
                int mn=0x3f3f3f3f;
                for(int l=0;l<list.size()-1;l++) mn=Math.min(mn,Math.abs(list.get(l)-list.get(l+1)));
                ret[i][j]=mn==0x3f3f3f3f?0:mn;
            }
        }
        return ret;
    }

    //优化
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        int[][] ret=new int[m-k+1][n-k+1];
        int[] t=new int[k*k];
        for(int i=0;i<m-k+1;i++){
            for(int j=0;j<n-k+1;j++){
                int index=0;
                for(int a=0;a<k;a++){
                    for(int b=0;b<k;b++){
                        t[index++]=grid[i+a][j+b];
                    }
                }
                Arrays.sort(t);
                int mn=0x3f3f3f3f;
                for(int l=0;l<k*k-1;l++) if(t[l]<t[l+1]) mn=Math.min(mn,t[l+1]-t[l]);
                ret[i][j]=mn==0x3f3f3f3f?0:mn;
            }
        }
        return ret;
    }
}

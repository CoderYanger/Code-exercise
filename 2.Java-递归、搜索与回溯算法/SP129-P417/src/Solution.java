import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-09
 * Time: 22:26
 */
class Solution {
    //417. 太平洋大西洋水流问题
    //自己写的，不能用hash表的原因：有高度一样的，无法锁定坐标，其余一遍过
    //豆包帮我改出来的：要用两个boolean数组分别记录，否则第二个就记录不上了
    int m,n;
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    List<List<Integer>> ret;
    List<Integer> tmp;
    boolean[][] vis1;//统计流向太平洋的
    boolean[][] vis2;//统计流向大西洋的
    //Map<Intger,Integer> hash;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ret=new ArrayList<>();
        //hash=new HashMap<>();
        m=heights.length;n=heights[0].length;
        vis1=new boolean[m][n];
        vis2=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //统计能流向太平洋的
                if(!vis1[i][j]&&(i==0||j==0)){
                    vis1[i][j]=true;
                    //记录当前值
                    int prev=heights[i][j];
                    dfs(heights,i,j,prev,vis1);
                }
                //统计能流向大西洋的
                if(!vis2[i][j]&&(i==m-1||j==n-1)){
                    vis2[i][j]=true;
                    //记录当前值
                    int prev=heights[i][j];
                    dfs(heights,i,j,prev,vis2);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis1[i][j]&&vis2[i][j]){
                    tmp=new ArrayList<>();//每次进入都要重新统计
                    tmp.add(i);
                    tmp.add(j);
                    ret.add(tmp);
                }
            }
        }
        // for(<Map.Entry<Integer,Integer> entry:entries){
        //     if(entry.getKey()>1){
        //         tmp=new ArrayList<>();//每次进入都要重新统计
        //         tmp.add(entry.getKey());
        //         tmp.add(entry.getValue());
        //         ret.add(tmp);
        //     }
        // }
        return ret;
    }
    public void dfs(int[][] heights,int i,int j,int prev,boolean[][] vised){
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x<m&&y<n&&x>=0&&y>=0&&!vised[x][y]&&heights[x][y]>=prev){
                vised[x][y]=true;
                //hash.put(heights[x][y],hash.getOrDefalut(heights[x][y],0)+1);
                dfs(heights,x,y,heights[x][y],vised);
            }
        }
    }


    class Solution {
        //自己写的，不能用hash表的原因：有高度一样的，无法锁定坐标，其余一遍过
        //豆包帮我改出来的：要用两个boolean数组分别记录，否则第二个就记录不上了
        //吴小哲的跟我的差不多，主要不同点在标记方法上，他用n的复杂度，我用的n²的复杂度+dfs不用记录之前的数
        //直接height[x][y]跟height[i][j]比较就行
        int m,n;
        int[] dx=new int[]{0,0,1,-1};
        int[] dy=new int[]{1,-1,0,0};
        List<List<Integer>> ret;
        List<Integer> tmp;
        boolean[][] vis1;//统计流向太平洋的
        boolean[][] vis2;//统计流向大西洋的
        //Map<Intger,Integer> hash;
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            ret=new ArrayList<>();
            //hash=new HashMap<>();
            m=heights.length;n=heights[0].length;
            vis1=new boolean[m][n];
            vis2=new boolean[m][n];
            // for(int i=0;i<m;i++){
            //     for(int j=0;j<n;j++){
            //         //统计能流向太平洋的
            //         if(!vis1[i][j]&&(i==0||j==0)){
            //             vis1[i][j]=true;
            //             //记录当前值
            //             int prev=heights[i][j];
            //             dfs(heights,i,j,prev,vis1);
            //         }
            //         //统计能流向大西洋的
            //         if(!vis2[i][j]&&(i==m-1||j==n-1)){
            //             vis2[i][j]=true;
            //             //记录当前值
            //             int prev=heights[i][j];
            //             dfs(heights,i,j,prev,vis2);
            //         }
            //     }
            // }

            //吴小哲的标记方法，我感觉挺好的，直接时间复杂度n²降到n

            //流向太平洋的
            for(int i=0;i<m;i++){vis1[i][0]=true;dfs(heights,i,0,vis1);}
            for(int j=0;j<n;j++){vis1[0][j]=true;dfs(heights,0,j,vis1);}
            //流向大西洋的
            for(int i=0;i<m;i++){vis2[i][n-1]=true;dfs(heights,i,n-1,vis2);}
            for(int j=0;j<n;j++){vis2[m-1][j]=true;dfs(heights,m-1,j,vis2);}

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(vis1[i][j]&&vis2[i][j]){
                        tmp=new ArrayList<>();//每次进入都要重新统计
                        tmp.add(i);
                        tmp.add(j);
                        ret.add(tmp);
                    }
                }
            }
            // for(<Map.Entry<Integer,Integer> entry:entries){
            //     if(entry.getKey()>1){
            //         tmp=new ArrayList<>();//每次进入都要重新统计
            //         tmp.add(entry.getKey());
            //         tmp.add(entry.getValue());
            //         ret.add(tmp);
            //     }
            // }
            return ret;
        }
        public void dfs(int[][] heights,int i,int j,boolean[][] vised){
            for(int k=0;k<4;k++){
                int x=i+dx[k],y=j+dy[k];
                if(x<m&&y<n&&x>=0&&y>=0&&!vised[x][y]&&heights[x][y]>=heights[i][j]){
                    vised[x][y]=true;
                    //hash.put(heights[x][y],hash.getOrDefalut(heights[x][y],0)+1);
                    dfs(heights,x,y,vised);
                }
            }
        }
    }
}

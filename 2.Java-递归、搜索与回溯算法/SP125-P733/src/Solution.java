/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-09
 * Time: 17:50
 */
class Solution {
    //吴小哲的深度优先遍历解法，看完一遍之后自己写出来的，就是死循环的地方落下了
    int prev;
    int m,n;
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //当要改的颜色和现在相同时，直接返回，避免死循环
        if(image[sr][sc]==color) return image;
        m=image.length;n=image[0].length;
        prev=image[sr][sc];
        dfs(image,sr,sc,color);
        return image;
    }
    public void dfs(int[][] image,int i,int j,int color){
        image[i][j]=color;
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x<m&&y<n&&x>=0&&y>=0&&image[x][y]==prev) dfs(image,x,y,color);
        }
    }
    
}
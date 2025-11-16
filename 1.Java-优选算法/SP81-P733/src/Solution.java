import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-18
 * Time: 22:38
 */

class Solution {
    //733. 图像渲染
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prev=image[sr][sc];//记录一下当前颜色
        if(prev==color) return image;
        Queue<int[]> q=new LinkedList<>();//用数组模拟横向（0）、纵向（1）
        q.add(new int[]{sr,sc});
        int m=image.length,n=image[0].length;
        while(!q.isEmpty()){
            int[] t=q.poll();//注意是int[]而不是int
            int a=t[0],b=t[1];
            image[a][b]=color;
            for(int i=0;i<4;i++){//上下左右四个方向
                int x=a+dx[i],y=b+dy[i];
                if(x>=0&&x<m&&y>=0&&y<n&&image[x][y]==prev)
                    //q.offer(image[x][y]);//错误写法
                    q.offer(new int[]{x,y});
            }
        }
        return image;
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-10
 * Time: 18:06
 */
class Solution {
    //LCR130.衣橱整理
    //自己写的，基本一遍过，第一次写的时候忽略了变量名冲突的问题，后来把k改为key了
    //吴小哲跟我写的一样，他就是check方法的返回值用的boolean，直接在里面判断了，避免了变量名冲突的问题
    int[] dx=new int[]{0,0,-1,1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n,key;
    boolean[][] vis;
    public int wardrobeFinishing(int _m, int _n, int cnt) {
        m=_m;n=_n;key=cnt;
        vis=new boolean[m][n];
        return dfs(0,0);
    }
    public int dfs(int i,int j){
        vis[i][j]=true;//证明来过了
        int count=1;
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if(x<m&&y<n&&x>=0&&y>=0&&!vis[x][y]&&check(x,y)<=key) count+=dfs(x,y);
        }
        return count;
    }
    public int check(int a,int b){
        int sum=0;
        while(a!=0){
            sum+=a%10;
            a/=10;
        }
        while(b!=0){
            sum+=b%10;
            b/=10;
        }
        return sum;
    }
}
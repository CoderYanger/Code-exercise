import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-20
 * Time: 16:29
 */
class Solution {
    //自己的思路，在主方法上错误较大（注释处），照着AI和吴小哲搞的，bfs过程中忘加vis导致超时，AI都看不出来
    //后来因为忘加{}导致数组索引越界，因为这俩错误老子改了整整半天的时间，老子真是无语
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    int m,n;
    boolean[][] vis;
    public int cutOffTree(List<List<Integer>> forest) {
        m=forest.size();n=forest.get(0).size();
        // int[] tree=new int[m*n];int k=0;
        // //取出森林中的每棵树，找到砍树顺序
        // for(List<Integer> tmp:forest){
        //     for(Integer x:tmp){
        //         tree[k]=x;
        //     }
        // }
        // Arrays.sort(tree);
        // //按顺序砍树，若干个迷宫问题
        // int i=0,ret=0;
        // while(tree[i]>1){
        //     int[] tmp=bfs(forest,0,0,tree[i]);
        //     if(tmp[0]==-1) return -1;
        //     else {
        //         ret+=tmp[0];
        //         bfs(forest,tmp[1],tmp[2],tree[i]);
        //     }
        //     i++;
        // }
        // return ret;
        List<int[]> tree=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(forest.get(i).get(j)>1)
                    tree.add(new int[]{i,j});
            }
        }
        //排序
        Collections.sort(tree,(a,b)->{
            return forest.get(a[0]).get(a[1])-forest.get(b[0]).get(b[1]);
        });//由小到大排序
        int x=0,y=0,ret=0;
        for(int[] t:tree){
            int ex=t[0],ey=t[1];
            int[] d=bfs(forest,x,y,ex,ey);
            if(d[0]==-1) return -1;
            ret+=d[0];
            x=ex;y=ey;
            forest.get(x).set(y,1);
        }
        return ret;
    }
    public int[] bfs(List<List<Integer>> forest,int bx,int by,int ex,int ey){
        //每次都重新初始化vis
        if(bx==ex&&by==ey) return new int[]{0,bx,by};
        vis=new boolean[m][n];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{bx,by});
        vis[bx][by]=true;
        int step=0;
        while(!q.isEmpty()){
            int sz=q.size();
            step++;
            for(int c=0;c<sz;c++){
                int[] t=q.poll();
                int a=t[0],b=t[1];
                for(int k=0;k<4;k++){
                    int x=a+dx[k],y=b+dy[k];
                    if(x==ex&&y==ey){
                        int[] tmp=new int[]{step,x,y};
                        return tmp;
                    }
                    if(x>=0&&y>=0&&x<m&&y<n&&!vis[x][y]&&forest.get(x).get(y)!=0){
                        q.add(new int[]{x,y});
                        vis[x][y]=true;
                    }
                }
            }
        }
        return new int[]{-1,0,0};
    }
    //测试
    public static void main(String[] args) {
        List<List<Integer>> forest=new ArrayList<>();
        forest.add(new ArrayList<>(Arrays.asList(1,2,3)));
        forest.add(new ArrayList<>(Arrays.asList(0,0,4)));
        forest.add(new ArrayList<>(Arrays.asList(7,6,5)));
        System.out.println(new Solution().cutOffTree(forest));
    }
    class Solution {
        //自己写了一遍，除了注释处，其余都对了
        int[] dx=new int[]{0,0,1,-1};
        int[] dy=new int[]{1,-1,0,0};
        int m,n;
        boolean[][] vis;
        public int cutOffTree(List<List<Integer>> forest) {
            m=forest.size();n=forest.get(0).size();//这里用size而不是length
            List<int[]> trees=new ArrayList<>();
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(forest.get(i).get(j)>1)
                        trees.add(new int[]{i,j});
                }
            }
            Collections.sort(trees,(a,b)->{
                return forest.get(a[0]).get(a[1])-forest.get(b[0]).get(b[1]);
            });
            int bx=0,by=0,ret=0;
            for(int[] t:trees){
                int ex=t[0],ey=t[1];
                if(bfs(forest,bx,by,ex,ey)==-1) return -1;
                ret+=bfs(forest,bx,by,ex,ey);
                bx=ex;by=ey;
            }
            return ret;
        }
        public int bfs(List<List<Integer>> forest,int bx,int by,int ex,int ey){
            if(bx==ex&&by==ey) return 0;
            vis=new boolean[m][n];
            Queue<int[]> q=new LinkedList<>();
            q.add(new int[]{bx,by});
            vis[bx][by]=true;
            int step=0;
            while(!q.isEmpty()){
                int sz=q.size();
                step++;
                while(sz-->0){
                    int[] t=q.poll();
                    int a=t[0],b=t[1];
                    for(int k=0;k<4;k++){
                        int x=a+dx[k],y=b+dy[k];
                        if(x>=0&&y>=0&&x<m&&y<n&&!vis[x][y]&&forest.get(x).get(y)!=0){
                            if(forest.get(x).get(y)==forest.get(ex).get(ey)) return step;
                            q.add(new int[]{x,y});
                            vis[x][y]=true;
                        }
                    }
                }
            }
            return -1;
        }
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-18
 * Time: 20:26
 */
class Robot {
    //2069. 模拟行走机器人 II
    //解法一：模拟
    //→↓←↑
    private final int[][] d={{1,0},{0,-1},{-1,0},{0,1}};
    private int k=0;//记录朝向
    private int x,y;
    private int[][] mat;
    public Robot(int width, int height) {
        mat=new int[width][height];
        x=0;y=0;
    }

    public void step(int num) {
        while(num-->0){
            int nx=x+d[k][0];
            int ny=y+d[k][1];
            if(nx>=mat.length||nx<0||ny>=mat[0].length||ny<0){
                k=(k+3)%4;//修正方向
                num++;//将修正缺的加回来
                continue;
            }
            x=nx;y=ny;
        }
    }

    public int[] getPos() {
        return new int[]{x,y};
    }

    public String getDir() {
        if(k==0) return "East";
        else if(k==1) return "South";
        else if(k==2) return "West";
        else return "North";
    }

    //解法二：分类讨论
    private int w,h,s;
    public Robot(int width, int height) {
        w=width;h=height;s=0;
    }
    public void step(int num) {
        s=(s+num-1)%(2*(w+h)-4)+1;
    }
    public int[] getPos() {
        Object[] t=getState();
        return new int[]{(int)t[0],(int)t[1]};
    }
    public String getDir() {
        Object[] t=getState();
        return (String)t[2];
    }
    private Object[] getState(){
        if(s<w) return new Object[]{s,0,"East"};
        else if(s<w+h-1) return new Object[]{w-1,s-w+1,"North"};
        else if(s<2*w+h-2) return new Object[]{2*w+h-s-3,h-1,"West"};
        else return new Object[]{0,2*(w+h)-s-4,"South"};
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-18
 * Time: 17:05
 */
class Solution {
    //874. 模拟行走机器人
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> hash=new HashSet<>();
        for(int i=0;i<obstacles.length;i++)
            hash.add(String.valueOf(obstacles[i][0])+"+"+String.valueOf(obstacles[i][1]));
        int x=0,y=0;
        char t='U';//记录当前方向
        int ret=0;//记录最大距离的平方
        for(int i=0;i<commands.length;i++){
            if(commands[i]>=1&&commands[i]<=9){
                for(int step=0;step<commands[i];step++){
                    //计算下一个位置的坐标
                    if(t=='U'){
                        if(!hash.contains(String.valueOf(x)+"+"+String.valueOf(y+1))) y++;
                        else break;
                    }else if(t=='D'){
                        if(!hash.contains(String.valueOf(x)+"+"+String.valueOf(y-1))) y--;
                        else break;
                    }else if(t=='R'){
                        if(!hash.contains(String.valueOf(x+1)+"+"+String.valueOf(y))) x++;
                        else break;
                    }
                    else if(t=='L'){
                        if(!hash.contains(String.valueOf(x-1)+"+"+String.valueOf(y))) x--;
                        else break;
                    }
                    ret=Math.max(ret,(int)(Math.pow(x,2)+Math.pow(y,2)));
                }
            }else t=turn(t,commands[i]);
        }
        //计算返回值
        return ret;
    }
    private char turn(char pre,int x){
        if(pre=='U'&&x==-1) return 'R';
        else if(pre=='U'&&x==-2) return 'L';
        else if(pre=='D'&&x==-1) return 'L';
        else if(pre=='D'&&x==-2) return 'R';
        else if(pre=='R'&&x==-1) return 'D';
        else if(pre=='R'&&x==-2) return 'U';
        else if(pre=='L'&&x==-1) return 'U';
        else if(pre=='L'&&x==-2) return 'D';
        //照顾编译器
        return '0';
    }

    //优化
    //定义↑→↓←，正好对应旋转
    private final int[][] d={{0,1},{1,0},{0,-1},{-1,0}};
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> hash=new HashSet<>();
        //坐标偏移量
        final int OFFSET=3_0000;
        //将每个障碍坐标压缩进int
        for(int[] p:obstacles){
            int x=p[0]+OFFSET;
            int y=p[1]+OFFSET;
            hash.add((x<<16)|y);
        }
        //初始化机器人状态
        int x=0,y=0,k=0,ret=0;
        for(int c:commands){
            if(c==-1) k=(k+1)%4;//右转90度
            else if(c==-2) k=(k+3)%4;//左转90度:k=(k-1+4)%4
            else{
                while(c-->0){
                    int nx=x+d[k][0];
                    int ny=y+d[k][1];
                    int next=((nx+OFFSET)<<16)|(ny+OFFSET);
                    if(hash.contains(next)) break;
                    x=nx;y=ny;
                    ret=Math.max(ret,x*x+y*y);
                }
            }
        }
        return ret;
    }
    
}

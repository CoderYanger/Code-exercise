/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:59
 */
import java.util.*;
public class Main{
    //与或异或
    private static int cnt=0;
    public static void main(String[] args){
        int[][] ret=new int[5][5];
        ret[0][0]=1;
        ret[0][1]=0;
        ret[0][2]=1;
        ret[0][3]=0;
        ret[0][4]=1;
        //从第1行第0个数开始计算
        dfs(ret,1,0);
        System.out.println(cnt);
    }
    private static void dfs(int[][] ret,int i,int j){
        if(i==5){
            cnt+=ret[4][0]==1?1:0;
            return;
        }
        //k=0:&  k=1:|  k=2:^
        for(int k=0;k<3;k++){
            if(k==0) ret[i][j]=ret[i-1][j]&ret[i-1][j+1];
            else if(k==1) ret[i][j]=ret[i-1][j]|ret[i-1][j+1];
            else ret[i][j]=ret[i-1][j]^ret[i-1][j+1];
            //判断j是不是当前行最后一个节点
            if(j==4-i) dfs(ret,i+1,0);
            else dfs(ret,i,j+1);
        }
    }
}
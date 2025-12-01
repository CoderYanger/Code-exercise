import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-07
 * Time: 20:10
 */
class Solution {
    //51.N皇后
    //自己写了一遍，改错的时候被AI踢皮球了差不多俩小时，放弃了
    boolean[] checkcol,checkDig1,checkDig2;
    List<List<String>> ret;
    int n;
    char[][] path;
    public List<List<String>> solveNQueens(int _n) {
        n=_n;
        checkcol=new boolean[n];
        checkDig1=new boolean[2*n];
        checkDig2=new boolean[2*n];
        ret=new ArrayList<>();
        path=new char[n][n];
        for(int i=0;i<n;i++) Arrays.fill(path[i],'.');
        dfs(0);
        return ret;
    }
    public void dfs(int row){
        if(row==n){
            List<String> tmp=new ArrayList<>();
            for(int i=0;i<n;i++) tmp.add(new String(path[i]));
            ret.add(new ArrayList<>(tmp));
            return;
        }
        for(int col=0;col<n;col++){
            if(!checkcol[col]&&!checkDig1[row-col+n]&&!checkDig2[row+col]){
                path[row][col]='Q';
                checkcol[col]=checkDig1[row-col+n]=checkDig2[row+col]=true;
                dfs(row+1);
                //恢复现场
                path[row][col]='.';
                checkcol[col]=checkDig1[row-col+n]=checkDig2[row+col]=false;
            }
        }
    }
}

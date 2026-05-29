import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-11
 * Time: 12:29
 */
class Solution {
    //1914. 循环轮转矩阵
    public int[][] rotateGrid(int[][] grid, int kk) {
        int m=grid.length,n=grid[0].length;
        int[][] ret=new int[m][n];
        int min=Math.min(m,n);
        //创建一个数组来存储每层的值
        List<Integer>[] c=new ArrayList[min/2];
        for(int i=0;i<min/2;i++) c[i]=new ArrayList<>();
        //将原矩阵每一层存进每层的顺序表
        for(int k=0;k<min/2;k++){
            //最上方的行
            for(int j=k;j<n-k;j++) c[k].add(grid[k][j]);
            //最右方的列
            for(int i=k+1;i<m-k;i++) c[k].add(grid[i][n-1-k]);
            //最下方的行
            for(int j=n-k-2;j>=k;j--) c[k].add(grid[m-1-k][j]);
            //最左方的列
            for(int i=m-k-2;i>k;i--) c[k].add(grid[i][k]);
            int capacity=c[k].size();
            //设置局部变量kkk，避免修改全局变量kk
            int kkk=kk%capacity;//长度取模，避免多余旋转
            //找到左上角的元素往结果矩阵填
            for(int i=0;i<kkk;i++) c[k].add(c[k].get(i));//把前面的元素补到后面
            for(int cnt=kkk;cnt<capacity;){
                //最上方的行
                for(int j=k;j<n-k;j++) ret[k][j]=c[k].get(cnt++);
                //最右方的列
                for(int i=k+1;i<m-k;i++) ret[i][n-1-k]=c[k].get(cnt++);
                //最下方的行
                for(int j=n-k-2;j>=k;j--) ret[m-1-k][j]=c[k].get(cnt++);
                //最左方的列
                for(int i=m-k-2;i>k;i--) ret[i][k]=c[k].get(cnt++);
            }
        }
        return ret;
    }
}

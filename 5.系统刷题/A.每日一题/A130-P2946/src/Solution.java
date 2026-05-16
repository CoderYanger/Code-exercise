/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:46
 */
class Solution {
    //2946. 循环移位后的矩阵相似检查
    public boolean areSimilar(int[][] mat, int k) {
        int m=mat.length;
        for(int  i=0;i<m;i++) if(!turn(mat[i],k,i%2==1)) return false;
        return true;
    }
    private boolean turn(int[] a,int k,boolean odd){
        int n=a.length;
        k%=n;
        int[] ret=new int[n];
        if(odd) for(int i=0;i<n;i++) ret[(i+k)%n]=a[i];
        else for(int i=0;i<n;i++) ret[(i-k+n)%n]=a[i];
        for(int i=0;i<n;i++) if(ret[i]!=a[i]) return false;
        return true;
    }

    //优化
    public boolean areSimilar(int[][] mat, int k) {
        int m=mat.length;
        for(int  i=0;i<m;i++) if(!turn(mat[i],k)) return false;
        return true;
    }
    private boolean turn(int[] a,int k){
        int n=a.length;
        int[] ret=new int[n];
        for(int i=0;i<n;i++) ret[(i+k)%n]=a[i];
        for(int i=0;i<n;i++) if(ret[i]!=a[i]) return false;
        return true;
    }

}

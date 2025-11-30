import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-01
 * Time: 22:36
 */
class Solution {
    //77. 组合
    //自己写的，注释处是豆包帮忙找的错误，发现都是忘记这个条件
    List<Integer> path;
    List<List<Integer>> ret;
    int pos;
    public List<List<Integer>> combine(int n, int k) {
        path=new ArrayList<>();
        ret=new ArrayList<>();
        pos=0;
        dfs(1,n,k);
        return ret;
    }
    public void dfs(int pos,int n,int k){
        if(path.size()==k){//不能用pos-1来判断
            ret.add(new ArrayList<>(path));
            return ;
        }
        for(int i=pos;i<=n;i++){//当时用的是if，没有遍历到所有应该选的元素
            path.add(i);
            dfs(i+1,n,k);
            path.remove(path.size()-1);//要传入参数
        }
    }
}
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-01
 * Time: 21:10
 */
class Solution {
    //22. 括号生成
    //自己先敲了一遍，注释处是豆包帮忙找的错误
    StringBuffer path;
    int left,right;
    List<String> ret;
    public List<String> generateParenthesis(int n) {
        ret=new ArrayList<>();
        path=new StringBuffer("(");
        left=1;right=0;
        dfs(n);
        //path.append(")");
        return ret;
    }
    public void dfs(int n){
        if(right==n&&left==n){//修复条件：&&left==n
            // ret.add(new ArrayList<>(path.toString()));
            ret.add(path.toString());
            return;
        }
        //剪枝
        if(left<n){
            path.append("(");
            left++;
            dfs(n);
            left--;
            path.deleteCharAt(path.length()-1);
        }
        if(right<left){
            path.append(")");
            right++;
            dfs(n);
            right--;
            path.deleteCharAt(path.length()-1);
        }
    }
    //吴小哲的思路，我看完一遍敲下来了
    StringBuffer path;
    int left,right;
    List<String> ret;
    public List<String> generateParenthesis(int n) {
        ret=new ArrayList<>();
        left=0;right=0;
        path=new StringBuffer();
        dfs(n);
        return ret;
    }
    public void dfs(int n){
        if(right==n){
            ret.add(path.toString());
            return ;
        }
        if(left<n){
            //添加左括号
            path.append("(");left++;
            dfs(n);
            path.deleteCharAt(path.length()-1);left--;
        }
        if(right<left){
            //添加右括号
            path.append(")");right++;
            dfs(n);
            path.deleteCharAt(path.length()-1);right--;
        }
    }
}

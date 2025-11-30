import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-04
 * Time: 22:00
 */
class Solution {
    //784. 字母大小写全排列
    //自己写的代码，注释处是找豆包改的
    StringBuffer path;
    List<String> ret;
    public List<String> letterCasePermutation(String s) {
        path=new StringBuffer();
        ret=new ArrayList<>();
        dfs(s,0);
        return ret;
    }
    public void dfs(String s,int pos){
        if(pos==s.length()){
            ret.add(path.toString());
            return;
        }
        if(!isLetter(s.charAt(pos))){
            path.append(s.charAt(pos));
            dfs(s,pos+1);//直接递归下一个，我落下了
            path.deleteCharAt(path.length()-1);
            //数字也要回溯，因为如果不回溯，就会在a1这步固定住了1，从而影响到A1这部分的分支
        }
        else{
            //变
            if(s.charAt(pos)>='a'&&s.charAt(pos)<='z')
                path.append(Character.toUpperCase(s.charAt(pos)));
            else path.append(Character.toLowerCase(s.charAt(pos)));
            dfs(s,pos+1);
            path.deleteCharAt(path.length()-1);//恢复现场
            //不变
            path.append(s.charAt(pos));
            dfs(s,pos+1);
            path.deleteCharAt(path.length()-1);//恢复现场
        }
    }
    public boolean isLetter(char ch){
        return (ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z');
    }

    //吴小哲的解法，感觉简洁点，但是没有突出我对数字也要回溯的思考
    StringBuffer path;
    List<String> ret;
    public List<String> letterCasePermutation(String s) {
        path=new StringBuffer();
        ret=new ArrayList<>();
        dfs(s,0);
        return ret;
    }
    public void dfs(String s,int pos){
        if(pos==s.length()){
            ret.add(path.toString());
            return;
        }
        char ch=s.charAt(pos);
        //不改变
        path.append(ch);
        dfs(s,pos+1);
        path.deleteCharAt(path.length()-1);//恢复现场
        //改变
        if(ch<'0'||ch>'9'){
            char tmp=change(ch);
            path.append(tmp);
            dfs(s,pos+1);
            path.deleteCharAt(path.length()-1);//恢复现场
        }
    }
    public Character change(char ch){
        if(ch>='a'&&ch<='z') return ch-=32;//注意小写的ASCII值要大97，大写65
        else return ch+=32;
    }
}
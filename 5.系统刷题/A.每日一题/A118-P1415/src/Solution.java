import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-14
 * Time: 15:18
 */
class Solution {
    //1415. 长度为 n 的开心字符串中字典序第 k 小的字符串
    //解法一：暴力递归-写法一：StringBuffer→显式回溯
    List<String> list=new ArrayList<>();
    StringBuffer cur=new StringBuffer();
    public String getHappyString(int n, int k) {
        dfs(cur,n);
        if(k>list.size()) return "";
        Collections.sort(list);
        return list.get(k-1);
    }
    private void dfs(StringBuffer cur,int n){
        int len=cur.length();
        if(len>=2&&cur.charAt(len-1)==cur.charAt(len-2)) return ;
        if(len==n){
            list.add(cur.toString());
            return ;
        }
        //添加a
        cur.append("a");
        dfs(cur,n);
        cur.deleteCharAt(cur.length()-1);//回溯
        //添加b
        cur.append("b");
        dfs(cur,n);
        cur.deleteCharAt(cur.length()-1);//回溯
        //添加c
        cur.append("c");
        dfs(cur,n);
        cur.deleteCharAt(cur.length()-1);//回溯
    }

    //解法一：暴力递归-写法二：数组直接覆盖→隐式回溯
    List<String> list=new ArrayList<>();
    char[] cur;
    public String getHappyString(int n, int k) {
        cur=new char[n];
        dfs(0,cur,n);
        if(k>list.size()) return "";
        Collections.sort(list);
        return list.get(k-1);
    }
    private void dfs(int i,char[] cur,int n){
        if(i>=2&&cur[i-1]==cur[i-2]) return ;
        if(i==n){
            list.add(new String(cur));
            return ;
        }
        //添加a
        cur[i]='a';
        dfs(i+1,cur,n);
        //添加b
        cur[i]='b';
        dfs(i+1,cur,n);
        //添加c
        cur[i]='c';
        dfs(i+1,cur,n);
    }

    //解法三：位运算
    public String getHappyString(int n, int k) {
        if(k>3<<(n-1)) return "";
        k--;
        char[] ret=new char[n];
        ret[0]=(char)('a'+(k>>(n-1)));
        for(int i=1;i<n;i++){
            ret[i]=(char)('a'+(k>>(n-1-i)&1));
            if(ret[i]>=ret[i-1]) ret[i]++;
        }
        return new String(ret);
    }
}

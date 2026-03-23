import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-05
 * Time: 18:02
 */
class Solution {
    //3211. 生成不含相邻零的二进制字符串
    //解法一：递归、搜索与回溯，写法一：StringBuffer→显式回溯
    private List<String> ret;
    private StringBuffer cur;
    public List<String> validStrings(int n) {
        ret=new ArrayList<>();
        cur=new StringBuffer();
        dfs(n,cur.append("1"));
        cur.deleteCharAt(cur.length()-1);
        dfs(n,cur.append("0"));
        return ret;
    }
    private void dfs(int n,StringBuffer cur){
        if(cur.length()==n){
            ret.add(cur.toString());
            return ;
        }
        //获取cur前一个字符
        char prev=cur.charAt(cur.length()-1);
        if(prev=='1'){
            dfs(n,cur.append("1"));
            //回溯
            cur.deleteCharAt(cur.length()-1);
            dfs(n,cur.append("0"));
            //回溯
            cur.deleteCharAt(cur.length()-1);
        }else{
            dfs(n,cur.append("1"));
            //回溯
            cur.deleteCharAt(cur.length()-1);
        }
    }

    //解法一：递归、搜索与回溯，写法二：数组直接覆盖→隐式回溯
    public List<String> validStrings(int n) {
        List<String> ret=new ArrayList<>();
        char[] path=new char[n];
        dfs(0,n,path,ret);
        return ret;
    }
    private void dfs(int i,int n,char[] path,List<String> ret){
        if(i==n){
            ret.add(new String(path));
            return;
        }
        //填'1'
        path[i]='1';
        dfs(i+1,n,path,ret);
        //填'0'
        if(i==0||path[i-1]=='1'){
            path[i]='0';//直接覆盖
            dfs(i+1,n,path,ret);
        }
    }

    //解法二：位运算
    public List<String> validStrings(int n) {
        List<String> ret=new ArrayList<>();
        //1.生成一个n位全1的掩码：比如n=3(011),mask=0b111=7
        int mask=(1<<n)-1;
        //2.枚举从0~2ⁿ-1所有整数，共2ⁿ个数
        for(int x=0;x<(1<<n);x++){
            //3.核心原理：先判断x二进制里有没有两个连续的1
            //(x>>1)&x,结果为0,说明没有相邻1
            if(((x>>1)&x)==0){
                //4.将x的低n位按位取反
                //无连续1→取反后：无连续0
                int i=x^mask;
                //5.保证输出n位且带前导0的二进制字符串
                //(1<<n)|i:在前面补个1，用于保留前导零
                ret.add(Integer.toBinaryString((1<<n)|i).substring(1));
            }
        }
        return ret;
    }
    
}

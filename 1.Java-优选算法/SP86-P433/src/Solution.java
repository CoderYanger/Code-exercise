import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-19
 * Time: 20:38
 */
class Solution {
    //自己写的，注释处是找AI找的错误
    //回头一看吴小哲跟我写的一样
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(bank.length==0) return -1;//编译错误时发现的
        //先把bank扔进哈希表
        Set<String> hash=new HashSet<>();
        for(String s:bank) hash.add(s);
        if(!hash.contains(endGene)) return -1;//编译错误时发现的
        Set<String> vis=new HashSet<>();//标记是否搜索过
        //替换数组
        char[] rep=new char[]{'A','C','G','T'};
        int path=0;
        Queue<String> q=new LinkedList<>();
        q.add(startGene);
        vis.add(startGene);
        while(!q.isEmpty()){
            int sz=q.size();//这一步老忘
            path++;//每层扩展才路径+1
            for(int k=0;k<sz;k++){
                String tmp=q.poll();
                for(int i=0;i<tmp.length();i++){
                    char[] arr=tmp.toCharArray();
                    for(int j=0;j<4;j++){
                        //原来的tmp.replace(ch,ret[j])会替换整个字符串，而不是对应字符
                        arr[i]=rep[j];
                        String newstr=new String(arr);
                        if(newstr.equals(endGene)) return path;
                        if(hash.contains(newstr)&&!vis.contains(newstr)){
                            q.add(newstr);
                            vis.add(newstr);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
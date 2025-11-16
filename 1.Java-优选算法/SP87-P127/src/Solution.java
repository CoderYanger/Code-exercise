import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-19
 * Time: 21:29
 */
class Solution {
    //完全是靠自己写的，然后自己调试出的错误（注释处）第100题！！！
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size()==0) return 0;

        Set<String> hash=new HashSet<>();
        for(String s:wordList) hash.add(s);
        Set<String> vis=new HashSet<>();

        if(!hash.contains(endWord)) return 0;
        char[] rep=new char[26];int r=0;
        for(char i='a';i<='z';i++) rep[r++]=i;

        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        vis.add(beginWord);
        int step=1;
        while(!q.isEmpty()){
            int sz=q.size();
            step++;
            for(int k=0;k<sz;k++){
                String tmp=q.poll();
                // char[] chartmp=tmp.toCharArray();
                //放在这里不合适，应该放下面保证每次遍历的时候都在原字符串上只改动一个字符
                for(int i=0;i<tmp.length();i++){
                    char[] chartmp=tmp.toCharArray();
                    //这一句要放在这里来恢复原本的tmp，否则下面遍历改成z后就回不去了
                    for(int j=0;j<26;j++){
                        chartmp[i]=rep[j];
                        String newstr=new String(chartmp);
                        if(newstr.equals(endWord)) return step;
                        if(hash.contains(newstr)&&!vis.contains(newstr)){
                            vis.add(newstr);
                            q.add(newstr);
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        List<String> list=new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(s.ladderLength("hit", "cog", list));
    }
}
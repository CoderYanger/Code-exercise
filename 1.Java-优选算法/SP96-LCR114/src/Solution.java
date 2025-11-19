import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-22
 * Time: 19:29
 */
class Solution {
    //LCR114.火星词典
    public String alienOrder(String[] words) {
        //自己花费两个半小时的成果：自己写出来之后，注释处是找AI改的错误
        //建立邻接表
        Map<Character, ArrayList<Character>> edges=new HashMap<>();//泛型中不是创建对象，无（）
        //统计入度信息,先初始化为0
        Map<Character,Integer> in =new HashMap<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                char ch=words[i].charAt(j);
                if(!in.containsKey(ch)){
                    in.put(ch,0);
                    edges.put(ch,new ArrayList<>());
                }
            }
        }
        //建图
        for(int i=0;i<words.length;i++){
            String s1=words[i];
            for(int j=i+1;j<words.length;j++){
                String s2=words[j];
                int cur=0;
                while(cur<s1.length()&&cur<s2.length()){
                    char ch1=s1.charAt(cur);
                    char ch2=s2.charAt(cur);
                    if(ch1==ch2) cur++;
                        //跟ASCII值无关，比得是出现的前后顺序
                    /*else if(ch1<ch2){
                        edges.get(ch1).add(ch2);//把ch1->ch2这条边放进邻接表
                        in.get(ch2)++;//ch2入度+1
                    }else {
                        edges.get(ch2).add(ch1);
                        in.get(ch1)++;
                    }*/
                    else {
                        edges.get(ch1).add(ch2);//把ch1->ch2这条边放进邻接表
                        //in.get(ch2)++;//ch2入度+1 错误原因：未写进去
                        int degree=in.get(ch2);//绕过 Java 对包装类自增/自减的语法限制
                        in.put(ch2,++degree);
                        //找到后立马出去，避免重复加边
                        break;
                    }
                }
                //处理abc ab的情况
                if(cur==s2.length()&&cur<s1.length()) return "";
            }
        }
        //拓扑排序
        Queue<Character> q=new LinkedList<>();
        char[] ret=new char[in.size()];int index=0;
        //先把入度为0的扔队列里
        for(Map.Entry<Character,Integer> entry:in.entrySet())
            if(entry.getValue()==0) q.add(entry.getKey());
        while(!q.isEmpty()){
            char t=q.poll();
            ret[index++]=t;
            for(char ch:edges.get(t)){//getKey是Map.Entry的方法
                //切断边
                //in.getKey(ch).getValue()--;getKey和getValue是Map.Entry的方法
                //in.get(ch)--;未写进去
                int degree=in.get(ch);//绕过 Java 对包装类自增/自减的语法限制
                in.put(ch,--degree);
                if(in.get(ch)==0) q.add(ch);
            }
        }
        //判断是否有环
        for(Map.Entry<Character,Integer> entry:in.entrySet())
            if(entry.getValue()!=0) return "";
        return new String(ret);
    }


    //吴小哲的思路，不过我感觉提前为每个节点配好Set更好，不用担心没有的情况，所以我稍稍改了点
    Map<Character,Set<Character>> edges=new HashMap<>();
    Map<Character,Integer> in=new HashMap<>();
    boolean check;
    public String alienOrder2(String[] words) {
        //先将入度全置零,同时把邻接表的头后面都配上Set容器
        for(String s:words){
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(!edges.containsKey(ch)) edges.put(ch,new HashSet<>());
                if(!in.containsKey(ch)) in.put(ch,0);
            }
        }
        //建表
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                add(words[i],words[j]);
                if(check) return "";
            }
        }
        StringBuffer ret=new StringBuffer();
        //拓扑排序
        Queue<Character> q=new LinkedList<>();
        for(char ch:in.keySet()) if(in.get(ch)==0) q.add(ch);
        while(!q.isEmpty()){
            char t=q.poll();
            ret.append(t);
            //切掉t连的边
            for(char ch:edges.get(t)){
                in.put(ch,in.get(ch)-1);
                if(in.get(ch)==0) q.add(ch);
            }
        }
        //判断是否有环
        for(char ch:in.keySet()) if(in.get(ch)!=0) return "";
        return ret.toString();
    }
    public void add(String s1,String s2){
        int min=Math.min(s1.length(),s2.length());
        int cur=0;
        for(;cur<min;cur++){
            char ch1=s1.charAt(cur),ch2=s2.charAt(cur);
            if(ch1!=ch2){
                if(!edges.get(ch1).contains(ch2)){//没有添加过再添加
                    edges.get(ch1).add(ch2);
                    in.put(ch2,in.get(ch2)+1);
                }
                break;//只要进来了，不管是否添加，都算已经看过了
            }
        }
        if(cur==s2.length()&&cur<s1.length()) check=true;
    }
}
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-19
 * Time: 19:43
 */
class Solution {
    //2092. 找出知晓秘密的所有专家
    public List<Integer> findAllPeople(int n, int[][] m, int f) {
        //因为秘密传播按时间顺序发生，所以按时间排序
        Arrays.sort(m,(a, b)->a[2]-b[2]);
        //初始化知道秘密的人的集合，初始时0号和f知道秘密
        Set<Integer> haveSecret=new HashSet<>();
        haveSecret.add(0);
        haveSecret.add(f);
        //分组处理同一时间的所有会议
        int len=m.length;
        //用i遍历所有会议，每次处理完同一时间的会议后，i直接跳到下一个时间的会议
        for(int i=0;i<len;){
            //获取当前处理的会议时间
            int curtime=m[i][2];
            //构建当前时间所有会议的邻接表
            Map<Integer,List<Integer>> graph=new HashMap<>();
            //遍历所有时间当前的会议，构建图
            for(;i<len&&m[i][2]==curtime;i++){
                int x=m[i][0],y=m[i][1];
                //给x添加y，给y添加x，因为会议是双向的x能传给y，y也能传给x
                graph.computeIfAbsent(x,k->new ArrayList<>()).add(y);
                graph.computeIfAbsent(y,k->new ArrayList<>()).add(x);
            }
            //标记已访问的节点，避免DFS重复遍历
            Set<Integer> visited=new HashSet<>();
            //遍历当前时间会议的所有参会人
            for(int person:graph.keySet())
                //如果当前人知道秘密，且还未被访问过，就从他出发，标记所有连通的人都知道秘密
                if(haveSecret.contains(person)&&!visited.contains(person))
                    dfs(person,graph,visited,haveSecret);
        }
        return new ArrayList<>(haveSecret);
    }
    private void dfs(int cur,Map<Integer,List<Integer>> graph,Set<Integer> visited,Set<Integer> haveSecret){
        //标记当前节点
        visited.add(cur);
        //将当前节点加入知道秘密的集合，即使已存在也会天然去重
        haveSecret.add(cur);
        //遍历当前节点的所有邻居
        for(int neighbor:graph.get(cur))
            if(!visited.contains(neighbor))
                dfs(neighbor,graph,visited,haveSecret);
    }
}

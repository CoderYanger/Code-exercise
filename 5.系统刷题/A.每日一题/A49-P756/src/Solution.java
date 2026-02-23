import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-01
 * Time: 14:51
 */
class Solution {
    //756. 金字塔转换矩阵
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        //构建三元映射表：group[a][b]存储所有允许由前两个字符生成的字符
        //A-F共6个，所以数组大小为6×6
        List<Character>[][] groups=new ArrayList[6][6];
        //初始化映射表中的每一个位置为空列表
        for(List<Character>[] row:groups)
            Arrays.setAll(row, _->new ArrayList<>());
        //填充映射表：遍历所有允许的三元组，将前两个字符作为索引，第三个字符作为值存入
        for(String ss:allowed){
            char[] s=ss.toCharArray();
            int a=s[0]-'A';//第一个字符转索引
            int b=s[1]-'A';//第二个字符转索引
            groups[a][b].add(s[2]);//存储生成的目标字符
        }
        //初始化金字塔二维数组：pyramid[i]表示第i层的字符数组(i越大，层越靠下)
        int n=bottom.length();
        char[][] pyramid=new char[n][];
        //第0层有1个字符，第i层有i+1个字符
        for(int i=0;i<n-1;i++) pyramid[i]=new char[i+1];
        //底部层直接赋值为输入的bottom字符串
        pyramid[n-1]=bottom.toCharArray();
        //剪枝集合：存储已经尝试过且失败的局部行
        Set<String> vis=new HashSet<>();
        //调用DFS回溯：从倒数第二行(i=n-2)开始填充，列索引从0开始
        return dfs(n-2,0,pyramid,vis,groups);
    }
    //i:当前要填充的层索引（从下往上）
    //j:当前要填充的列索引（从左往右）
    private boolean dfs(int i,int j,char[][] pyramid,Set<String> vis,List<Character>[][] groups){
        //i<0表示已经填充到-1层，即顶部已生成1个字符
        if(i<0) return true;
        //生成当前层已填充的前j个字符组成的字符串（用于剪枝）
        String cur=new String(pyramid[i],0,j);
        //剪枝：如果该局部行之前已经尝试过且失败，直接返回false
        if(vis.contains(cur)) return false;
        //如果当前层的所有列都填充完成就终止
        if(j==i+1){
            //将当前层完整字符串加入剪枝集合，标记为已尝试
            vis.add(cur);
            //递归填充上一层，重新从第0列开始
            return dfs(i-1,0,pyramid,vis,groups);
        }
        //核心：遍历所有允许生成的字符，尝试填充当前位置(i,j)
        //当前位置的字符由下一层的两个字符决定：pyramid[i+1][j]和pyramid[i+1][j+1]
        char left=pyramid[i+1][j];
        char right=pyramid[i+1][j+1];
        //从映射表中获取所有允许生成的字符
        for(char top:groups[left-'A'][right-'A']){
            //尝试填充当前位置
            pyramid[i][j]=top;
            //递归填充当前层的下一列j+1，如果递归返回true，说明找到有效路径，直接返回
            if(dfs(i,j+1,pyramid,vis,groups)) return true;
            //回溯:无需显式重置，因为下一次循环会覆盖当前位置的字符
        }
        //所有可能的字符都尝试过了，仍然无法填充成功
        return false;
    }
}
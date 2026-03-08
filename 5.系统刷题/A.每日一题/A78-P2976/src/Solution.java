import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-29
 * Time: 18:54
 */
class Solution {
    //2976. 转换字符串的最小成本 I
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        //定义为最大值的一半，防止后续相加溢出
        final int INF=0x3f3f3f3f;
        //dis[i][j]:i处字符转化为j处字符的最小成本
        int[][] dis=new int[26][26];
        //初始化为INF，表示初始不可达
        for(int i=0;i<26;i++){
            Arrays.fill(dis[i],INF);
            dis[i][i]=0;//字符自身转为自身，成本为0
        }
        //填充直接转换的成本
        for(int i=0;i<cost.length;i++){
            //将对应字符转化为索引
            int x=original[i]-'a';
            int y=changed[i]-'a';
            //取最小值：遇到相同的转换，保留最小值
            dis[x][y]=Math.min(dis[x][y],cost[i]);
        }
        //求任意两个字符间的最短路i->k->j
        //i:源字符,k:中间转换字符,j:目标字符
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                //剪枝优化，若i->k不可达，无需计算i->k->j的路径
                if(dis[i][k]==INF) continue;
                for(int j=0;j<26;j++)
                    dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
            }
        }
        //计算source转target的总最小成本，用long避免int溢出
        long ret=0;
        for(int i=0;i<source.length();i++){
            //取出索引
            int s=source.charAt(i)-'a';
            int t=target.charAt(i)-'a';
            //若当前字符转换不可达，直接返回-1
            if(dis[s][t]==INF) return -1;
            ret+=dis[s][t];
        }
        return ret;
    }
}

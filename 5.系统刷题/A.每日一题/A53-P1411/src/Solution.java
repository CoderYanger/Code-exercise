import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-10
 * Time: 13:55
 */
class Solution {
    //1411. 给 N x 3 网格图涂色的方案数
    private static final int MOD=1_000_000_007;
    //全局memo:记忆的内容可以在不同测试数据间共享
    private static Map<Integer,Integer> memo=new HashMap<>();
    public int numOfWays(int n) {
        return dfs(n,0,0,0);
    }
    //(i,j):i行j列
    //preRow:上一行(i+1行)的颜色
    //curRow:当前行的颜色
    private int dfs(int i,int j,int preRow,int curRow){
        //如果所有格子都已涂色，说明找到了一个方案
        if(i==0) return 1;
        //如果i行已涂色，开始对i-1行涂色，当前行作为下一个递归的前一行
        if(j==3) return dfs(i-1,0,curRow,0);
        //参数压缩到一个int中
        //int中的存储格式：当前行号+当前列号+上一行所填颜色+当前行所填颜色
        //i不知道多少行，所以右移14位放最前面
        //j取值为012，占两个比特位
        //preRow和curRow均占2×3个比特位
        int key=(i<<14)|(j<<12)|(preRow<<6)|curRow;
        //先往备忘录里瞅瞅
        if(memo.containsKey(key)) return memo.get(key);
        int ret=0;
        //枚举(i,j)的颜色color
        for(int color=0;color<3;color++){
            //不能和下面相邻格子(i+1,j)颜色相同
            //preRow>0:先判断下一行是否有数据，有的话就要保证颜色不能相同
            //(preRow>>(j*2)&3)：将需要比较的颜色从里面移动到最右边再用|提取出来
            //preRow存储格式：最右侧颜色标识数+中间颜色标识数+最左侧标识数
            //&3：将需要比较的颜色标识数移动到最右边后，用3（二进制11）来提取出颜色
            if(preRow>0&&color==(preRow>>(j*2)&3)||
                    //不能和左侧相邻格子(i,j-1)颜色相同
                    j>0&&color==(curRow>>((j-1)*2)&3))
                continue;
            //此行还未填完，因此preRow保持不变，把当前color存入当前行curRow的对应位置
            ret=(ret+dfs(i,j+1,preRow,curRow|(color<<(j*2))))%MOD;
        }
        memo.put(key,ret);//存进备忘录
        return ret;
    }
}
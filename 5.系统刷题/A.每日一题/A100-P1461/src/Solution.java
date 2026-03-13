import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-23
 * Time: 11:48
 */
class Solution {
    //1461. 检查一个字符串是否包含所有长度为 K 的二进制子串
    //解法一：暴力枚举
    public boolean hasAllCodes(String s, int k) {
        Set<String> hash=new HashSet<>();
        for(int i=k;i<=s.length();i++)
            hash.add(s.substring(i-k,i));
        return hash.size()==(1<<k);
    }

    //解法二：递归回溯DFS
    public boolean hasAllCodes(String s, int k) {
        int n=s.length();
        int sum=1<<k;
        //剪枝：s最多能提供n+1-k个不同子串，数量不足直接返回
        if(n+1-k<sum) return false;
        //预处理：把s中所有长度为k的子串存入Set
        Set<String> hash=new HashSet<>();
        for(int i=k;i<=s.length();i++)
            hash.add(s.substring(i-k,i));
        //递归回溯生成所有k位二进制串
        return check(k,new StringBuilder(),hash);
    }
    private boolean check(int k,StringBuilder cur,Set<String> hash){
        //长度=k时检查是否存在
        if(cur.length()==k) return hash.contains(cur.toString());
        //选择1：当前位填0
        cur.append('0');
        boolean zero=check(k,cur,hash);
        //回溯，恢复现场
        cur.deleteCharAt(cur.length()-1);
        //不满足直接返回
        if(!zero) return false;
        //选择2：当前位填1
        cur.append('1');
        boolean one=check(k,cur,hash);
        //回溯，恢复现场
        cur.deleteCharAt(cur.length()-1);
        //不满足直接返回
        if(!one) return false;
        //两个选择都满足，返回true
        return true;
    }


    //解法三：滑动窗口+位运算
    public boolean hasAllCodes(String s, int k) {
        //计算MASK：二进制为k个连续的1，作用：保留数组低k位，清除高位
        final int MASK=(1<<k)-1;
        //长度为2的k次幂，标记是否在s中出现过
        boolean[] mark=new boolean[1<<k];
        //统计出现过的不同k位二进制子串数量
        int cnt=0;
        //滑动窗口的当前值，用于存储滑动窗口内的二进制
        int x=0;
        for(int i=0;i<s.length()&&cnt<(1<<k);i++){
            //拿到当前遍历的字符0或1
            char c=s.charAt(i);
            //O(1)完成更新
            //①x<<1：x整体左移1位，给新字符腾出最低位位置
            //②&MASK：出窗口操作，保留低k位，清除超出k位的高位
            //③|(ch&1)：把字符转成整数放到最低位，完成滑动
            x=(x<<1&MASK)|(c&1);
            //只要窗口长度凑够k位，才需要判断
            //0~k-1恰好k位
            if(i>=k-1&&!mark[x]){
                //标记出现过
                mark[x]=true;
                cnt++;
            }
        }
        return cnt==(1<<k);
    }
}

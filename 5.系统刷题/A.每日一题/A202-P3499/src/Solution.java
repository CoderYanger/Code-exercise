/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-28
 * Time: 15:15
 */
class Solution {
    //3499. 操作后最大活跃区段数 I
    public int maxActiveSectionsAfterTrade(String S) {
        char[] s=S.toCharArray();
        //total：原始字符串中所有'1'的总数
        int total=0;
        //mx所有相邻两个'0'段长度之和的最大值
        int mx=0;
        //pre0上一个'0'段的长度，初始为极小值以便忽略第一个'0'段
        int pre=-0x3f3f3f3f;
        //cnt:当前正在扫描的连续相同字符块的长度
        int cnt=0;
        //遍历字符串按连续相同字符进行分段
        for(int i=0;i<s.length;i++) {
            cnt++;//当前块长度+1
            //如果到达字符串末尾，或者当前字符与下一个字符不同，说明当前块结束
            if (i==s.length-1||s[i]!=s[i+1]) {
                //处理结束的块
                if (s[i]=='1') {
                    // 当前块是'1'块：累加其长度到total
                    total+=cnt;
                }else {
                    //当前块是'0'块：计算它与前一个'0'块的长度之和
                    //pre+cnt表示两个相邻'0'段长度之和，尝试更新最大值
                    mx=Math.max(mx,pre+cnt);
                    //更新pre为当前'0'块长度供下次使用
                    pre=cnt;
                }
                //重置计数器，开始记录下一个块
                cnt=0;
            }
        }
        //最终最大活跃区段数=原始'1'总数+最大相邻'0'段长度和
        return total+mx;
    }
}

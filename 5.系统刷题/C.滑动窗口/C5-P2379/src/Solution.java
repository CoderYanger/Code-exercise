/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-22
 * Time: 11:31
 */
class Solution {
    //2379. 得到 K 个黑块的最少涂色次数
    public int minimumRecolors(String blocks, int k) {
        int ret=0x3f3f3f3f;//初始化为最大整型的一半防止取最小值干扰
        char[] s=blocks.toCharArray();
        int n=s.length;
        for(int right=0;right<n;right++){
            int left=right-k+1;
            //进窗口
            if(left<0) continue;
            //更新
            int count=0;
            for(int i=left;i<=right;i++) if(s[i]=='W') count++;
            ret=Math.min(ret,count);
            //出窗口
            left++;
        }
        return ret;
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-02
 * Time: 18:04
 */
class Solution {
    //2220. 转换数字的最少位翻转次数
    //解法一：位运算
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start^goal);
    }

    //解法二：模拟
    public int minBitFlips(int x, int y) {
        int count=0;
        while(x!=0||y!=0){
            int x1=x&1;
            int y1=y&1;
            if(x1!=y1) count++;
            x>>=1;
            y>>=1;
        }
        return count;
    }
}

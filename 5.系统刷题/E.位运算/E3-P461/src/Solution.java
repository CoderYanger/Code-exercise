/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-02
 * Time: 18:03
 */
class Solution {
    //461. 汉明距离
    //解法一：位运算
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }

    //解法二：模拟
    public int hammingDistance(int x, int y) {
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
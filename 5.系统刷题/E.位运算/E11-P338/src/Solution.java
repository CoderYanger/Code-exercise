/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-04
 * Time: 22:55
 */
class Solution {
    //338. 比特位计数
    //解法一：库方法
    public int[] countBits(int n) {
        int[] ret=new int[n+1];
        for(int i=0;i<=n;i++)
            ret[i]=Integer.bitCount(i);
        return ret;
    }

    //解法二：n&(n-1)
    public int[] countBits(int n) {
        int[] ret=new int[n+1];
        for(int i=0;i<=n;i++){
            int t=i;
            while(t!=0){
                ret[i]++;
                t&=t-1;
            }
        }
        return ret;
    }
    
}

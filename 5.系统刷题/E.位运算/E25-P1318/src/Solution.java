/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-26
 * Time: 15:42
 */
class Solution {
    //1318. 或运算的最小翻转次数
    public int minFlips(int a, int b, int c) {
        int cnt=0;
        for(;c>0||a>0||b>0;c>>=1,a>>=1,b>>=1){
            int cc=c&1,aa=a&1,bb=b&1;
            //a和b对应位全是0，翻转一个即可
            if(cc==1&&(aa|bb)==0) cnt++;
            else if(cc==0&&(aa|bb)==1){
                //a和b对应位全是1，都需要翻转
                if((aa&bb)==1) cnt+=2;
                    //a和b只有一位是1
                else cnt++;
            }
        }
        return cnt;
    }
}
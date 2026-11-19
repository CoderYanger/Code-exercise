/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-08-30
 * Time: 17:28
 */
class Solution {
    //3014. 输入单词需要的最少按键次数 I
    public int minimumPushes(String word) {
        int n=word.length(),cnt=0;
        while(n>0){
            cnt+=n;
            n-=8;
        }
        return cnt;
    }
}

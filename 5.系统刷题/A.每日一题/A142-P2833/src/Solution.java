/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-04-26
 * Time: 22:59
 */
class Solution {
    //2833. 距离原点最远的点
    public int furthestDistanceFromOrigin(String moves) {
        int cnt=0,cnt_=0;
        for(char c:moves.toCharArray()){
            if(c=='L') cnt++;
            else if(c=='R')cnt--;
            else cnt_++;
        }
        return cnt>=0?cnt+cnt_:-cnt+cnt_;
    }
}

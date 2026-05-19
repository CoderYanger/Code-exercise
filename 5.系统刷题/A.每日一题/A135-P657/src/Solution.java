/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-18
 * Time: 14:42
 */
class Solution {
    //657. 机器人能否返回原点
    public boolean judgeCircle(String moves) {
        int cnt1=0,cnt2=0;
        for(char c:moves.toCharArray()){
            if(c=='U') cnt1++;
            else if(c=='D') cnt1--;
            else if(c=='R') cnt2++;
            else cnt2--;
        }
        return cnt1==0&&cnt2==0;
    }
}

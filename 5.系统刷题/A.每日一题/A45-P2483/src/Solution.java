/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-31
 * Time: 20:54
 */
class Solution {
    //2483. 商店的最少代价
    public int bestClosingTime(String s) {
        //默认第0天关门，门店越冷，越不更新，门店热闹了，说明关门时间要往后拖，越要更新
        int prev=0,minprev=0,ret=0;
        for(int i=0;i<s.length();i++){
            prev+=s.charAt(i)=='N'?1:-1;
            if(prev<minprev){
                minprev=prev;
                //说明当天比最冷门的那天热闹，关门时间要往后拖一天
                ret=i+1;
            }
        }
        return ret;
    }
}

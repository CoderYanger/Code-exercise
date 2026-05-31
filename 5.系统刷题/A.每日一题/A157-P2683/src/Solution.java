/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-12
 * Time: 23:06
 */
class Solution {
    //2683. 相邻值的按位异或
    public boolean doesValidArrayExist(int[] derived) {
        int ret=0;
        for(int x:derived) ret^=x;
        return ret==0;
    }
}

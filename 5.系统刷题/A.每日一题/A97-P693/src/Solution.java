/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-18
 * Time: 20:33
 */
class Solution {
    //写法一：无符号右移>>>+按位与&
    public boolean hasAlternatingBits(int n) {
        if(n==1) return true;
        int mark=n&1;//取出最低位
        n=n>>>1;
        while(n>0){
            if((n&1)==mark) return false;
            mark=n&1;
            n=n>>>1;
        }
        return true;
    }

    //写法二：按位异或^
    public boolean hasAlternatingBits(int n) {
        int x=(n>>1)^n;
        return ((x+1)&x)==0;
    }

}

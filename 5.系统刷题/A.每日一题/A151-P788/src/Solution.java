/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-05-10
 * Time: 18:12
 */
class Solution {
    //788. 旋转数字
    public int rotatedDigits(int n) {
        int cnt=0;
        for(int i=1;i<=n;i++) if(check(i)) cnt++;
        return cnt;
    }
    private boolean check(int x){
        String s=String.valueOf(x);
        int t=0;
        for(char c:s.toCharArray()){
            if(c=='3'||c=='4'||c=='7') return false;
            else if(c=='2') t=t*10+5;
            else if(c=='6') t=t*10+9;
            else if(c=='5') t=t*10+2;
            else if(c=='9') t=t*10+6;
            else t=t*10+(int)(c-'0');
        }
        return t!=x;
    }
}

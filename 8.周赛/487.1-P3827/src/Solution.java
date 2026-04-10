/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-03
 * Time: 13:52
 */
class Solution {
    //3827. 统计单比特整数
    public int countMonobit(int n) {
        int count=0;
        for(int i=0;i<=n;i++)
            if(check(i)) count++;
        return count;
    }
    private boolean check(int n){
        String s=Integer.toBinaryString(n);
        for(int i=1;i<s.length();i++)
            if(s.charAt(i)!=s.charAt(0))
                return false;
        return true;
    }
}

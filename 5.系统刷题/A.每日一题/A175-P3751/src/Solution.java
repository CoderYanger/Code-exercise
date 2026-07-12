/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-08
 * Time: 23:42
 */
class Solution {
    //3751. 范围内总波动值 I
    public int totalWaviness(int num1, int num2) {
        if(num2<100) return 0;
        int cnt=0;
        for(int i=num1;i<=num2;i++){
            if(i<=100) continue;
            String s=String.valueOf(i);
            for(int j=1;j<s.length()-1;j++){
                if(s.charAt(j)>s.charAt(j-1)&&s.charAt(j)>s.charAt(j+1)) cnt++;
                else if(s.charAt(j)<s.charAt(j-1)&&s.charAt(j)<s.charAt(j+1)) cnt++;
            }
        }
        return cnt;
    }
}
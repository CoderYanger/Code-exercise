/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-26
 * Time: 15:56
 */
class Solution {
    //1189. “气球” 的最大数量
    public int maxNumberOfBalloons(String text) {
        int b=0,a=0,l=0,o=0,n=0;
        for(int i=0;i<text.length();i++){
            char c=text.charAt(i);
            if(c=='b') b++;
            else if(c=='a') a++;
            else if(c=='l') l++;
            else if(c=='o') o++;
            else if(c=='n') n++;
        }
        l/=2;o/=2;
        return Math.min(b,Math.min(a,Math.min(l,Math.min(o,n))));
    }
}

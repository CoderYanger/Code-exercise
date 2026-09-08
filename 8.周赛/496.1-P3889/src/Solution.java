/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-06
 * Time: 16:08
 */
class Solution {
    //3889. 镜像频次距离
    public int mirrorFrequency(String s) {
        int[] hasha=new int[26];
        int[] hash0=new int[10];
        for(char c:s.toCharArray()){
            if(check(c)) hasha[c-'a']++;
            else hash0[c-'0']++;
        }
        int ret=0;
        for(int i=0;i<13;i++)
            ret+=Math.abs(hasha[i]-hasha[25-i]);
        for(int i=0;i<5;i++)
            ret+=Math.abs(hash0[i]-hash0[9-i]);
        return ret;
    }
    private boolean check(char c){
        return c>='a'&&c<='z';
    }
}
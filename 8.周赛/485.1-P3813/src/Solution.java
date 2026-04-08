/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-18
 * Time: 17:22
 */
class Solution {
    //3813. 元音辅音得分
    public int vowelConsonantScore(String s) {
        int v=0,c=0;
        for(char ch:s.toCharArray()){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                v++;
            else if(ch<='z'&&ch>='a') c++;
        }
        return c>0?v/c:0;
    }
}
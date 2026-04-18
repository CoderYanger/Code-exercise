/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-15
 * Time: 13:45
 */
class Solution {
    //100987. 带权单词映射
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuffer sb=new StringBuffer();
        for(String s:words){
            int sum=0;
            for(char c:s.toCharArray())
                sum+=weights[c-'a'];
            int r=sum%26;
            sb.append((char)((int)'z'-r));
        }
        return sb.toString();
    }
}

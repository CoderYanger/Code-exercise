/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-16
 * Time: 19:42
 */
class Solution {
    //3612. 用特殊操作处理字符串 I
    public String processStr(String s) {
        StringBuffer cur=new StringBuffer();
        for(char c:s.toCharArray()){
            if(c=='*'){
                //多套一个 if 防止非小写字母进入 else 里
                if(!cur.isEmpty())
                    cur.setLength(cur.length()-1);
            }
            else if(c=='#') cur.append(cur);
            else if(c=='%') cur.reverse();
            else cur.append(c);
        }
        return cur.toString();
    }
}

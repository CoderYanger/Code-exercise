import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-01
 * Time: 16:21
 */
class Solution {
    //3853. 合并靠近字符
    public String mergeCharacters(String ss, int k) {
        StringBuffer sb=new StringBuffer();
        char[] s=ss.toCharArray();
        List<Character> list=new ArrayList<>();
        boolean mark;
        for(char c:s) list.add(c);
        do{
            mark=false;
            for(int i=0;i<list.size();i++){
                for(int j=i+1;j<list.size()&&j<=i+k;j++){
                    if(list.get(j)==list.get(i)){
                        list.remove(j);
                        mark=true;
                        break;
                    }
                }
                if(mark) break;
            }
        }while(mark);
        for(char c:list) sb.append(c);
        return sb.toString();
    }
}
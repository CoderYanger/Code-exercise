import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-04-26
 * Time: 20:38
 */
class Solution {
    //2452. 距离字典两次编辑以内的单词
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n=queries.length;
        List<String> list=new ArrayList<>();
        for(String s1:queries){
            for(String s2:dictionary){
                if(check(s1,s2)){
                    list.add(s1);
                    break;
                }
            }
        }
        return list;
    }
    private boolean check(String s1,String s2){
        int n=s1.length();
        int cnt=0;
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                cnt++;
                if(cnt>2) return false;
            }
        }
        return cnt<=2;
    }
}
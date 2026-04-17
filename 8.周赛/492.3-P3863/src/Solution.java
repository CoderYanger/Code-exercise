import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-08
 * Time: 16:32
 */
class Solution {
    //3863. 将一个字符串排序的最小操作次数
    public int minOperations(String s) {
        int n=s.length();
        char[] sorted=s.toCharArray();
        Arrays.sort(sorted);
        String target=new String(sorted);
        if(s.equals(target)) return 0;
        if(n==2) return -1;
        char minchar=target.charAt(0);
        char maxchar=target.charAt(n-1);
        if((minchar==s.charAt(0)||maxchar==s.charAt(n-1))) return 1;
        boolean minmove=s.indexOf(minchar)<n-1;
        boolean maxmove=s.lastIndexOf(maxchar)>0;
        if(minmove||maxmove) return 2;
        return 3;
    }
}

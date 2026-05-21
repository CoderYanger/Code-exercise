import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-18
 * Time: 21:28
 */
class Solution {
    //2515. 到目标字符串的最短距离
    //写法一：从左往右遍历
    public int closestTarget(String[] words, String target, int startIndex) {
        List<Integer> list=new ArrayList<>();
        int n=words.length;
        for(int i=0;i<n;i++){
            int x=Math.abs(i-startIndex);
            if(words[i].equals(target)) list.add(Math.min(x,n-x));
        }
        if(list.size()==0) return -1;
        int ret=0x3f3f3f3f;
        for(int x:list) ret=Math.min(ret,x);
        return ret;
    }

    //写法一优化
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length;
        int ret=n;
        for(int i=0;i<n;i++){
            if(words[i].equals(target)){
                int x=Math.abs(i-startIndex);
                ret=Math.min(ret,Math.min(x,n-x));
            }
        }
        return ret==n?-1:ret;
    }

    //写法二：从startIndex往两边遍历
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length;
        for(int k=0;k<=n/2;k++)
            if(words[(startIndex-k+n)%n].equals(target)||words[(startIndex+k)%n].equals(target))
                return k;
        return -1;
    }
    
}

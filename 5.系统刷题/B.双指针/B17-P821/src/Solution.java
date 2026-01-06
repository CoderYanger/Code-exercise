import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-17
 * Time: 18:16
 */
class Solution {
    //821. 字符的最短距离
    public int[] shortestToChar(String ss, char c) {
        List<Integer> list=new ArrayList<>();
        //把每个目标字符的位置存进链表中
        char[] s=ss.toCharArray();
        int n=s.length;
        int[] ret=new int[n];
        for(int i=0;i<n;i++) if(s[i]==c) list.add(i);
        //从左往右依次枚举判断是否符合条件
        for(int i=0;i<n;i++){
            int fill=0x3f3f3f3f;//为每个位置都设定一个待填充的值
            for(int x:list){
                fill=Math.min(fill,Math.abs(i-x));
            }
            ret[i]=fill;
        }
        return ret;
    }

    //双指针优化
    public int[] shortestToChar2(String ss, char c) {
        //双指针优化：时间复杂度O（N）
        //优于暴力枚举和中心扩展
        int n=ss.length();
        char[] s=ss.toCharArray();
        int[] ret=new int[n];
        //全初始化为最大值
        Arrays.fill(ret,0x3f3f3f3f);
        int prev=-1;//记录上一个c的位置
        //先从左往右遍历
        for(int i=0;i<n;i++){
            if(s[i]==c){
                ret[i]=0;
                prev=i;//更新
            }else
            if(prev!=-1)
                ret[i]=i-prev;
        }
        //再从右往左遍历
        prev=-1;
        for(int i=n-1;i>=0;i--){
            if(s[i]==c) prev=i;//此处的ret[i]是0，一定是最小的
            else
            if(prev!=-1)
                ret[i]=Math.min(ret[i],prev-i);

        }
        return ret;
    }
}
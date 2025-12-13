import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-03
 * Time: 20:38
 */
class Solution {
    //2418. 按身高排序
    //吴小哲的解法，看完他敲完之后自己又敲了一遍，一遍过
    public String[] sortPeople(String[] names, int[] heights) {
        int n=names.length;
        String[] ret=new String[n];
        Integer[] index=new Integer[n];
        for(int i=0;i<n;i++) index[i]=i;
        Arrays.sort(index,(a, b)->heights[b]-heights[a]);
        for(int i=0;i<n;i++) ret[i]=names[index[i]];
        return ret;
    }

    //哈希表的写法，自己写有点吃力，借助AI了
    public String[] sortPeople2(String[] names, int[] heights) {
        int n=names.length;
        String[] ret=new String[n];
        HashMap<Integer,String> hash=new HashMap<>();
        for(int i=0;i<n;i++) hash.put(heights[i],names[i]);
        //转换为包装类型
        Integer[] tmp=new Integer[n];
        for(int i=0;i<n;i++)  tmp[i]=heights[i];
        Arrays.sort(tmp,(a,b)->b-a);
        for(int i=0;i<n;i++) ret[i]=hash.get(tmp[i]);
        return ret;
    }
}

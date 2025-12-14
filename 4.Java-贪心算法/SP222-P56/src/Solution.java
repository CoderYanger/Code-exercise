import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-11
 * Time: 16:50
 */
class Solution {
    //56. 合并区间
    //除了创建顺序表、往顺序表里存值、返回值，其余都是自己写的，一遍过
    //跟吴小哲写的一样
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int[]> ret=new ArrayList<>();//这个看了吴小哲的代码
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);//按左端点升序排序
        int left=intervals[0][0],right=intervals[0][1];
        for(int i=1;i<n;i++){
            int a=intervals[i][0],b=intervals[i][1];
            if(a<=right) right=Math.max(right,b);
            else{
                //把前一个区间先放进去
                ret.add(new int[]{left,right});//这个也看了吴小哲的代码
                //再找下一个区间
                left=a;right=b;
            }
        }
        //放最后一个区间
        ret.add(new int[]{left,right});
        return ret.toArray(new int[0][]);//这个返回值还是看了吴小哲的代码
        //new int[0][]的意思是不限行不限列，指定返回的数组类型为int[][]
    }
}

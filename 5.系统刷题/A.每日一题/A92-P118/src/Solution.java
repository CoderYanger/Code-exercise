import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-14
 * Time: 18:13
 */
class Solution {
    //118. 杨辉三角
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ret=new ArrayList<>(n);//预分配空间
        //List.of(1)≈创建数组直接赋值
        ret.add(List.of(1));
        for(int i=1;i<n;i++){
            List<Integer> row=new ArrayList<>(i+1);//预分配空间
            row.add(1);
            for(int j=1;j<i;j++)
                //左上方数+正上方的数
                row.add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
            row.add(1);
            ret.add(row);
        }
        return ret;
    }
}

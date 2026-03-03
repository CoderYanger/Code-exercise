import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-16
 * Time: 17:20
 */
class Solution {
    //2975. 移除栅栏得到的正方形田地的最大面积
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final int MOD=1_000_000_007;
        //获取水平方向所有可能的间隔长度集合
        Set<Integer> hSet=f(hFences,m);
        //获取垂直方向所有可能的间隔长度集合
        Set<Integer> vSet=f(vFences,n);
        int ret=0;
        //遍历水平方向的所有间隔长度
        for(int x:hSet)
            //如果垂直方向也存在相同的间隔长度，说明可以围成边长为x的正方形
            if(vSet.contains(x))
                //更新最大边长
                ret=Math.max(ret,x);
        return ret>0?(int)((long)ret*ret%MOD):-1;
    }
    private Set<Integer> f(int[] a,int l){
        //获取原栅栏数组的长度
        //比如水平围栏hFences=[2,4],m=5
        int n=a.length;
        //复制原数组并扩容两个位置，存储两个边界点1和l
        //先扩容成[2,4,0,0]
        a= Arrays.copyOf(a,n+2);
        //存储起始坐标，最左最上边界
        //变成[2,4,1,0]
        a[n++]=1;
        //存储结束坐标，最右最下边界
        //变成[2,4,1,5]
        a[n++]=l;
        //一起排序，保证差值为正
        //变成[1,2,4,5]
        Arrays.sort(a);
        //计算a中任意两个数的差，存到哈希表中
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                set.add(a[j]-a[i]);
        return set;
    }
}
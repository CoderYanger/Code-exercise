import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-07-18
 * Time: 21:25
 */
class Solution {
    //1331. 数组序号转换
    //解法一：二分查找
    public int[] arrayRankTransform(int[] arr) {
        //排序
        int[] sorted=arr.clone();
        Arrays.sort(sorted);
        //去重
        int index=0;
        for(int x:sorted)
            //如果这个数是第一个或者与前一个不同，说明是一个新面孔
            if(index==0||x!=sorted[index-1])
                sorted[index++]=x;
        for(int i=0;i<arr.length;i++)
            arr[i]= Arrays.binarySearch(sorted,0,index,arr[i])+1;
        return arr;
    }

    //1331. 数组序号转换
    //解法二：哈希表
    public int[] arrayRankTransform(int[] arr) {
        //排序
        int[] sorted=arr.clone();
        Arrays.sort(sorted);
        //去重的同时构建哈希表
        Map<Integer,Integer> rank=new HashMap<>();
        int index=0;
        for(int x:sorted){
            //如果这个数是第一个或者与前一个不同，说明是一个新面孔
            if(index==0||x!=sorted[index-1])
                rank.put(x,rank.size()+1);
            index++;
        }
        for(int i=0;i<arr.length;i++)
            arr[i]=rank.get(arr[i]);
        return arr;
    }

}

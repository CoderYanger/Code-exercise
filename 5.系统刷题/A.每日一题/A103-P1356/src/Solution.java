import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-25
 * Time: 20:58
 */
class Solution {
    //1356. 根据数字二进制下 1 的数目排序
    //解法一：传比较器
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        Integer[] nums=new Integer[n];
        for(int i=0;i<n;i++) nums[i]=arr[i];
        Arrays.sort(nums,new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                int d=Integer.bitCount(a)-Integer.bitCount(b);
                return d==0?a-b:d;
            }
        });
        for(int i=0;i<n;i++) arr[i]=nums[i];
        return arr;
    }


    //解法二：位运算
    public int[] sortByBits(int[] arr) {
        for(int i=0;i<arr.length;i++)
            arr[i]=Integer.bitCount(arr[i])<<16|arr[i];
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++)
            arr[i]&=0xffff;
        return arr;
}

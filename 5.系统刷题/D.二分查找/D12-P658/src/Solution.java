import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-16
 * Time: 22:52
 */
public class Solution {
    //658. 找到 K 个最接近的元素
    //解法一：排序
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list=new ArrayList<>();
        for(int a:arr) list.add(a);
        Collections.sort(list,new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                if(Math.abs(x-a)!=Math.abs(x-b))
                    return Math.abs(x-a)-Math.abs(x-b);
                else return a-b;
            }
        });
        List<Integer> ret=list.subList(0,k);
        Collections.sort(ret);
        return ret;
    }

    //解法二：双指针+二分查找
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right=binarySearch(arr,x);
        int left=right-1;
        //维护[left,right]作为结果区间
        while(k-->0){
            if(left<0) right++;
            else if(right>=arr.length) left--;
            else if(x-arr[left]<=arr[right]-x) left--;
            else right++;
        }
        List<Integer> ret=new ArrayList<>();
        for(int i=left+1;i<right;i++)
            ret.add(arr[i]);
        return ret;
    }
    public int binarySearch(int[] arr,int x){
        //最左端点模型
        int left=0,right=arr.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]<x) left=mid+1;
            else right=mid;
        }
        return left;
    }
}

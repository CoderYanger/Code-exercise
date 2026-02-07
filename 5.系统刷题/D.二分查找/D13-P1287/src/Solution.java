import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-17
 * Time: 16:18
 */
class Solution {
    //1287. 有序数组中出现次数超过25%的元素
    //解法一：暴力枚举
    public int findSpecialInteger(int[] arr) {
        int n=arr.length;
        Map<Integer,Integer> hash=new HashMap<>();
        for(int x:arr){
            //merge，如果x键不存在，直接初始化为1，调用Integer的sum方法累加
            hash.merge(x,1,Integer::sum);
            //第二种等价写法
            // hash.put(x,hash.getOrDefault(x,0)+1);
            if(4*hash.get(x)>n) return x;
        }
        //照顾编译器
        return -1;
    }

    //解法二：二分查找
    public int findSpecialInteger(int[] arr) {
        int n=arr.length,m=n/4;
        //原来for-each遍历还能这么写，啊哈哈哈
        //也可以写成n-1-m,n-2m-2，然后对应下面返回改成n-3m-3
        for(int i:new int[]{m,2*m+1}){
            int x=arr[i];
            if(binarysearch(arr,x+1)-binarysearch(arr,x)>m) return x;
        }
        //如果答案不是m或者2m+1，那一定是3m+2
        return arr[3*m+2];
    }
    //最左端点模型
    private int binarysearch(int[] arr,int t){
        int left=0,right=arr.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]<t) left=mid+1;
            else right=mid;
        }
        return left;
    }

    //解法二优化：只跑一次二分
    public int findSpecialInteger(int[] arr) {
        int n=arr.length,m=n/4;
        //原来for-each遍历还能这么写，啊哈哈哈
        //也可以写成n-1-m,n-2m-2，然后对应下面返回改成n-3m-3
        for(int i:new int[]{m,2*m+1}){
            int x=arr[i];
            int j=binarysearch(arr,x);
            if(arr[j+m]==x) return x;
        }
        //如果答案不是m或者2m+1，那一定是3m+2
        return arr[3*m+2];
    }
    //最左端点模型
    private int binarysearch(int[] arr,int t){
        int left=0,right=arr.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]<t) left=mid+1;
            else right=mid;
        }
        return left;
    }
}
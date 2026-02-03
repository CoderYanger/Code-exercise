import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-14
 * Time: 17:52
 */
class Solution {
    //1385. 两个数组间的距离值
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n=arr2.length,ret=0;
        Arrays.sort(arr2);
        for(int x:arr1){
            //找最左端点模型解法
            int t=x-d;
            int left=0,right=n-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if(arr2[mid]<x-d) left=mid+1;
                else right=mid;
            }
            //arr2[left]<x-d:说明所有的数都比x-d小，全符合条件
            //arr2[left]>x+d:说明所有的数都比x-d大，全符合条件
            if(arr2[left]<x-d||arr2[left]>x+d) ret++;
        }
        return ret;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n=arr2.length,ret=0;
        Arrays.sort(arr2);
        for(int x:arr1){
            //找最右端点模型解法
            int t=x-d;
            int left=0,right=n-1;
            while(left<right){
                int mid=left+(right-left+1)/2;
                if(arr2[mid]>x+d) right=mid-1;
                else left=mid;
            }
            //arr2[left]<x-d:说明所有的数都比x-d小，全符合条件
            //arr2[left]>x+d:说明所有的数都比x-d大，全符合条件
            if(arr2[left]<x-d||arr2[left]>x+d) ret++;
        }
        return ret;
    }
}

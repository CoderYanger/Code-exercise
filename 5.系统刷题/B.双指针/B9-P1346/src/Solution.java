import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-16
 * Time: 14:04
 */
class Solution {
    //1346. 检查整数及其两倍数是否存在
    public boolean checkIfExist(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                if(arr[i]==2*arr[j]||arr[j]==2*arr[i]) return true;
        return false;
    }

    public boolean checkIfExist2(int[] arr) {
        //排序+双指针的解法
        Arrays.sort(arr);//先排序，时间复杂度O(nlogn)
        int n=arr.length;
        //先正序遍历：处理正数，p只往右走,遇到负数直接p++跳过了
        int q=0;
        for(int p=0;p<n;p++){
            while(q<n&&arr[q]<2*arr[p]) q++;
            if(q<n&&q!=p&&arr[q]==2*arr[p]) return true;
        }
        //再逆序遍历：处理负数，p只往左走,遇到正数直接p++跳过了
        q=n-1;
        for(int p=n-1;p>=0;p--){
            while(q>=0&&arr[q]>2*arr[p]) q--;
            if(q>=0&&q!=p&&arr[q]==2*arr[p]) return true;
        }
        return false;
    }

    //哈希表的解法
    public boolean checkIfExist3(int[] arr) {
        Set<Integer> hash=new HashSet<>();
        int zero=0;
        for(int x:arr){hash.add(x);if(x==0) zero++;}
        for(int x:arr){
            if(x==0) continue;
            if(hash.contains(2*x)) return true;
        }
        //再处理0的情况
        if(zero>1) return true;
        return false;
    }
}
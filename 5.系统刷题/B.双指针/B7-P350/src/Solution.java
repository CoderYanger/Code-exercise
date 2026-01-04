import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-15
 * Time: 21:06
 */
class Solution {
    //350. 两个数组的交集 II
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list=new ArrayList<>();
        for(int i=0,j=0;i<nums1.length&&j<nums2.length;){
            if(nums1[i]==nums2[j]){list.add(nums1[i]);i++;j++;}
            else if(nums1[i]<nums2[j]) i++;
            else j++;
        }
        int[] ret=new int[list.size()];
        int index=0;
        for(int x:list) ret[index++]=x;
        return ret;
    }

    //解法二：哈希表
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        //保证nums1的长度最短
        if(n1>n2) return intersect(nums2,nums1);
        Map<Integer,Integer> hash=new HashMap<>();
        for(int x:nums1){
            int count=hash.getOrDefault(x,0)+1;
            hash.put(x,count);//更新新的值
        }
        int[] ret=new int[n1];
        int index=0;
        for(int x:nums2){
            int count=hash.getOrDefault(x,0);
            //如果nums1中有这个元素
            if(count>0){
                ret[index++]=x;
                count--;
                //如果hash里面还有这个值，说明至少出现了两次，需要更新一下
                if(count>0) hash.put(x,count);
                //count==0说明这个值就出现了一次，可以直接移除了
                else hash.remove(x);
            }      
        }
        //截取结果数组返回
        return Arrays.copyOfRange(ret,0,index);
    }
}
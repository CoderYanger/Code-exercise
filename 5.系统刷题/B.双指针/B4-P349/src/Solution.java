import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-15
 * Time: 20:18
 */
class Solution {
    // 349. 两个数组的交集
    //自己写的，基本一遍过
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list=new ArrayList<>();
        for(int i=0,j=0;i<nums1.length&&j<nums2.length;){
            if(nums1[i]==nums2[j]){list.add(nums1[i]);i++;j++;}
            else if(nums1[i]<nums2[j]) i++;
            else j++;
        }
        //利用Set去重
        Set<Integer> set=new HashSet<>();
        for(int x:list) set.add(x);
        int[] ret=new int[set.size()];
        int index=0;
        //set没有get方法
        // for(int i=0;i<ret.length;i++) ret[i]=set.get(i);
        for(int x:set) ret[index++]=x;
        return ret;
    }

    //解法二：两个Set容器
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        //遍历数组，把数字放进Set容器里
        for(int x:nums1) set1.add(x);
        for(int x:nums2) set2.add(x);
        return merge(set1,set2);
    }
    public int[] merge(Set<Integer> set1,Set<Integer> set2){
        if(set1.size()>set2.size()) return merge(set2,set1);
        //上面的代码保证了set2的元素更多
        Set<Integer> tmp=new HashSet<>();
        //遍历少的那个
        for(int x:set1) if(set2.contains(x)) tmp.add(x);
        int index=0;
        int[] ret=new int[tmp.size()];
        for(int x:tmp) ret[index++]=x;
        return ret;
    }

    //排序+双指针
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1=nums1.length,n2=nums2.length;
        int[] ret=new int[n1+n2];
        int index=0,index1=0,index2=0;
        while(index1<n1&&index2<n2){
            int num1=nums1[index1],num2=nums2[index2];
            if(num1==num2){//保证加入元素的唯一性
                if(index==0||num1!=ret[index-1]) ret[index++]=num1;
                index1++;
                index2++;
            //小的不要了，大的留着跟后面大的比
            }else if(num1<num2) index1++;
            else index2++;
        }
        //对结果数组进行截取
        return Arrays.copyOfRange(ret,0,index);
    }
}
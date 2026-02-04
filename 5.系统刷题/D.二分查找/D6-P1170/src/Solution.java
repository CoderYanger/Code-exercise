import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-14
 * Time: 19:53
 */
class Solution {
    //1170. 比较字符串最小字母出现频次
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //问题转化：将次数都抽取出来，那么就是说从words的次数数组中找到比queries[i]的次数大的次数的个数
        int n=queries.length,m=words.length;
        int[] nums1=new int[n];
        int[] nums2=new int[m];
        for(int i=0;i<n;i++) nums1[i]=f(queries[i]);
        for(int i=0;i<m;i++) nums2[i]=f(words[i]);
        Arrays.sort(nums2);
        int[] ret=new int[n];
        for(int i=0;i<n;i++){
            //设定目标值t
            int t=nums1[i];
            //找最右端点
            int left=0,right=m-1;
            while(left<right){
                int mid=left+(right-left+1)/2;
                if(nums2[mid]>t) right=mid-1;
                else left=mid;
            }
            ret[i]=nums2[left]>t?m:(left+1<m?m-(left+1):0);
        }
        return ret;
    }
    //计算每个字符串的字数
    private int f(String s){
        //只有小写字母，可用数组代替哈希表
        int[] hash=new int[26];
        //记录出现的最小的字母的索引
        int min=26;
        for(char c:s.toCharArray()){
            int index=c-'a';
            hash[index]++;
            min=index<min?index:min;
        }
        return hash[min];
    }
}
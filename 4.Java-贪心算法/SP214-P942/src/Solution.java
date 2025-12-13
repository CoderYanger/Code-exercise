/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-06
 * Time: 18:57
 */
class Solution {
    //942. 增减字符串匹配
    //看完算法原理后完全自己写的，一开始把结束条件忘了，造成死循环
    //还有最后一个元素漏填，最后选择用位运算异或消消乐解决
    int n;
    String s;
    int[] ret;
    int[] nums;
    public int[] diStringMatch(String ss) {
        s=new String(ss);
        n=s.length();
        ret=new int[n+1];
        nums=new int[n+1];
        for(int i=0;i<n+1;i++) nums[i]=i;
        match(0,n,0);
        int tmpret=0,tmpnums=0,tmp=0;
        for(int i=0;i<n+1;i++){tmpret^=ret[i];tmpnums^=nums[i];}
        tmp=tmpnums^tmpret;
        ret[n]=tmp;
        return ret;
    }
    public void match(int left,int right,int k){
        if(k>=n) return;
        if(s.charAt(k)=='I') ret[k++]=nums[left++];
        else ret[k++]=nums[right--];
        match(left,right,k);
    }

    //吴小哲的解法，比我的那个递归简单好多，想起来了
    //有树形分支递归好做，没分支的单行循环好做
    public int[] diStringMatch2(String s) {
        int n=s.length();
        int left=0,right=n;
        int[] ret=new int[n+1];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='I') ret[i]=left++;
            else ret[i]=right--;
        }
        //此时left和right相遇了
        ret[n]=left;
        return ret;
    }
}
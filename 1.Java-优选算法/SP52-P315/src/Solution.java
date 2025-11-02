import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-08
 * Time: 21:26
 */
class Solution {
    //315. 计算右侧小于当前元素的数
    /*给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
    示例 1：
    输入：nums = [5,2,6,1]
    输出：[2,1,1,0]
    解释：
            5 的右侧有 2 个更小的元素 (2 和 1)
2 的右侧仅有 1 个更小的元素 (1)
6 的右侧有 1 个更小的元素 (1)
1 的右侧有 0 个更小的元素
    示例 2：
    输入：nums = [-1]
    输出：[0]
    示例 3：
    输入：nums = [-1,-1]
    输出：[0,0]
    提示：
            1 <= nums.length <= 105
            -104 <= nums[i] <= 104*/

    //自己先写了一遍，也结合了豆包，但是不知道错在哪了
    int[] numstmp;
    int[] indextmp;
    int[] ret;
    int[] index;
    public List<Integer> countSmaller(int[] nums) {
        numstmp=new int[nums.length];
        indextmp=new int[nums.length];
        ret=new int[nums.length];
        index=new int[nums.length];
        for(int i=0;i<nums.length;i++) index[i]=i;
        mergesort(nums,0,nums.length-1);
        List<Integer> list=new ArrayList<>();
        for(int x:ret) list.add(x);
        return list;
    }
    public void mergesort(int[]nums,int left,int right){
        if(left>=right) return ;
        //先排序
        int mid=(left+right)/2;
        mergesort(nums,left,mid);
        mergesort(nums,mid+1,right);
        for(int i=left;i<=right;i++) indextmp[i]=index[i];
        int cur1=left,cur2=mid+1,i=0;
        while(cur1<=mid&&cur2<=right){
            if(nums[indextmp[cur1]]<=nums[indextmp[cur2]]){
                numstmp[i]=nums[indextmp[cur2]];
                index[i++]=indextmp[cur2++];
            }else{
                ret[indextmp[cur1]]=right-cur2+1;
                numstmp[i]=nums[indextmp[cur1]];
                index[i++]=indextmp[cur1++];
            }
        }
        while(cur1<=mid) {
            ret[indextmp[cur1]]+=right-cur2+1;
            numstmp[i]=nums[cur1];
            index[i++]=indextmp[cur1++];
        }
        while(cur2<=right) {
            numstmp[i]=nums[cur2];
            index[i++]=indextmp[cur2++];
        }
        //还原数组
        for(int j=left;j<=right;j++) nums[j]=numstmp[j-left];

        //吴小哲的解法，感觉更容易懂一些
        int[] numstmp;
        int[] indextmp;
        int[] ret;
        int[] index;
        public List<Integer> countSmaller(int[] nums) {
            int n=nums.length;
            ret=new int[n];
            index=new int[n];
            numstmp=new int[n];
            indextmp=new int[n];
            for(int i=0;i<n;i++) index[i]=i;
            mergesort(nums,0,n-1);
            List<Integer> list=new ArrayList<>();
            for(int x:ret) list.add(x);
            return list;
        }
        public void mergesort(int[]nums,int left,int right){
            if(left>=right) return ;
            //先排序
            int mid=(left+right)/2;
            mergesort(nums,left,mid);
            mergesort(nums,mid+1,right);

            int cur1=left,cur2=mid+1,i=0;
            while(cur1<=mid&&cur2<=right){//降序：谁大移动谁
                if(nums[cur1]<=nums[cur2]){
                    numstmp[i]=nums[cur2];
                    indextmp[i++]=index[cur2++];
                }else{
                    ret[index[cur1]]+=right-cur2+1;
                    numstmp[i]=nums[cur1];
                    indextmp[i++]=index[cur1++];
                }
            }
            while(cur1<=mid) {
                numstmp[i]=nums[cur1];
                indextmp[i++]=index[cur1++];
            }
            while(cur2<=right) {
                numstmp[i]=nums[cur2];
                indextmp[i++]=index[cur2++];
            }
            //还原数组
            for(int j=left;j<=right;j++) {
                nums[j]=numstmp[j-left];
                index[j]=indextmp[j-left];
            }
        }
    }
}

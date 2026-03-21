/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-01
 * Time: 16:15
 */
class Solution {
    //1539. 第 k 个缺失的正整数
    //解法一：标记数组模拟
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        if(n==0) return k;
        //第一个位置留出来,同时最后一个位置多开个空间，防止索引越界
        boolean[] nums=new boolean[arr[n-1]+1];
        for(int x:arr) nums[x]=true;
        int cnt=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==false) cnt++;
            if(cnt==k) return i;
        }
        //走到这说明答案在数组最大值之后
        //剩下的缺失数是arr[n-1]+1,arr[n-1]+2……
        return arr[n-1]+(k-cnt);
    }

    //解法二：双指针枚举
    public int findKthPositive(int[] arr, int k) {
        int cnt=0;//记录缺失正整数数量
        int last=-1;//记录最后一个缺失的正整数
        int index=0;//数组遍历指针，检查arr中元素
        int cur=1;//当前正在检查的正整数
        for(cnt=0;cnt<k;cur++){
            //及时叫停index,防止检查时越界
            if(cur==arr[index]) index=(index+1<arr.length)?index+1:index;
            else {
                cnt++;
                last=cur;
            }
        }
        return last;
    }


    //解法三：二分查找
    public int findKthPositive(int[] arr, int k) {
        //数组第一个数就>k，说明前k个正整数1~k全缺失
        if(arr[0]>k) return k;
        int left=0,right=arr.length;
        while(left<right){
            int mid=left+(right-left)/2;
            //x：在mid的位置应为的元素值，比如mid=2时，x应为3
            int x=mid<arr.length?arr[mid]:0x3f3f3f3f;
            if(x-(mid+1)<k) left=mid+1;
            else right=mid;
        }
        //此时left=right，共同指向第一个使得缺失数≥k的位置
        return arr[left-1]+k-(arr[left-1]-(left-1+1));
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-18
 * Time: 12:54
 */
class Solution {
    //1089.复写零
    /*给你一个长度固定的整数数组 arr ，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
    注意：请不要在超过该数组长度的位置写入元素。请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
    示例 1：
    输入：arr = [1,0,2,3,0,4,5,0]
    输出：[1,0,0,2,3,0,0,4]
    解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
    示例 2：
    输入：arr = [1,2,3]
    输出：[1,2,3]
    解释：调用函数后，输入的数组将被修改为：[1,2,3]
    提示：
            1 <= arr.length <= 104
            0 <= arr[i] <= 9*/
    public void duplicateZeros(int[] arr) {
        int cur=0,dest=-1,n=arr.length;
        //让cur指向复写的最后一个位置
        while(cur<n){
            if(arr[cur]!=0){
                dest++;
            }
            if(arr[cur]==0)dest+=2;
            if(dest>=n-1)break;
            cur++;
        }
        //处理边界情况
        if(dest==n){
            arr[n-1]=0;
            cur--;
            dest-=2;
        }
        while(cur>=0){
            if(arr[cur]!=0){
                arr[dest--]=arr[cur--];
            }
            if(arr[cur]==0){
                arr[dest--]=0;
                arr[dest--]=0;
                cur--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={1,0,2,3,0,4,5,0};
        new Solution().duplicateZeros(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
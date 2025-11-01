/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-07
 * Time: 23:08
 */
class Solution {
    //LCR170. 数组中逆序对
    /*在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。
    请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
    示例 1：
    输入：record = [9, 7, 5, 4, 6]
    输出：8
    解释：交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。
    提示：
            0 <= record.length <= 50000*/

    //策略一：升序——找出该数前（在cur1中找），有多少个数比我大（cur2）
    int[]tmp;
    public int reversePairs1(int[] nums) {
        tmp=new int[nums.length];
        return mergesort(nums,0,nums.length-1);
    }
    public int mergesort(int[]nums,int left,int right){
        if(left>=right) return 0;
        //取中间值
        int mid=(left+right)/2;
        //排序左右部分
        //[left,mid][mid+1,right]
        int ret=0;
        ret+=mergesort(nums,left,mid);
        ret+=mergesort(nums,mid+1,right);
        int cur1=left,cur2=mid+1,i=0;
        //排序的时候顺便统计一下一左一右的
        while(cur1<=mid&&cur2<=right){
            if(nums[cur1]<=nums[cur2]) tmp[i++]=nums[cur1++];//这里是为了升序排序
            else { ret+=mid-cur1+1;tmp[i++]=nums[cur2++];}
            //这里是第一次cur1>cur2的时候，cur1之后的直接全大于cur2,统计cur1之后的和cur2的数对之后直接排序
            //cur1右边一大堆分别跟不同的cur2组合，虽然这一步重复进入了，但实际统计的是不同的数对
        }
        //处理一下剩下的：不一定只剩下一个
        //那每次取的不是中间值吗？不是的，这不是同一个阶段的事情，那个拆分时期的，但这里是合并（按元素大小）
        while(cur1<=mid) tmp[i++]=nums[cur1++];
        while(cur2<=right) tmp[i++]=nums[cur2++];
        //放回原数组
        for(int j=left;j<=right;j++) nums[j]=tmp[j-left];
        return ret;
    }
    //策略二：降序——找出该数后（在cur2中找），有多少个数比我小（cur1）
    //int[]tmp;
    public int reversePairs2(int[] nums) {
        tmp=new int[nums.length];
        return mergesort(nums,0,nums.length-1);
    }
    public int mergesort2(int[]nums,int left,int right){
        if(left>=right) return 0;
        //取中间值
        int mid=(left+right)/2;
        //排序左右部分
        //[left,mid][mid+1,right]
        int ret=0;
        ret+=mergesort2(nums,left,mid);
        ret+=mergesort2(nums,mid+1,right);
        int cur1=left,cur2=mid+1,i=0;
        //排序的时候顺便统计一下一左一右的
        while(cur1<=mid&&cur2<=right){
            if(nums[cur1]<=nums[cur2]) tmp[i++]=nums[cur2++];//这里是为了升序排序
            else { ret+=right-cur2+1;tmp[i++]=nums[cur1++];}
            //这里是第一次cur1>cur2的时候，cur1直接全大于cur2之后的,统计cur1和cur2之后的数对之后直接排序
            //不同的cur1分别跟cur2右边的一大堆组合，虽然这一步重复进入了，但实际统计的是不同的数对
        }
        //处理一下剩下的：不一定只剩下一个
        //那每次取的不是中间值吗？不是的，这不是同一个阶段的事情，那个拆分时期的，但这里是合并（按元素大小）
        while(cur1<=mid) tmp[i++]=nums[cur1++];
        while(cur2<=right) tmp[i++]=nums[cur2++];
        //放回原数组
        for(int j=left;j<=right;j++) nums[j]=tmp[j-left];
        return ret;
    }
    //总结，i正着填时，升序的话必须是以cur2为基准，让cur1右边一大堆与cur2匹配
    //降序的话必须是以cur1为基准，让cur2右边一大堆与cur1匹配，否则就是i反着填，cur1和cur2的匹配关系也逆转了
    //int[]tmp;
    public int reversePairs3(int[] nums) {
        tmp=new int[nums.length];
        return mergesort(nums,0,nums.length-1);
    }
    public int mergesort3(int[]nums,int left,int right){
        if(left>=right) return 0;
        //先排序
        int mid=(left+right)/2;
        int ret=0;
        //给左右排序，并计算数目
        ret+=mergesort(nums,left,mid);
        ret+=mergesort(nums,mid+1,right);
        //合并，并顺带计算
        //这次我按照图写一个和之前都不同的
        int cur1=mid,cur2=right,i=right-left;
        //正着填不行的原因
// 你之前执着于“从子数组末尾比（cur1=mid、cur2=right）”，但子数组末尾是「最小元素」（比如左[5,3,1]末尾是1），每次比的都是小数，选出来的元素自然是从小到大排，正着填就成了升序（比如tmp[0]=1、tmp[1]=3…），破坏了降序，统计也跟着错。
        while(cur1>=left&&cur2>=mid+1){
            if(nums[cur1]>nums[cur2]) {ret+=cur1-left+1;tmp[i--]=nums[cur2--];}
            else tmp[i--]=nums[cur1--];
        }
        while(cur1>=left) tmp[i--]=nums[cur1--];
        while(cur2>=mid+1) tmp[i--]=nums[cur2--];
        for(int j=left;j<=right;j++) nums[j]=tmp[j-left];
        return ret;
    }
}

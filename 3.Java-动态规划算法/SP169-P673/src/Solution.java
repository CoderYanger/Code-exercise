import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-23
 * Time: 19:38
 */
class Solution {
    //673. 最长递增子序列的个数
    //看完算法原理后对照着笔记写的，一开始用小贪心找返回值时弄错了，注释掉了
    //看完吴小哲写的后改回来的，吴小哲是写在了大循环的第一层循环末尾了
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] len=new int[n];
        int[] count=new int[n];
        Arrays.fill(len,1);
        Arrays.fill(count,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    //如果前面的长度加上这个等于目前的最大长度
                    //当前的计数（1）就加上j前面的最大长度的计数（继续计数）
                    if(len[j]+1==len[i]) count[i]+=count[j];
                        //else if(len[j]+1<len[i]) 无视
                        //有比目前的最大值还大的就更新
                    else if(len[j]+1>len[i]){
                        len[i]=len[j]+1;
                        count[i]=count[j];//接着j的这个计数
                    }
                }
            }
        }
        int maxval=1;int counts=1;
        //这里i从1开始，上面counts就初始化为1，i从0开始，counts就从0开始
        for(int i=1;i<n;i++){
            if(len[i]>maxval){
                maxval=len[i];
                counts=count[i];
            }else if(len[i]==maxval) counts+=count[i];
        }
        /*for(int x:len){
            if(x>maxval){
                maxval=x;
                counts=1;
            }else if(x==maxval) counts++;
        }*/
        return counts;
    }
}
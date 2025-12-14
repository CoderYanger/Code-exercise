/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-12
 * Time: 18:53
 */
class Solution {
    //1262.可被三整除的最大和
    //一开始按算法原理的大框架这么写的，发现一个找数都干到O（N²）了，而且还找不准，于是还是去看吴小哲的了，一遍循环下来，全部解决
    //  sum+=x;
    //     if(sum%3==0) return sum;
    //     else if(sum%3==1){
    //         int x1=0,y1=0,y2=0;
    //         for(int i=0;i<n;i++){
    //             if(nums[i]%3==1) x1=nums[i];
    //             if(nums[i]%3==2) y1=nums[i];
    //             for(int j=i+1;j<n;j++)
    //                 if(y1!=0&&nums[j]%3==2){y2=nums[j];break;}
    //             if
    //         }

    //     }
    public int maxSumDivThree(int[] nums) {
        int INF=0x3f3f3f3f;//因为涉及到减两个数，如果设为整型最大就溢出了
        int sum=0,x1=INF,x2=INF,y1=INF,y2=INF;
        // Arrays.sort(nums);//吴小哲的写法的话就用不到了
        for(int x:nums){
            sum+=x;
            if(x%3==1){
                if(x<x1){x2=x1;x1=x;}
                else if(x<x2) x2=x;
            }else if(x%3==2){
                if(x<y1){y2=y1;y1=x;}
                else if(x<y2) y2=x;
            }
        }
        //分类讨论
        if(sum%3==0) return sum;
        else if(sum%3==1) return Math.max(sum-x1,sum-y1-y2);
        else return Math.max(sum-x1-x2,sum-y1);
    }
}
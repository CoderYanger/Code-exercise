import java.util.List;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-16
 * Time: 23:13
 */
class Solution {
    //2511. 最多可以摧毁的敌人城堡数目
    //自己的暴力求解：两次遍历+List存储1的位置
    //仅仅击败了8.16%的用户
    public int captureForts(int[] nums) {
        int n=nums.length;
        //先获取到可以移动的1的下标
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++) if(nums[i]==1) list.add(i);
        //以各个1为基准，往左右去找可摧毁的最大数量
        int ret=0;
        for(int x:list){
            //先往前找找
            for(int i=x-1;i>=0;i--){
                if(nums[i]==-1){
                    ret=Math.max(ret,x-i-1);//统计0的个数
                    break;
                }
                else if(nums[i]==1) break;
            }
            //再往后找找
            for(int i=x+1;i<n;i++){
                if(nums[i]==-1){
                    ret=Math.max(ret,i-x-1);//统计0的个数
                    break;
                }
                else if(nums[i]==1) break;
            }
        }
        return ret;
    }

    //双指针解法：本质：找相邻的1和-1的最大距离
    //击败100%的用户
    public int captureForts2(int[] nums) {
        int n=nums.length;
        int prev=-1;//记录上一个起点（1）或终点（-1）
        int ret=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1||nums[i]==-1){
                //上一个堡垒存在，且这两个堡垒类型不同（保证只能是1和-1之间）
                if(prev!=-1&&nums[prev]!=nums[i])
                    ret=Math.max(ret,i-prev-1);
                prev=i;//更新堡垒的位置
            }
        }
        return ret;
    }
}

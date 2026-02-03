import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-14
 * Time: 14:48
 */
class Solution {
    //2300. 咒语和药水的成功对数
    //暴力解法
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        int[] pairs=new int[n];
        for(int i=0;i<n;i++){
            int count=0;
            for(int x:potions){
                long tmp=(long)spells[i]*x;
                if(tmp>=success) count++;
            }
            pairs[i]=count;
        }
        return pairs;
    }
    //二分查找优化
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        int[] pairs=new int[n];
        Arrays.sort(potions);
        for(int i=0;i<n;i++){
            int left=0,right=m-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if((long)potions[mid]*spells[i]<success) left=mid+1;
                else right=mid;
            }
            pairs[i]=(long)potions[left]*spells[i]>=success?m-left:0;
        }
        return pairs;
    }
}
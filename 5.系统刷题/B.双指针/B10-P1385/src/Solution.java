/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-16
 * Time: 14:20
 */
class Solution {
    //1385. 两个数组间的距离值
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ret=0;
        for(int i=0;i<arr1.length;i++){
            boolean tmp=true;
            for(int j=0;j<arr2.length;j++){
                if(Math.abs(arr1[i]-arr2[j])<=d){tmp=false;break;}
            }
            if(tmp) ret++;
        }
        return ret;
    }
}
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-23
 * Time: 12:46
 */
class Solution {
    //1552. 两球之间的磁力
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length;
        int left=0,right=position[n-1]-position[0];
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(!check(mid,position,m)) right=mid-1;
            else left=mid;
        }
        return left;
    }
    //判断能否选出k个数，使得任意两个选中的数差值≥mid
    private boolean check(int mid,int[] position,int m){
        int cnt=1;
        int prev=position[0];
        for(int i=1;i<position.length;i++){
            if(position[i]-prev>=mid){
                prev=position[i];
                cnt++;
                if(cnt>=m) return true;
            }
        }
        return cnt>=m;
    }
}
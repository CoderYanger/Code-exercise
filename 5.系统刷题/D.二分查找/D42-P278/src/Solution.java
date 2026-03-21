/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-27
 * Time: 19:17
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    //278. 第一个错误的版本
    public int firstBadVersion(int n) {
        int left=0,right=n;
        while(left<right){
            int mid=left+(right-left)/2;
            if(!isBadVersion(mid)) left=mid+1;
            else right=mid;
        }
        return left;
    }
}
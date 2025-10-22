/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-28
 * Time: 23:41
 */
public class Solution {
    //24. 0〜n-1 中缺失的数字
    /*某班级 n 位同学的学号为 0 ~ n-1。点名结果记录于升序数组 records。假定仅有一位同学缺席，请返回他的学号。
    示例 1：
    输入：records = [0,1,2,3,5]
    输出：4
    示例 2：
    输入：records = [0, 1, 2, 3, 4, 5, 6, 8]
    输出：7
    提示：
            1 <= records.length <= 10000*/
    public int takeAttendance(int[] records) {
        //这里用的模板是求最左端点，方法是让mid在最左端点的左边
        int left=0,right=records.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(records[mid]==mid) left=mid+1;
            else right=mid;
        }
        return records[left]==left?left+1:left;
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-28
 * Time: 12:15
 */
class Solution {
    //100948. 最小全 1 倍数
    public int minAllOneMultiple(int k) {
        if(k%2==0||k%5==0) return -1;
        if(k==1) return 1;
        int ret=1;
        int rem=1;
        while(rem%k!=0){
            rem=(rem*10+1)%k;
            ret++;
            //鸽巢原理：最多循环k次，实际不会走到这，k与10互质必有解
            if(ret>k) return -1;
        }
        return ret;
    }
}

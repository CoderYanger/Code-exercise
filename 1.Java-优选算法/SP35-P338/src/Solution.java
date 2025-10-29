/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-09-02
 * Time: 19:27
 */
class Solution {
    //338. 比特位计数
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            int temp=i;
            while(temp!=0){
                ans[i]++;
                temp&=(temp-1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countBits(2));
    }
}

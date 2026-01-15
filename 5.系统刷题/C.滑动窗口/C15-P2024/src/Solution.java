/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-29
 * Time: 13:25
 */
class Solution {
    //2024. 考试的最大困扰度
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] check=answerKey.toCharArray();
        return Math.max(islegal(check,'F','T',k),islegal(check,'T','F',k));
    }
    private int islegal(char[] check,char need,char all,int k){
        //问题转化：滑动窗口中need的数量<=k
        int n=check.length,ret=0,count=0;
        for(int left=0,right=0;right<n;right++){
            //进窗口
            if(check[right]==need) count++;
            //更新
            if(count<=k) ret=Math.max(ret,right-left+1);
            //出窗口
            while(count>k){
                if(check[left]==need) count--;
                left++;
            }
        }
        return ret;
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-11-09
 * Time: 14:58
 */
class Solution {
    //3723. 数位平方和的最大值
    public String maxSumOfSquares(int num, int sum) {
        if(sum<1||sum>9*num) return "";
        StringBuilder sb=new StringBuilder();
        int remainingSum=sum;
        for(int i=0;i<num;i++){
            int maxDigit=9;
            if(i==0){
                //不能超过剩下的和
                maxDigit=Math.min(9,remainingSum);
                //至少是1
                maxDigit=Math.max(1,maxDigit);
            }else{
                //剩下的位可以从0~9选，尽量选最大
                maxDigit=Math.min(9,remainingSum);
            }
            sb.append(maxDigit);
            remainingSum-=maxDigit;
        }
        return sb.toString();
    }
}
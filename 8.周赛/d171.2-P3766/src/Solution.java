/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-07
 * Time: 10:29
 */
class Solution {
    //3766. 将数字变成二进制回文数的最少操作
    public int[] minOperations(int[] nums) {
        int n=nums.length;
        int[] ret=new int[n];
        for(int i=0;i<n;i++){
            int x=nums[i];
            if(isPalindrome(x)){
                ret[i]=0;
                continue;
            }
            //向左（比它小的）找
            int left=x-1;
            while(!isPalindrome(left)) left--;
            //向右（比它大的）找
            int right=x+1;
            while(!isPalindrome(right)) right++;
            ret[i]=Math.min(x-left,right-x);
        }
        return ret;
    }
    private String conversion(int x){
        StringBuffer sb=new StringBuffer();
        while(x!=0){
            int tmp=x%2;
            sb.append(String.valueOf(tmp));
            x/=2;
        }
        return sb.reverse().toString();
    }
    private boolean isPalindrome(int x){
        String s=conversion(x);
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public int[] minOperations(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int x=nums[i];//当前需要处理的数字
            int ret=0x3f3f3f3f;
            //①计算x的二进制有效位数（去掉前导0后的位数）
            int n=32-Integer.numberOfLeadingZeros(x);
            //②确定二进制回文数的左半部分长度
            // 偶数位：n=4→m=2（左半占2位）；奇数位：n=3→m=1（左半含中间位，占1.5位→取整1）
            int m=n/2;
            //③提取x的二进制左半部分（回文的核心基准）
            // x >> m：将x右移m位，得到二进制左半部分（比如x=5→101，m=1→右移1位→10→十进制2）
            int left=x>>m;
            //④遍历左半部分±1的范围（覆盖最接近x的候选回文数）
            // 仅遍历left-1、left、left+1，因为这三个值构造的回文数最接近x，无需遍历所有可能
            for (int l=left-1;l<=left+ 1;l++) {
                // 跳过负数（左半部分不能为负）
                if (l<0) continue;
                //⑤构造回文数的右半部分
                // n%2：判断二进制位数是否为奇数（奇数为1，偶数为0）
                // l >> (n%2)：奇数位时，去掉左半部分的最后一位（回文中心），再反转；偶数位时直接反转
                // Integer.reverse()：反转int的32位二进制（含前导0）
                // >>> (32 - m)：右移32-m位，去掉反转后多余的前导位，保留m位右半部分
                int right=Integer.reverse(l>>(n%2))>>>(32-m);
                //⑥拼接左半和右半，生成完整的二进制回文数
                // l << m：左半部分左移m位，腾出右半的位置；| right：拼接右半部分
                int pal=l<<m|right;
                //⑦更新最小差值（当前回文数与x的绝对差）
                ret= Math.min(ret, Math.abs(x - pal));
            }
            // 将当前数字的最小操作数存入结果（覆盖原数组）
            nums[i]=ret;
        }
        return nums;
    }
}
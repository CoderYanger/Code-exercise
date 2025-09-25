/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-13
 * Time: 05:48
 */
class Solution {
    // 题目：66. 加一
    /*给定一个表示 大整数 的整数数组 digits，其中 digits[i] 是整数的第 i 位数字。
    这些数字按从左到右，从最高位到最低位排列。这个大整数不包含任何前导 0。
    将大整数加 1，并返回结果的数字数组。
    示例 1：
    输入：digits = [1,2,3]
    输出：[1,2,4]
    解释：输入数组表示数字 123。
    加 1 后得到 123 + 1 = 124。
    因此，结果应该是 [1,2,4]。
    示例 2：
    输入：digits = [4,3,2,1]
    输出：[4,3,2,2]
    解释：输入数组表示数字 4321。
    加 1 后得到 4321 + 1 = 4322。
    因此，结果应该是 [4,3,2,2]。
    示例 3：
    输入：digits = [9]
    输出：[1,0]
    解释：输入数组表示数字 9。
    加 1 得到了 9 + 1 = 10。
    因此，结果应该是 [1,0]。
    提示：
            1 <= digits.length <= 100
            0 <= digits[i] <= 9
    digits 不包含任何前导 0。*/

    //自己写的
    /*public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }else{
                digits[i]=0;
                if(digits[0]!=9){
                    digits[i-1]++;
                }else{
                    int[] newDigits = new int[digits.length+1];
                    int k=i;
                    while(digits[k]==9){
                        newDigits[k--]=0;
                    }
                    newDigits[0]=1;
                    return newDigits;
                }
            }
        }
        if(digits.length==1&&digits[0]==9){
            int[] newDigits = new int[digits.length+1];
            newDigits[0]=1;
            newDigits[1]=0;
            return newDigits;
        }else if(digits.length==1&&digits[0]!=9){
            digits[0]++;
        }
        return digits;
    }*/
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] newdigits=new int[digits.length+1];
        newdigits[0]=1;
        return newdigits;
    }
    public static void main(String[] args) {
        int[] digits = {8,9,9,9};
        int[] ints = new Solution().plusOne(digits);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}

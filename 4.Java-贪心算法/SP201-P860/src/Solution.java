/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-10-29
 * Time: 21:44
 */
class Solution {
    //860. 柠檬水找零
    //看完算法原理自己写的，一遍过
    //跟吴小哲写的一样
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5) five++;
            else if(bills[i]==10){if(five!=0){ten++;five--;}else return false;}
            else if(bills[i]==20){if(ten!=0&&five!=0){ten--;five--;}
            else if(ten==0&&five>=3) five-=3;else return false;}
        }
        return true;
    }
}
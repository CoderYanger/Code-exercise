/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-02-27
 * Time: 19:28
 */
/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    //374. 猜数字大小
    public int guessNumber(int n) {
        int left=0,right=n;
        while(left<right){
            int mid=left+(right-left)/2;
            if(guess(mid)==0) return mid;
            else if(guess(mid)>0) left=mid+1;
            else right=mid;
        }
        return left;
    }
}
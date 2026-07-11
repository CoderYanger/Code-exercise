import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: CoderYanger
 * Date: 2026-06-08
 * Time: 23:41
 */
class Solution {
    //2126. 摧毁小行星
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long sum=mass;
        Arrays.sort(asteroids);
        for(int x:asteroids){
            if(sum<x) return false;
            sum+=x;
        }
        return true;
    }
}
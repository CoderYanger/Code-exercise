/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-04-17
 * Time: 18:33
 */
import java.util.*;
public class Main {
    //最少刷题数
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++) nums[i]=sc.nextInt();
        int[] nums2 =nums.clone();
        Arrays.sort(nums2);
        int mid=nums2[n/2];
        int smaller=0,bigger=0;
        for(int i=0;i<n;i++){
            if(nums[i]<mid) smaller++;
            if(nums[i]>mid) bigger++;
        }
        //对于中位数
        int c1=bigger<=smaller?0:1;
        //对于其他数
        //一个原本<mid的数，提升到mid后，比t小的数量会少1个，因此－1
        int c2=bigger<=(smaller-1)?0:1;
        for (int i=0;i<n;i++){
            //根据是否是中位数，算出最终目标值
            int t=mid+(nums[i]==mid?c1:c2);
            //计算针对当前数要满足bigger<=smaller需要加的最少数
            if(nums[i]>=t) System.out.print(0+" ");
            else System.out.print(t-nums[i]+" ");
        }
        sc.close();
    }
}

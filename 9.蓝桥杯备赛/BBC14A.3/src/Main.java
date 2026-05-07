/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:59
 */
import java.util.*;
public class Main{
    //平均
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=n/10;
        long ret=0;
        List<Integer>[] nums=new ArrayList[10];
        //初始化每个位置为一个空顺序表
        for(int i=0;i<10;i++) nums[i]=new ArrayList<>();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            nums[a].add(b);
        }
        //对数组中的每个顺序表降序排序
        for(int i=0;i<10;i++){
            if(nums[i].size()<=t) continue;
            Collections.sort(nums[i],Collections.reverseOrder());
            for(int j=t;j<nums[i].size();j++) ret+=nums[i].get(j);
        }
        System.out.println(ret);
        sc.close();
    }
}

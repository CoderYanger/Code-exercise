/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-03-29
 * Time: 20:45
 */
import java.util.*;
public class Main{
    //最优分组
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        //记录优k值
        int minK=0x3f3f3f3f;
        double p=sc.nextDouble();
        //记录最小的期望
        double minE=Double.MAX_VALUE;
        //遍历每个能分组的K，倒序遍历能保证最终保留最小的K
        for(int K=N;K>=1;K--){
            //如果能按照K分组
            if(N%K==0){
                //该组不感染：仅需1次
                double P=Math.pow(1-p,K);
                //该组感染：需K+1次
                //期望E=单组期望×总组数
                double E=(P+(1-P)*(K+1))*N/K;
                //该组K=1，修正为1次
                if(K==1) E=N;
                if(E<=minE){
                    minE=E;
                    minK=K;
                }
            }
        }
        System.out.println(minK);
        sc.close();
    }
}

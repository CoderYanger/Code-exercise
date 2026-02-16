import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-03
 * Time: 22:22
 */
class Solution {
    //3625. 统计梯形的数目 II
    public int countTrapezoids2(int[][] points) {
        //自己写的时候的思路：将各个斜率和出现次数存在哈希表里，然后直接算
        //漏点：没考虑共线的情况，也没考虑平行四边形的情况
        int n=points.length,ret=0;
        //哈希表存<斜率，出现次数>
        Map<Double,Integer> hash=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                double k=(double)(points[j][0]-points[i][0])/
                        (double)(points[j][1]-points[i][1]);
                hash.put(k,hash.getOrDefault(k,0)+1);
            }
        }
        int sum=0;//防止重复，保证只×遍历过的边
        for(Map.Entry<Double,Integer> entry:hash.entrySet()){
            double key=entry.getKey();//获取斜率
            int count=entry.getValue();//获取斜率对应次数
            int edges=0;
            if(count>=2){
                //从count里选出2个边，共有count×(count-1)/2种选法
                edges=count*(count-1)/2;
                ret+=sum*edges;
            }
            sum+=count>=2?edges:count;

        }
        return ret;
    }

    public int countTrapezoids(int[][] points) {
        //hash1[k][b]=斜率为k，截距为b的直线上，两点组成的边数
        //作用：同一斜率k->直线平行;不同斜率b->直线不共线
        //从不同（b1,b2）的直线各选一条边，就能组成一组平行对边，构成候选四边形
        Map<Double,Map<Double,Integer>> hash1=new HashMap<>();
        //hash2[mid][k]=中点为mid、斜率为k的边的总数
        //作用：平行四边形的关键特征是一组对边平行且中点相同、长度相等
        //同一mid+同一k下的边，选两条就是平行四边形的一组对边，用于统计平行四边形总数
        //mid：将两点中点坐标(x+y)压缩成int,避免浮点数精度问题（+2000是防止变成负数）
        Map<Integer,Map<Double,Integer>> hash2=new HashMap<>();
        int n=points.length;//点的个数
        //遍历所有两点组成的边（j<i是防止重复统计同一条边）
        for(int i=0;i<n;i++){
            int x1=points[i][0],y1=points[i][1];//第1个点坐标
            for(int j=0;j<i;j++){
                int x2=points[j][0],y2=points[j][1];//第2个点坐标
                //计算两点斜率和截距（y=kx+b）
                int dy=y1-y2;
                int dx=x1-x2;
                double k;
                double b;
                if(dx!=0){//斜率存在
                    k=1.0*dy/dx;//1.0强制浮点数计算
                    //代入直线任意一点(x1,y1)通过y=kx+b计算b，通分避免精度损失
                    b=1.0*(y1*dx-x1*dy)/dx;
                }else{
                    k=Double.MAX_VALUE;//用最大值标记垂直边（唯一标识）
                    b=x1;//垂直边方程是x=常数，用x坐标作为截距标识
                }
                //修正double精度问题：-0.0和0.0逻辑上是同一个值，统一为0.0（避免作为不同key）
                if(k==-0.0) k=0.0;
                if(b==-0.0) b=0.0;
                // 更新hash1：按(斜率k → 截距b)分组，统计每条直线上的边数
                // computeIfAbsent：k不存在则创建新的HashMap，存在则直接获取
                // merge：b对应的计数+1（不存在则设为1）
                //Integer::sum引用Integer类中已存在的静态方法sum，::是引用的意思
                //Integer::new引用Integer(int value)这个构造器
                //HashMap::new引用HashMap()这个无参构造器
                //_是lambda表达式中的占位符，意思是这个参数用不上，但是语法格式必须写
                hash1.computeIfAbsent(k,_->new HashMap<>()).merge(b,1,Integer::sum);
                // 计算边(i,j)的中点坐标，并压缩为int（避免浮点数中点的精度问题）
                // 中点横坐标：(x1+x2)/2，纵坐标：(y1+y2)/2 → 用(x1+x2)和(y1+y2)替代（乘以2不影响中点是否相同）
                // 加2000是为了避免x1+x2或y1+y2为负数（题述坐标范围可能是负数，最小是-2000，
                //因为负数相除可能会和正数冲突），导致压缩后int冲突
                int midXSum = x1 + x2;
                int midYSum = y1 + y2;
                // 压缩为单个int（10000是足够大的系数，避免冲突）
                //因为midXSum最大是4000，起码要×10000才能保证“横和部分”和“纵和部分”在int中不重叠，否则比如
                //当×2000时：a=2,×2000+b=1000=a=1,×2000+b=3000,应为两个结果，但计算结果却相同，导致以为是一个结果
                int mid = (midXSum + 2000) * 10000 + (midYSum + 2000);
                // 更新哈希表2：按(中点mid → 斜率k)分组，统计该组合下的边数
                hash2.computeIfAbsent(mid, _ -> new HashMap<>()).merge(k, 1, Integer::sum);
            }
        }
        int ret=0;
        //第一步：统计所有一组对边平行且不共线的四边形（包含平行四边形）
        //遍历每个斜率k（所有平行直线组）
        for(Map<Double,Integer> line:hash1.values()){
            int sum=0;//累加当前斜率下，之前所有截距对应的边数
            //遍历该斜率下的所有直线（不同截距b，平行且不共线）
            for(int edge:line.values()){
                //组合数：之前遍历过的边数×当前边数，从之前的直线和当前直线各选一条边，组成平行边
                ret+=sum*edge;
                sum+=edge;//累加当前直线的边数，用于后续组合
            }
        }
        //第二步：减去平行四边形的数量（平行四边形有两组平行对边，被第一步统计了两次，需要减一次）
        //遍历每个中点mid(平行四边形对角线中点相同->两平行边中点相同)
        for(Map<Double,Integer> slope:hash2.values()){
            int sum=0;//累加当前中点下，之前所有斜率对应的边数
            //遍历该中点下的所有斜率k
            for(int edge:slope.values()){
                //组合数：之前遍历过的边数×当前边数->同一中点+同一斜率的边，选两条构成平行四边形的对边
                ret-=sum*edge;
                sum+=edge;//累加当前直线的边数，用于后续组合
            }
        }
        //最终数量：纯梯形数量
        return ret;
    }
}
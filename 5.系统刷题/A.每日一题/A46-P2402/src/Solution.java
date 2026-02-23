import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-31
 * Time: 20:55
 */
class Solution {
    //2402. 会议室 III
    public int mostBooked(int n, int[][] m) {
        //将所有会议按时间升序排序
        // Arrays.sort(m,(a,b)->a[0]-b[0]);
        Arrays.sort(m,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        //建小根堆，优先分配编号小的空闲会议室
        PriorityQueue<Integer> id=new PriorityQueue<>();
        //初始化
        for(int i=0;i<n;i++) id.offer(i);
        //正在使用的会议室
        //格式[结束时间，会议室编号]先按结束时间排序，再把会议室编号小的放前面
        //写法一
        // PriorityQueue<long[]> using=new PriorityQueue<>(
        //     (a,b)->a[0]!=b[0]?Long.compare(a[0],b[0]):Long.compare(a[1],b[1])
        // );
        //写法二：
        // PriorityQueue<long[]> using=new PriorityQueue<>(
        //     (a,b)->a[0]!=b[0]?(int)(a[0]-b[0]):(int)(a[1]-b[1])
        // );
        //写法三：
        PriorityQueue<long[]> using=new PriorityQueue<>(
                new Comparator<long[]>(){
                    @Override
                    public int compare(long[] a,long[] b){
                        int tmp=a[0]!=b[0]?1:-1;
                        if(tmp==1) return (int)(a[0]-b[0]);
                        return (int)(a[1]-b[1]);
                    }
                });
        //记录每个会议室被预定的次数，(索引->会议室编号,值->次数)
        int[] count =new int[n];
        //按顺序处理每一场会议
        for(int[] t:m){
            long start=t[0];
            long end=t[1];
            //释放当前会议开始前已经结束的会议室
            //把结束时间<=当前会议开始时间的会议室放回空闲队列
            while(!using.isEmpty()&&using.peek()[0]<=start){
                //弹出已结束的会议室，获取其编号并加入空闲队列
                int roomid=(int)using.poll()[1];
                id.offer(roomid);
            }
            int assign;//分配给当前会议的会议室编号
            //情况1：有空闲会议室
            if(!id.isEmpty()) assign=id.poll();
                //情况2：无空闲会议室->等待最早结束的会议室释放
            else{
                long[] early=using.poll();//弹出最早结束的会议室信息
                long endtime=early[0];//该会议室的结束时间
                int roomid=(int)early[1];//该会议室的编号
                //当前会议需要延时开始，结束时间也同步延
                //延后时长=会议室结束时间-当前会议原开始时间
                end=end+(endtime-start);
                assign=roomid;//分配这个刚释放的会议室
            }
            //将当前会议的结束时间和分配的会议室编号加入正在使用的队列
            using.offer(new long[]{end,assign});
            //该会议室的预定次数+1
            count[assign]++;
        }
        //找出预定次数最多的会议室，次数相同选编号最小的
        int ret=0;
        for(int i=0;i<n;i++) if(count[i]>count[ret]) ret=i;
        return ret;
    }
}
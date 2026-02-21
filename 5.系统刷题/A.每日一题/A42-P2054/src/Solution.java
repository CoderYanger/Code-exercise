import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-23
 * Time: 17:56
 */
class Event implements Comparable<Event>{
    int ts;//事件发生的时间
    int op;//事件类型，开始为0，结束为1
    int val;//事件价值
    //构造方法
    Event(int ts,int op,int val){
        this.ts=ts;
        this.op=op;
        this.val=val;
    }
    @Override
    public int compareTo(Event other){
        //先按时间升序排序
        if(this.ts!=other.ts)
            return Integer.compare(this.ts,other.ts);
        //再按事件开始-结束排序
        return Integer.compare(this.op,other.op);
    }
}
class Solution {
    public int maxTwoEvents(int[][] events) {
        List<Event> evs=new ArrayList<>();
        for(int[] event:events){
            evs.add(new Event(event[0],0,event[2]));
            evs.add(new Event(event[1],1,event[2]));
        }
        Collections.sort(evs);
        int ret=0,prev=0;
        for(Event event:evs){
            //如果该事件结束，就更新prev
            if(event.op==1)
                prev=Math.max(prev,event.val);
                //否则就取前面事件的最大价值+这次事件的价值
            else
                ret=Math.max(ret,prev+event.val);
        }
        return ret;
    }
}


    public int maxTwoEvents(int[][] events) {
        //按照结束时间排序
        Arrays.sort(events,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[1]-o2[1];
            }
        });
        ArrayList<int[]> st=new ArrayList<>();//(结束时间,价值)
        st.add(new int[]{0,0});//处理第一个事件前没有事件的边界
        int ret=0;
        for(int[] e:events){
            //为什么要找e[0]前的？因为当前事件的开始时间是e[0]
            int i=search(st,e[0]);
            int value=e[2];
            ret=Math.max(ret,st.get(i)[1]+value);
            //遇到更大的，追加到最后
            if(value>st.getLast()[1]) st.add(new int[]{e[1],value});
        }
        return ret;
    }
    //求最右端点模型:找到距离目前事件开始的最近的最大价值的事件
    private int search(List<int[]> st,int target){
        int left=0,right=st.size()-1;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(st.get(mid)[0]>=target) right=mid-1;
            else left=mid;
        }
        return left;
    }

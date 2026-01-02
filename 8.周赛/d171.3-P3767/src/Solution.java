import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-12-07
 * Time: 09:54
 */
class Solution {
    //3767. 选择 K 个任务的最大总分数
    //博主一开始写的错误贪心：
    public long maxPoints(int[] t1, int[] t2, int k) {
        //贪心：先遍历每个任务，从两个技巧中挑最大的计入，如果是计划1，就count++;
        //如果最终count<k,就从挑的最大值中挑最小的技巧2换成技巧1
        //如果最终count<k,就从挑的最大值中挑最小的技巧1换成技巧2
        int n=t1.length,count=0,sum=0;
        //<下标，最大值>
        Map<Integer,Integer> hash=new HashMap<>();
        boolean[] mark=new boolean[n];//表示是否是技巧1，是就true
        for(int i=0;i<n;i++){
            int x=t1[i]>=t2[i]?t1[i]:t2[i];
            if(x==t1[i]){
                count++;
                mark[i]=true;
            }
            hash.put(i,x);
            sum+=x;
        }
        if(count==k) return sum;
        //将哈希表的键值对转化为List
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(hash.entrySet());
        //按照值来升序排序
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
            @Override
            public int compare(Map.Entry<Integer,Integer> o1,Map.Entry<Integer,Integer> o2){
                int v=o1.getValue().compareTo(o2.getValue());
                if(v!=0) return v;
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        if(count<k){
            int a=0;
            while(k-count>0&&a<list.size()){
                int i=list.get(a).getKey();
                if(mark[i]==false){
                    sum-=t2[i];
                    sum+=t1[i];
                    count++;
                }
                a++;
            }
        }else if(count>k){
            int a=0;
            while(k-count<0&&a<list.size()){
                int i=list.get(a).getKey();
                if(mark[i]==true){
                    sum-=t1[i];
                    sum+=t2[i];
                    count--;
                }
                a++;
            }
        }
        return sum;
    }

    //在博主原代码修改后的正确贪心：
    public long maxPoints(int[] t1, int[] t2, int k) {
        int n=t1.length,count=0;
        long sum=0;//改动1：改成long防止溢出
        boolean[] mark=new boolean[n];//表示是否是技巧1，是就true
        for(int i=0;i<n;i++){
            int x=t1[i]>=t2[i]?t1[i]:t2[i];
            if(x==t1[i]){
                count++;
                mark[i]=true;
            }
            sum+=x;
        }
        if(count==k) return sum;
        //改动2：移除哈希表，而是按场景收集候选下标
        List<Integer> list=new ArrayList<>();
        if(count<k){
            //收集所有选t2的下标（只有这些能换t1）
            for(int i=0;i<n;i++) if(!mark[i]) list.add(i);
            //改动3：按t1-t2降序排序，优先换增益最大的
            Collections.sort(list,(a,b)->{
                int diff1=t1[a]-t2[a];
                int diff2=t1[b]-t2[b];
                return Integer.compare(diff2,diff1);
            });
        }else if(count>k){
            //收集所有选t1的下标（只有这些能换t2）
            for(int i=0;i<n;i++) if(!mark[i]) list.add(i);
            //改动3：按t1-t2升序排序，优先换损失最小的
            Collections.sort(list,(a,b)->{
                int diff1=t1[a]-t2[a];
                int diff2=t1[b]-t2[b];
                return Integer.compare(diff1,diff2);
            });
        }
        int a=0;
        if(count<k){
            while(k-count>0&&a<list.size()){
                int i=list.get(a);
                if(mark[i]==false){
                    sum-=t2[i];
                    sum+=t1[i];
                    count++;
                }
                a++;
            }
        }else if(count>k){
            while(k-count<0&&a<list.size()){
                int i=list.get(a);
                if(mark[i]==true){
                    sum-=t1[i];
                    sum+=t2[i];
                    count--;
                }
                a++;
            }
        }
        return sum;
    }

    public long maxPoints(int[] t1, int[] t2, int k) {
        //题目保证了k<n所以不存在t1的个数未达到k且diff中的值全<0的情况
        int n=t1.length;
        long ret=0;
        //存储选t2代替t1能赚的点数，就是差值>0的集合
        List<Integer> diff=new ArrayList<>();
        //①先全选t1
        for(int i=0;i<n;i++){
            ret+=t1[i];
            int d=t2[i]-t1[i];
            if(d>0) diff.add(d);
        }
        //②降序排序
        //自然排序（升序）：Collections.naturalOrder();默认就是这个，所以一般都省略
        //逆自然排序（降序）：Collections.reverseOrder()
        diff.sort(Collections.reverseOrder());
        //③确定要替换的数量(t1的数可>k)，避免超量替换+不赚的-->min(n-k,能赚的数量)
        int limit=Math.min(n-k,diff.size());
        //④替换
        for(int i=0;i<limit;i++) ret+=diff.get(i);//加上替换后能赚的
        return ret;
    }
}

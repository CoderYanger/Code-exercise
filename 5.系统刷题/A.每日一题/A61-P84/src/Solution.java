/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-12
 * Time: 21:19
 */
//84. 柱状图中最大的矩形
class Solution {
    //解法一：三次遍历
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        //left[i]:第i个柱子左侧第一个高度小于height[i]的下标
        int[] left=new int[n];
        //单调栈：存储柱子的下标，保证栈内下标对应的高度是单调递增的
        Deque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            //获取当前柱子高度
            int h=heights[i];
            //栈不为空，且栈顶下标对应的柱子高度>=当前柱子高度
            //说明栈顶元素不可能是当前柱子的左侧第一个更矮柱子，弹出
            while(!st.isEmpty()&&heights[st.peek()]>=h) st.pop();
            //栈为空：说明当前柱子左侧没有更矮的柱子，设为边界值-1
            //栈不为空：栈顶下标就是左侧第一个更矮柱子的下标
            left[i]=st.isEmpty()?-1:st.peek();
            //将当前柱子下标压入栈，维持单调递增栈的性质
            st.push(i);
        }
        int[] right=new int[n];
        st.clear();
        for(int i=n-1;i>=0;i--){
            int h=heights[i];
            while(!st.isEmpty()&&heights[st.peek()]>=h) st.pop();
            right[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        int ret=0;
        for(int i=0;i<n;i++){
            //矩形面积=右侧第一个更矮柱子下标-左侧第一个更矮柱子下标-1
            int area=heights[i]*(right[i]-left[i]-1);
            ret=Math.max(ret,area);
        }
        return ret;
    }
}

class Solution {
    //解法二：二次遍历
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] left=new int[n];
        int[] right=new int[n];
        //初始化right数组为n，对应边界
        Arrays.fill(right,n);
        Deque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            int h=heights[i];
            //栈顶柱子高度>=当前柱子高度时
            //说明当前i就是栈顶柱子的右侧第一个更矮柱子下标
            while(!st.isEmpty()&&heights[st.peek()]>=h)
                right[st.pop()]=i;
            left[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        int ret=0;
        for(int i=0;i<n;i++)
            ret=Math.max(ret,heights[i]*(right[i]-left[i]-1));
        return ret;
    }
}

class Solution {
    //解法三：一次遍历
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Deque<Integer> st=new ArrayDeque<>();
        //当栈中只有一个数的时候，栈顶下面的数是-1，对应left[i]=-1的情况
        st.push(-1);
        int ret=0;
        //遍历范围[0,n]:n是right的边界，对应right=n的情况
        for(int right=0;right<=n;right++){
            int h=right<n?heights[right]:-1;
            //st.size()>1的作用跟之前的!st.isEmpty()一样，都是保证栈内除了-1还有其他有效元素
            //这里要>1是因为，一开始我们往里面扔了个-1来保证只有一个元素时得到正确结果
            while(st.size()>1&&heights[st.peek()]>=h){
                //弹出栈顶元素i：这是当前要计算面积的柱子下标
                int i=st.pop();
                //弹出后的栈顶就是i紧接着左侧的第一个更矮柱子下标
                int left=st.peek();
                ret=Math.max(ret,heights[i]*(right-left-1));
            }
            //将当前right压入栈，维持栈的单调递增性质
            //因为此时咱们的基准柱子变成了从栈中弹出来的柱子，比基准柱子小的两个都去当left和right了，比它大的才放进去，所以是递增的
            st.push(right);
        }
        return ret;
    }
}

class Solution {
    //解法三的数组写法
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] st=new int[n+1];
        //当栈中只有一个数的时候，栈顶下面的数是-1，对应left[i]=-1的情况
        int top=-1;//记录栈顶下标，初始为-1表示栈为空
        //初始化栈底为-1，对应left=-1的情况
        st[++top]=-1;
        int ret=0;
        //遍历范围[0,n]:n是right的边界，对应right=n的情况
        for(int right=0;right<=n;right++){
            int h=right<n?heights[right]:-1;
            //top>0:保证栈内除了-1还有有效元素
            while(top>0&&heights[st[top]]>=h){
                //弹出栈顶元素i：这是当前要计算面积的柱子下标
                int i=st[top--];
                //弹出后的栈顶就是i紧接着左侧的第一个更矮柱子下标
                int left=st[top];
                ret=Math.max(ret,heights[i]*(right-left-1));
            }
            //将当前right压入栈，维持栈的单调递增性质
            //因为此时咱们的基准柱子变成了从栈中弹出来的柱子，比基准柱子小的两个都去当left和right了，比它大的才放进去，所以是递增的
            st[++top]=right;
        }
        return ret;
    }
}
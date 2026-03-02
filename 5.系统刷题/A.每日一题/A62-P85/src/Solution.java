/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2026-01-12
 * Time: 22:34
 */
class Solution {
    //85. 最大矩形
    public int maximalRectangle(char[][] matrix) {
        int n=matrix[0].length;
        //这里申请n+1个空间大小，是因为84题的代码涉及到了right=n的情况，为了避免越界访问，所以初始化成为n+1
        //实际上初始化成n也可以，因为right=n时会直接赋值h=-1，完全不访问height[n]
        int[] heights=new int[n+1];
        int ret=0;
        for(char[] row:matrix){
            //计算底边为row的柱子高度
            for(int j=0;j<n;j++){
                if(row[j]=='0') heights[j]=0;
                else heights[j]++;
            }
            //直接调用84题代码
            ret=Math.max(ret,largestRectangleArea(heights));
        }
        return ret;
    }
    //直接把84题的代码原封不动搬过来用
    private int largestRectangleArea(int[] heights) {
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
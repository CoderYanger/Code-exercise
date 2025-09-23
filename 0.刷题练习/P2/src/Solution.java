/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王洋
 * Date: 2025-08-01
 * Time: 12:16
 */

import java.util.Scanner;

// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
 class ListNode{
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
class Solution {
     //2.两数相加
    /*给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    请你将两个数相加，并以相同形式返回一个表示和的链表。
    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    示例 1：
    输入：l1 = [2,4,3], l2 = [5,6,4]
    输出：[7,0,8]
    解释：342 + 465 = 807.
    示例 2：
    输入：l1 = [0], l2 = [0]
    输出：[0]
    示例 3：
    输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    输出：[8,9,9,9,0,0,0,1]
    提示：
    每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
    题目数据保证列表表示的数字不含前导零*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();//哑节点
        ListNode curr= dummy;
        int carry=0;//进位
        //遍历两个链表，处理所有节点和进位
        while(l1!=null||l2!=null||carry>0){
            //取当前节点值（为空则取0）
            int val1=(l1!=null)?l1.val:0;
            int val2=(l2!=null)?l2.val:0;
            //计算当前位总和（含进位）
            int total=val1+val2+carry;
            carry=total/10;//新进位
            int currentVal=total%10;//当前位结果
            //创建新节点
            curr.next=new ListNode(currentVal);
            curr=curr.next;
            //移动到下一个节点
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return dummy.next;
    }
    // //数组逆序
    // public static int[]Reverse(int[] nums){
    //     // int start=numd[0];
    //     int start=0;//用索引，不是元素值
    //     // int end=nums[digit-1];
    //     int end =nums.length-1;
    //     // while(start!=end){
    //     while(start<end){//条件改为start<end（避免相等时死循环）
    //     //直接交换数组元素（不用单独的swap方法，因为swap方法值交换无效）
    //         // Soluton.swap(start,end);
    //         int temp=nums[start];
    //         nums[start]=nums[end];
    //         nums[end]=temp;
    //         start++;
    //         end--;
    //     }
    //     return nums;
    // }
    // //整数转化为逆序数组
    // public static int[] Conversion(int num,int digit){
    //     // int[]nums=new int[digit-1];
    //     int[]nums=new int[digit];//长度应为digit，原digit-1错误
    //     // int g=l;
    //     // while(digit!=0){
    //     //     g%=10;
    //     //     nums[--digit]=g;
    //     // }
    //     // return Solution.Reverse(nums,digit);
    //     for(int i=0;i<digit;i++){
    //         nums[i]=num%10;//直接取末位，本身就是逆序，无需后续再反转
    //         num=num/10;
    //     }
    //     return nums;
    // }
    // //数组转化为整数
    // public static int transform(int[]num){
    //     // int n=num[0];
    //     // if(digit=1){
    //     //     return n;
    //     // }else{
    //     //     for(int i=1;i<digit;i++){
    //     //         n+=num[i]*10;
    //     //     }
    //     //     return n;
    //     // }
    //     int result=0;
    //     for(int i=0;i<num.length;i++){
    //         //数组是逆序（如[2,4,3]对应342），需乘以10的幂次还原
    //         result+=num[i]*(int)Math.pow(10,i);
    //     }
    //     return result;
    // }
    // public static void main(String[]args){
    //     Scanner sc = new Scanner(System.in);

    //     System.out.println("请输入l1的位数：");
    //     int digit1=sc.nextInt();
    //     System.out.println("请输入l1的值：");
    //     int l1=sc.nextInt();
    //     int[] nums1=Conversion(l1,digit1);//转为逆序数组（如342——>[2,4,3]）
    //     // int n1=Solution.transform(nums1,digit1);

    //     System.out.println("请输入l2的位数：");
    //     int digit2=sc.nextInt();
    //     System.out.println("请输入l2的值：");
    //     int l2=sc.nextInt();
    //     //将l2转为逆序数组
    //     int[] nums2=Conversion(l2,digit2);
    //     // // 将数组转为整数
    //     // int n2=Solution.transform(nums2,digit2);
    //     // int add=n1+n2;

    //     //计算两数之和
    //     int sum=transform(nums1)+transform(nums2);

    //     // //求add的长度
    //     // int length=0;
    //     // double temp=(double)add;
    //     // while(true){
    //     //     temp/=10;
    //     //     double di =temp%10;
    //     //     if(di==0.0){
    //     //         break;
    //     //     }
    //     //     length++;
    //     // }
    //     // int[]nums3=Solution.Conversion(add,length);

    //     //求sum的位数（修正原逻辑错误）
    //     int sumDigit=String.valueOf(sum).length();//用字符串长度更简单
    //     int[]sumNums=Conversion(sum,sumDigit);//转为逆序数组
    //     // //将数组转化为链表
    //     // for(int k=0;k<nums3.length;k++){
    //     //     ListNode.val=nums3[k];
    //     //     if(k+1>=nums3.length){
    //     //         ListNode.next=null;
    //     //     }
    //     //     ListNode.next=nums3[k+1];
    //     // }
    //     // return ListNode;

    //     //将sumNums转为链表（核心修正：正确创建链表节点）
    //     ListNode dummy=new ListNode();//哑节点，简化头节点处理
    //     ListNode curr=dummy;
    //     for(int num:sumNums){
    //         curr.next=new ListNode(num);//新建节点
    //         curr=curr.next;//移动指针
    //     }
    //     ListNode result=dummy.next;//结果为哨兵节点的下一个（实际头节点）
    //     //打印结果链表
    //     System.out.println("结果链表:[");
    //     while(result!=null){
    //         System.out.print(result.val);
    //         if(result.next!=null)
    //         System.out.print(",");
    //     }
    //     System.out.println("]");
    //     sc.close();
    // }
}
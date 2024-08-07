package easy.to1000;

import structure.ListNode;

public class Solution206 {

	/**
	 * v3.0
	 * 建立新节点，头插法
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if(head==null) {
			return null;
		}
		ListNode node = head;
		ListNode res = null;
		while(node!=null) {
			res = new ListNode(node.val, res);
			node = node.next;
		}
		return res;
	}
	
	/**
	 * v2
	 * 递归
	 * @param head
	 * @return
	 */
	public ListNode reverseList2(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode res = reverseList2(head.next);
		head.next.next=head;
		head.next=null;
		return res;
	}
	
	/**
	 * v1
	 * 循环
	 * 记录上一个节点
	 * @param head
	 * @return
	 */
	public ListNode reverseList1(ListNode head) {
		if(head==null) {
			return null;
		}
		ListNode pre=null;
		ListNode node = head;
		while(node!=null) {
			ListNode next = node.next;
			node.next=pre;
			pre=node;
			node=next;
		}
		return pre;
	}
}

package medium.to100;

import structure.ListNode;

public class Solution24 {

	/**
	 * v2.0
	 * 迭代
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode dump = new ListNode();
		dump.next = head;
		ListNode p = dump;
		while(p!=null && p.next!=null && p.next.next!=null) {
			ListNode temp = p.next;
			p.next = p.next.next;
			temp.next = p.next.next;
			p.next.next = temp;
			p = temp;
		}
		return dump.next;
	}
	
	/**
	 * v1.0
	 * 递归
	 * @param head
	 * @return
	 */
	public ListNode swapPairs1(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode p = head;
		ListNode next = p.next;
		ListNode temp = p.next.next;
		next.next = p;
		p.next = swapPairs1(temp);
		return next;
	}
	
}

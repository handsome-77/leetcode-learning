package medium.to100;

import structure.ListNode;

public class Solution19 {

	/**
	 * v1.0
	 * 双指针，移位
	 * 慢指针指向要删除结点的前一个结点
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode ps = head;
		ListNode pf = head;
//		移位
		while(n>0) {
			pf=pf.next;
			n--;
		}
//		当快指针到null，说明移除的是第一个结点
		if(pf==null) {
			return head.next;
		}
//		让快指针遍历到最后一个结点，慢指针同步遍历，最后慢指针指向要删除结点的前一个结点
		while(pf.next!=null) {
			pf=pf.next;
			ps=ps.next;
		}
//		删除结点
		ps.next=ps.next.next;
		return head;
	}
}

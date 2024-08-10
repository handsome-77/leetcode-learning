package hard.to100;

import structure.ListNode;

public class Solution25 {

	/**
	 * v1.0
	 * 反转，记录上一个结点
	 * 递归
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		int kCopy = k;
		ListNode p = head;
//		根据k的大小和链表长度，判断是否需要反转，不需要反转则直接返回head
		while(kCopy>0) {
			if(p==null) {
				return head;
			}
			p=p.next;
			kCopy--;
		}
//		反转链表中的前k个结点，记录上一个结点（Solution206）
		ListNode pre = null;
		p = head;
		kCopy = k;
		ListNode next = p.next;
		while(p!=null && kCopy>0) {
			next = p.next;
			p.next = pre;
			pre = p;
			p = next;
			kCopy--;
		}
//		将head，即反转后链表的最后一个结点的next指向下一组反转链表
		head.next = reverseKGroup(next, k);
		return pre;
	}
}

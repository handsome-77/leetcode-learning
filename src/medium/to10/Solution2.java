package medium.to10;

import structure.ListNode;

public class Solution2 {

	/**
	 * v2.0
	 * 遍历，简化
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = new ListNode();
		ListNode tail = res;
		boolean flag = false;
//		遍历链表
		while(l1!=null || l2!=null) {
			int sum = (l1!=null ? l1.val:0) + (l2!=null ? l2.val:0);
			if(flag) {
				sum++;
			}
			flag = sum<10 ? false : true;
			sum %= 10;
			tail.next = new ListNode(sum);
			tail=tail.next;
			l1=(l1!=null ? l1.next:null);
			l2=(l2!=null ? l2.next:null);
		}
//		若还有进位，加一
		if(flag) {
			tail.next = new ListNode(1);
			tail=tail.next;
		}
		return res.next;
	}
	
	/**
	 * v1.0
	 * 遍历
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		ListNode res = new ListNode();
		ListNode tail = res;
		boolean flag = false;
//		遍历共同部分
		while(l1!=null && l2!=null) {
			int sum = l1.val+l2.val;
			if(flag) {
				sum++;
			}
			flag = sum<10 ? false : true;
			sum %= 10;
			tail.next = new ListNode(sum);
			tail=tail.next;
			l1=l1.next;
			l2=l2.next;
		}
//		遍历剩余部分
		while(l1!=null) {
			int sum = l1.val;
			if(flag) {
				sum++;
			}
			flag = sum<10 ? false : true;
			sum %= 10;
			tail.next = new ListNode(sum);
			tail=tail.next;
			l1=l1.next;
		}
//		遍历剩余部分
		while(l2!=null) {
			int sum = l2.val;
			if(flag) {
				sum++;
			}
			flag = sum<10 ? false : true;
			sum %= 10;
			tail.next = new ListNode(sum);
			tail=tail.next;
			l2=l2.next;
		}
//		若还有进位，加一
		if(flag) {
			tail.next = new ListNode(1);
			tail=tail.next;
		}
		return res.next;
	}
}

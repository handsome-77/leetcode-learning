package medium.to1000;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import structure.ListNode;

public class Solution148 {
	
	/**
	 * v2.0
	 * 归并，递归，自顶向下
	 * @param head
	 * @return
	 */
	public ListNode sortList(ListNode head) {
		return sortAndMerge(head, null);
	}
	public ListNode sortAndMerge(ListNode head, ListNode tail) {
		if(head==null) {
			return head;
		}
		if(head.next == tail) {
			head.next = null;
			return head;
		}
		ListNode ps = head;
		ListNode pf = head;
		while(pf!=tail) {
			ps = ps.next;
			pf = pf.next;
			if(pf!=tail) {
				pf = pf.next;
			}
		}
		ListNode mid = ps;
		ListNode list1 = sortAndMerge(head, mid);
		ListNode list2 = sortAndMerge(mid, tail);
		
		ListNode dump = new ListNode();
		ListNode temp = dump;
		while(list1!=null && list2!=null) {
			if(list1.val < list2.val) {
				temp.next = list1;
				list1 = list1.next;
			}else {
				temp.next = list2;
				list2 = list2.next;
			}
			temp = temp.next;
		}
		if(list1!=null) {
			temp.next = list1;
		}
		if(list2!=null) {
			temp.next = list2;
		}
		return dump.next;
	}
	
	/**
	 * v1.0
	 * 优先级队列
	 * @param head
	 * @return
	 */
	 public ListNode sortList1(ListNode head) {
		 Queue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
		});
		 ListNode p = head;
		 while(p!=null) {
			 queue.offer(p);
			 p = p.next;
		 }
		 ListNode res = queue.poll();
		 p = res;
		 while(!queue.isEmpty()) {
			 p.next = queue.poll();
			 p = p.next;
		 }
		 return res;
	 }
}

package hard.to100;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import structure.ListNode;

public class Solution23 {
	
	/**
	 * v3.0
	 * 优先级队列
	 * 入队链表中的每个头结点，取出后再入队下一个结点
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		Queue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
		});
		
		for(ListNode node : lists) {
			if(node!=null) {
				queue.offer(node);
			}
		}
		ListNode dump = new ListNode();
		ListNode cur = dump;
		while(!queue.isEmpty()) {
			cur.next = queue.poll();
			cur = cur.next;
			if(cur.next!=null) {
				queue.offer(cur.next);
			}
		}
		return dump.next;
	}
	
	/**
	 * v2.0
	 * 分治合并
	 */
    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		if(a == null) {
			return b;
		}
		if(b == null) {
			return a;
		}
		ListNode head = new ListNode();
		ListNode tail = head;
		ListNode pa = a, pb = b;
		
		while(pa!=null && pb!=null) {
			if(pa.val < pb.val) {
				tail.next = pa;
				pa = pa.next;
			}else {
				tail.next = pb;
				pb = pb.next;
			}
			tail = tail.next;
		}
		
		if(pa!=null) {
			tail.next = pa;
		}
		
		if(pb!=null) {
			tail.next = pb;
		}
		return head.next;
	}
	
	/**
	 * v1.0
	 * 顺序合并
	 */
	public ListNode mergeKLists1(ListNode[] lists) {
		int len = lists.length;
		if(len == 0) {
			return null;
		}
		ListNode res = lists[0];
		for(int i=1; i<len; i++) {
			res = mergeTwoLists(res, lists[i]);
		}
		return res;
		
	}
	public ListNode mergeTwoLists1(ListNode a, ListNode b) {
		if(a == null) {
			return b;
		}
		if(b == null) {
			return a;
		}
		ListNode head = new ListNode();
		ListNode tail = head;
		ListNode pa = a, pb = b;
		
		while(pa!=null && pb!=null) {
			if(pa.val < pb.val) {
				tail.next = pa;
				pa = pa.next;
			}else {
				tail.next = pb;
				pb = pb.next;
			}
			tail = tail.next;
		}
		
		if(pa!=null) {
			tail.next = pa;
		}
		
		if(pb!=null) {
			tail.next = pb;
		}
		return head.next;
	}

	public static void main(String[] args) {		

	}

}

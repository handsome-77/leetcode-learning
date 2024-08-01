package hard.to100;

public class Solution23 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	/**
	 * v2.0
	 * 分治合并
	 */
    public ListNode mergeKLists(ListNode[] lists) {
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

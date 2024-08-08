package easy.to1000;

import structure.ListNode;

public class Solution142 {

	/**
	 * 快慢指针
	 * 相遇后，快指针指向头结点，一步一步走，下次与慢指针相遇即环入口
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {

		if(head==null) {
			return null;
		}
		ListNode pf = head.next;
		ListNode ps = head;
		while(pf!=null && pf.next!=null) {
			if(pf==ps) {
				pf=head;
				ps=ps.next;
				break;
			}
			pf=pf.next.next;
			ps=ps.next;
		}
		while(pf!=null) {
			if(ps==pf) {
				return ps;
			}
			ps=ps.next;
			pf=pf.next;
		}
		return null;
	}
}

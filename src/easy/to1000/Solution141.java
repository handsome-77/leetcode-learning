package easy.to1000;

import structure.ListNode;

public class Solution141 {

	/**
	 * 快慢指针
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		if(head==null) {
			return false;
		}
		ListNode pf = head.next;
		ListNode ps = head;
		while(pf!=null && pf.next!=null) {
			if(pf==ps) {
				return true;
			}
			pf=pf.next.next;
			ps=ps.next;
		}
		return false;
	}
}

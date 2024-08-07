package easy.to1000;

import java.util.HashSet;

import structure.ListNode;

public class Solution160 {

	/**
	 * v2.0
	 * 时间复杂度：O(m+n)
	 * 空间复杂度：O(1)
	 * 双指针
	 * 当有一个指针指向null时，该指针指向另一链表的head
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode pa = headA;
		ListNode pb = headB;
		while(true) {
			if(pa==pb) {
				return pa;
			}
			pa=(pa==null ? headB:pa.next);
			pb=(pb==null ? headA:pb.next);
		}
	}
	
	/**
	 * v1.0
	 * 时间复杂度：O(m+n)
	 * 空间复杂度：O(m+n)
	 * set判断是否在集合内
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		ListNode pa = headA;
		ListNode pb = headB;
		HashSet<ListNode> set = new HashSet<ListNode>();
		while(pa!=null && pb!=null) {
			if(set.contains(pa)) {
				return pa;
			}
			set.add(pa);
			if(set.contains(pb)) {
				return pb;
			}	
			set.add(pb);
			pa = pa.next;
			pb = pb.next;
		}
		while(pa!=null) {
			if(set.contains(pa)) {
				return pa;
			}
			pa = pa.next;
		}
		while(pb!=null) {
			if(set.contains(pb)) {
				return pb;
			}
			pb = pb.next;
		}
		return null;
	}
	
}

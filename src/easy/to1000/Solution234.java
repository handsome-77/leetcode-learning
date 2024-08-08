package easy.to1000;

import structure.ListNode;

public class Solution234 {

	/**
	 * v2.0
	 * 优化
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * 快慢指针
	 * 翻转后半部分链表，不采用头插法，原地翻转
	 * 为保持链表不改变，翻转判断后需要复原
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
//		找中点
		ListNode pf = head;
		ListNode ps = head;
		while(pf!=null && pf.next!=null) {
			pf=pf.next.next;
			ps=ps.next;
		}
		ListNode mid = ps;
		
//		翻转后半部分链表
		ListNode pre = null;
		ListNode cur = mid;
		while(cur!=null) {
			ListNode temp = cur.next;
			cur.next=pre;
			pre=cur;
			cur=temp;
		}
		
//		判断
		ListNode rev = pre;
		ListNode p = head;
		boolean result = true;
		while(result && rev!=null) {
			if(rev.val != p.val) {
				result=false;
			}
			rev = rev.next;
			p = p.next;
		}
		
		cur = pre;
		pre = null;
		while(cur!=null) {
			ListNode temp = cur.next;
			cur.next=pre;
			pre=cur;
			cur=temp;
		}
		
		return result;
	}

	
	/**
	 * v1.0
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * 快慢指针
	 * 快指针遍历到尾的时候，慢指针遍历到中点
	 * 对链表的后半部分翻转（头插法），再对原链表的前半部分和翻转后的链表比较
	 * @param head
	 * @return
	 */
	public boolean isPalindrome1(ListNode head) {
		ListNode pf = head;
		ListNode ps = head;
		while(pf!=null && pf.next!=null) {
			pf=pf.next.next;
			ps=ps.next;
		}
		ListNode revList = null;
		while(ps!=null) {
			revList = new ListNode(ps.val, revList);
			ps=ps.next;
		}
		ListNode p = head;
		while(revList!=null) {
			if(p.val!=revList.val) {
				return false;
			}
			p=p.next;
			revList=revList.next;
		}
		return true;
	}
}

package easy.to100;

import structure.ListNode;

public class Solution21 {

	/**
	 * v1.0
	 * 尾插法，先全部遍历比较插入，剩下的接在tail之后
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode p1 = list1;
		ListNode p2 = list2;
//		尾插法，新建空结点，tail一直指向最后一个结点
		ListNode res = new ListNode();
		ListNode tail = res;
		while(p1!=null && p2!=null) {
			if(p1.val<p2.val) {
//				尾结点next指向新结点
				tail.next = p1;
//				更新tail指向
				tail=p1;
				p1=p1.next;
			}else {
				tail.next=p2;
				tail=p2;
				p2=p2.next;
			}
		}
		if(p1!=null) {
			tail.next=p1;
		}
		if(p2!=null) {
			tail.next=p2;
		}
		return res.next;
	}
}

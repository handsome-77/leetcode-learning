package medium.to1000;

import java.util.HashMap;
import java.util.Map;

import structure.Node;

public class Solution138 {
	
	/**
	 * v2.0
	 * 哈希表，迭代
	 * @param head
	 * @return
	 */
	public Node copyRandomList(Node head) {
		Map<Node, Node> map = new HashMap<Node, Node>();
		Node p = head;
		while(p!=null) {
			map.put(p, new Node(p.val));
			p = p.next;
		}
		p = head;
		while(p!=null) {
			map.get(p).next = map.get(p.next);
			map.get(p).random = map.get(p.random);
			p = p.next;
		}
		return map.get(head);
	}
	
	/**
	 * v1.0
	 * @param head
	 * @return
	 * 哈希表、递归
	 */
	Map<Node, Node> map = new HashMap<>();
	public Node copyRandomList1(Node head) {
		if(head==null) {
			return head;
		}
		while(!map.containsKey(head)) {
			Node newNode = new Node(head.val);
			map.put(head, newNode);
			newNode.next = copyRandomList(head.next);
			newNode.random = copyRandomList(head.random);
		}
		return map.get(head);
	}
}

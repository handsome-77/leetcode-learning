package medium.to1000;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution146 {

	/**
	 * v2.0
	 * LRU缓存
	 * HashMap存储缓存，定义双向链表存储加入顺序
	 * 定义空头结点、空尾结点，以省去非空指针判断
	 */
	class LRUCache {
//		定义链表结构
		class LinkNode {
			int key;
			int value;
			LinkNode pre;
			LinkNode next;
//			构造方法
			public LinkNode() {
			}
			public LinkNode(int key, int value) {
				super();
				this.key = key;
				this.value = value;
			}
		}

		int capacity;
		LinkNode head, tail;
		Map<Integer, LinkNode> cache;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			this.head = new LinkNode();
			this.tail = new LinkNode();
			head.next = tail;
			tail.pre = head;
			this.cache = new HashMap<>();
		}
		
		public void put(int key, int value) {
			LinkNode getNode = cache.get(key);
			if(getNode != null) {
				getNode.value = value;
//				移除Node
				getNode.next.pre = getNode.pre;
				getNode.pre.next = getNode.next;
//				将node加到队尾
				getNode.next = tail;
				getNode.pre = tail.pre;
				tail.pre.next = getNode;
				tail.pre = getNode;
				cache.put(key, getNode);
				return;
			}
			
			if(cache.size() >= capacity) {
				cache.remove(head.next.key);
				head.next.pre = null;
				head.next = head.next.next;
				head.next.pre.next = null;
				head.next.pre = head;
			}
			LinkNode putNode = new LinkNode(key, value);
			putNode.next = tail;
			putNode.pre = tail.pre;
			tail.pre.next = putNode;
			tail.pre = putNode;
			cache.put(key, putNode);
		}
		

		public int get(int key) {
//			从哈希表中根据key获取LinkNode
			LinkNode getNode = cache.get(key);
//			没有该key，则返回-1
			if(getNode == null) {
				return -1;
			}
			
//			getNode不为空，即有该key
//			先将该node从链表原位置移除
			getNode.next.pre = getNode.pre;
			getNode.pre.next = getNode.next;
//			再将该node移到队尾
			getNode.next = tail;
			getNode.pre = tail.pre;
			tail.pre.next = getNode;
			tail.pre = getNode;
			return getNode.value;

		}
	}
	
		
	/**
	 * v1.0
	 * LRU缓存
	 * LinkedList+HashMap，性能较差
	 */
	public class LRUCache1{
		int capacity;
		LinkedList<Integer> cache; 
		Map<Integer, Integer> cacheMap;

		public LRUCache1(int capacity) {
			this.capacity = capacity;
			this.cache = new LinkedList<>();
			this.cacheMap = new HashMap<>();
		}
		
		public int get(int key) {
			if(!cacheMap.containsKey(key)) {
				return -1;
			}
			cache.remove(Integer.valueOf(key));
			cache.add(Integer.valueOf(key));
			return cacheMap.get(key);
		}
		
		public void put(int key, int value) {
			if(cacheMap.containsKey(key)) {
				cacheMap.put(key, value);
				cache.remove(Integer.valueOf(key));
				cache.add(Integer.valueOf(key));
				return;
			}
			if(cache.size() == capacity) {
				int pollKey = cache.poll();
				cacheMap.remove(pollKey);
			}
			cache.add(Integer.valueOf(key));
			cacheMap.put(key, value);
		}
		
	}
	
	public static void main(String[] args) {
		LRUCache lRUCache = new Solution146().new LRUCache(1);
		lRUCache.get(6);
		lRUCache.get(8);
		lRUCache.put(12, 1);
		lRUCache.get(2);
		lRUCache.put(15, 11);
		lRUCache.put(5, 2);
		lRUCache.put(1, 15);
		lRUCache.put(4, 2);
		lRUCache.get(5);
		lRUCache.put(15, 15);

	}

}

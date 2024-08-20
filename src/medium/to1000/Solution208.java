package medium.to1000;

public class Solution208 {

	/**
	 * v1.0
	 * 前缀树，字典树
	 */
	class Trie {

		Trie[] children;
		boolean isEnd;
		
	    public Trie() {
	    	children = new Trie[26];
	    	isEnd = false;
	    }
	    
	    public void insert(String word) {
	    	Trie node = this;
	    	for(int i=0; i<word.length(); i++) {
	    		char c = word.charAt(i);
	    		int index = c-'a';
	    		if(node.children[index]==null) {
	    			node.children[index] = new Trie();
	    		}
	    		node = node.children[index];
	    	}
	    	node.isEnd = true;
	    }
	    
	    public boolean search(String word) {
	    	Trie node = searchPrefix(word);
	    	return node!=null && node.isEnd;
	    }
	    
	    public boolean startsWith(String prefix) {
	    	return searchPrefix(prefix)!=null;
	    }
	    
	    public Trie searchPrefix(String prefix) {
	    	Trie node = this;
	    	for(int i=0; i<prefix.length(); i++) {
	    		char c = prefix.charAt(i);
	    		int index = c-'a';
	    		if(node.children[index]==null) {
	    			return null;
	    		}
	    		node=node.children[index];
	    	}
	    	return node;
	    }
	}
}

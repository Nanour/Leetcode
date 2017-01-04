// Sourse : https://leetcode.com/problems/lru-cache/
// Date   : 2016-12-29

/***********************************************************************
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key 
 * exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already 
 * present. When the cache reached its capacity, it should invalidate the 
 * least recently used item before inserting a new item.
 * 
 ***********************************************************************/

public class LRUCache {
    Map<Integer, DLinkedListNode> hm = new HashMap<Integer, DLinkedListNode>();
    private int capacity;
    private int count;
    private DLinkedListNode head;
    private DLinkedListNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        
        this.head = new DLinkedListNode();
        head.pre = null;
        
        this.tail = new DLinkedListNode();
        tail.post = null;
        
        head.post = tail;
        tail.pre = head;
    }
    
    private void moveToHead(int key) {
        removeNode(key);
        addNodeToHead(key);
    }
    
    private void addNodeToHead(int key) {
        DLinkedListNode node = hm.get(key);
        
        node.pre = head;
        node.post = head.post;
        
        head.post.pre = node;
        head.post = node;
    }
    
    private void removeNode(int key) {
        DLinkedListNode node = hm.get(key);
        
        DLinkedListNode pre = node.pre;
	    DLinkedListNode post = node.post;
	
	    pre.post = post;
        post.pre = pre;
    }
    
    private DLinkedListNode popTail(){
        DLinkedListNode temp = tail.pre;
        removeNode(temp.key);
        return temp;
    }
    
    public int get(int key) {
        DLinkedListNode curr = hm.get(key);
        if (curr != null) {
            moveToHead(key);
            return curr.val;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        DLinkedListNode curr = hm.get(key);
        if (curr == null) {
            DLinkedListNode node = new DLinkedListNode();
            node.key = key;
            node.val = value;
            
            hm.put(key, node);
            addNodeToHead(key);
            
            ++count;
            
            if (count > capacity) {
                DLinkedListNode removeTail = popTail();
                hm.remove(removeTail.key);
                --count;
            }
        } else {
            DLinkedListNode updateNode = hm.get(key);
            updateNode.val = value;
            moveToHead(key);
        }
    }
    
    class DLinkedListNode {
        int key;
        int val;
        DLinkedListNode pre;
        DLinkedListNode post;
    }
}
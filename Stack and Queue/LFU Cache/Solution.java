class Node {
    int freq;
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
        this.freq = 1;
    }
}

class LRUCache{
    Node head;
    Node tail;
    int size;
    LRUCache() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    public void addToHead(Node curNode) {
            Node nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
        
            head.next = curNode;
            nextNode.prev = curNode;
            size++;
    }
    public void removeNode(Node curNode) {
        Node prevNode = curNode.prev;
        Node nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }
    
}


class LFUCache {

    final int capacity;
    int size;
    int minFreq;
    HashMap<Integer, Node> cache;
    HashMap<Integer, LRUCache> freqMap;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.size = 0;
        
        this.cache = new HashMap<Integer, Node>();
        this.freqMap = new HashMap<Integer, LRUCache>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        Node req = cache.get(key);
        updateCache(req);
        return req.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            Node req = cache.get(key);
            req.value = value;
            updateCache(req);
        } else {
            size++;
            if(size > capacity) {
                LRUCache req_LRUCache = freqMap.get(minFreq);
                //remove lru from minfreq lrucache
                Node toBeRemoved = req_LRUCache.tail.prev;
                cache.remove(toBeRemoved.key);
                req_LRUCache.removeNode(toBeRemoved);
                size--;
            }
            minFreq = 1;
            Node newNode = new Node(key, value);
            newNode.freq = 1;
            LRUCache curr_LRUCache = freqMap.getOrDefault(1, new LRUCache());
            curr_LRUCache.addToHead(newNode);
            freqMap.put(1, curr_LRUCache);
            cache.put(key, newNode);
        }
    }
    public void updateCache(Node node) {
        int curFreq = node.freq;
        LRUCache req_LRUCache = freqMap.get(curFreq);
        req_LRUCache.removeNode(node);
        
        if(curFreq == minFreq && req_LRUCache.size == 0) {
            minFreq++;
        }
        
        curFreq++;
        node.freq = curFreq;
        LRUCache new_LRUCache = freqMap.getOrDefault(curFreq, new LRUCache());
        new_LRUCache.addToHead(node);
        freqMap.put(curFreq, new_LRUCache);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

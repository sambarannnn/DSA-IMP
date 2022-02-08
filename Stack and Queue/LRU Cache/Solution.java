class LRUCache {

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
        Node() {
            this.key = 0;
            this.value = 0;
            this.next = null;
            this.prev = null;
        }
    }
    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
        
    private void insertAtHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
            
        node.prev = head;
        head.next = node;
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node req = map.get(key);
        delete(req);
        insertAtHead(req);
        return req.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node req = map.get(key);
            delete(req);
            req.value = value;
            insertAtHead(req);
        } else {
            if(map.size() == capacity) {
                Node toBeRemoved = tail.prev;
                map.remove(toBeRemoved.key);
                delete(toBeRemoved);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAtHead(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

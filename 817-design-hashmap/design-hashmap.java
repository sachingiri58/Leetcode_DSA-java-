class MyHashMap {
    private static class Node {
        int key, val;
        Node next;
        Node(int k, int v, Node n) { key = k; val = v; next = n; }
    }

    private final int CAP = 769; 
    private final Node[] buckets;

    public MyHashMap() {
        buckets = new Node[CAP];
    }

    private int idx(int key) { return key % CAP; }

    public void put(int key, int value) {
        int i = idx(key);
        if (buckets[i] == null) {
            buckets[i] = new Node(-1, -1, null);
        }
        Node prev = findPrev(buckets[i], key);
        if (prev.next == null) {
            prev.next = new Node(key, value, null);
        } else {
            prev.next.val = value; 
        }
    }

    public int get(int key) {
        int i = idx(key);
        if (buckets[i] == null) return -1;
        Node prev = findPrev(buckets[i], key);
        return (prev.next == null) ? -1 : prev.next.val;
    }

    public void remove(int key) {
        int i = idx(key);
        if (buckets[i] == null) return;
        Node prev = findPrev(buckets[i], key);
        if (prev.next != null) prev.next = prev.next.next;
    }

    
    private Node findPrev(Node head, int key) {
        Node cur = head;
        while (cur.next != null && cur.next.key != key) cur = cur.next;
        return cur;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
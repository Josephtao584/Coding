package template;
import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class Node {
        Node prev, next;
        int key, val;
        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addFirst(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        addFirst(new Node(key, val));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addFirst(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        node.prev = head;
        head.next = node;
        headNext.prev = node;
        node.next = headNext;
    }
}
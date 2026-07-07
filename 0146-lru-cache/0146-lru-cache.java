import java.util.HashMap;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private Node head, tail;
    private int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {

        removeNode(node);
        addNode(node);
    }

    private Node removeTail() {

        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    public int get(int key) {

        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);

        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            moveToHead(node);

        } else {

            Node node = new Node(key, value);

            map.put(key, node);

            addNode(node);

            if (map.size() > capacity) {

                Node tail = removeTail();

                map.remove(tail.key);
            }
        }
    }
}
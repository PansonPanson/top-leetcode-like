package top.panson.top100.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-07-13
 */
public class L146 {
    class LRUCache {

        class Node {
            Node pre;
            Node next;
            int key;
            int val;
            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private int capacity;

        private Map<Integer, Node> map;

        private Node head;

        private Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if(!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                moveToHead(node);
            } else {
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addToHead(newNode);
                if(map.size() > capacity) {
                    Node delete = tail.pre;
                    delete.pre.next = tail;
                    tail.pre = delete.pre;
                    map.remove(delete.key);
                }
            }
        }

        private void moveToHead(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            addToHead(node);
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}

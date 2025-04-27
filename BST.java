import java.util.Iterator;
import java.util.Stack;
public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.Node> {
    private Node root;
    private int size;
    public class Node {
         K key;
         V val;
        private Node left, right;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return val;
        }
    }
    public int size() {
        return size;
    }
    public void put(K key, V val) {
        root = put(root, key, val);
    }
    private Node put(Node node, K key, V val) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, val);
        else if (cmp > 0) node.right = put(node.right, key, val);
        else node.val = val;

        return node;
    }
    public V get(K key) {
        Node node = get(root, key);
        return node == null ? null : node.val;
    }
    private Node get(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else return node;
    }
    public void delete(K key) {
        root = delete(root, key);
    }
    private Node delete(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = delete(node.left, key);
        else if (cmp > 0) node.right = delete(node.right, key);
        else {
            size--;
            // No child or one child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            // Two children: find in-order successor
            Node successor = min(node.right);
            successor.right = deleteMin(node.right);
            successor.left = node.left;
            return successor;
        }
        return node;
    }
    private Node min(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }
    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }
    @Override
    public Iterator<Node> iterator() {
        return new InOrderIterator();
    }
    private class InOrderIterator implements Iterator<Node> {
        Stack<Node> stack = new Stack<>();
        public InOrderIterator() {
            pushLeft(root);
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        public Node next() {
            Node current = stack.pop();
            pushLeft(current.right);
            return current;
        }
    }
}

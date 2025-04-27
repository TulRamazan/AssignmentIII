public class Main2 { // Enhancements test
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(10, "ten");
        tree.put(20, "twenty");
        tree.put(5, "five");
        for (BST<Integer, String>.Node node : tree) {
            System.out.println("key is " + node.getKey() + " and value is " + node.getValue());
        }
        System.out.println("Tree size: " + tree.size());
    }
}

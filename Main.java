public class Main { // Test Program to Insert 10,000 Elements
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>(97); // Using a prime number for better distribution
        for (int i = 0; i < 10000; i++) {
            MyTestingClass obj = new MyTestingClass(i, "Name" + i);
            table.put(obj, i);
        }
        table.printBucketSizes(); // Printing how many elements are in every bucket
    }
}
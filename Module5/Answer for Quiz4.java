public class HashTable {
    private static final int DEFAULT_CAPACITY = 10;
    private Entry[] entries;
    private static final Entry DELETED_ENTRY = new Entry(null, null);

    public HashTable() {
        entries = new Entry[DEFAULT_CAPACITY];
    }

    private static class Entry {
        String key;
        String value;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private int computeHash(String key) {
        return Math.abs(key.hashCode()) % entries.length;
    }

    public void insert(String key, String value) {
        int index = computeHash(key);
        while (entries[index] != null && entries[index] != DELETED_ENTRY && !entries[index].key.equals(key)) {
            index = (index + 1) % entries.length;
        }
        entries[index] = new Entry(key, value);
    }

    public String retrieve(String key) {
        int index = computeHash(key);
        while (entries[index] != null) {
            if (entries[index] != DELETED_ENTRY && entries[index].key.equals(key)) {
                return entries[index].value;
            }
            index = (index + 1) % entries.length;
        }
        return null;
    }

    public void delete(String key) {
        int index = computeHash(key);
        while (entries[index] != null) {
            if (entries[index] != DELETED_ENTRY && entries[index].key.equals(key)) {
                entries[index] = DELETED_ENTRY;
                return;
            }
            index = (index + 1) % entries.length;
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert("key1", "value1");
        hashTable.insert("key2", "value2");
        hashTable.insert("key3", "value3");

        System.out.println("Before deleting:");
        System.out.println("key1: " + hashTable.retrieve("key1"));
        System.out.println("key2: " + hashTable.retrieve("key2"));
        System.out.println("key3: " + hashTable.retrieve("key3"));

        hashTable.delete("key2");

        System.out.println("\nAfter deleting:");
        System.out.println("key1: " + hashTable.retrieve("key1"));
        System.out.println("key2: " + hashTable.retrieve("key2"));
        System.out.println("key3: " + hashTable.retrieve("key3"));
    }
}

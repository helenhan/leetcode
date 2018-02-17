package edu.helen.datastructure;

/**
 * https://discuss.leetcode.com/topic/102606/design-a-hashmap/3
 *
 * @param <K>
 * @param <V>
 */
public class MyHashtable<K, V> {
    private final int MAX_SIZE = 10;
    private Entry[] table;

    public MyHashtable() {
        table = new Entry[MAX_SIZE];
    }

    public void put(K key, V value) {
        Entry entry = new Entry(key, value);
        int code = key.hashCode() % MAX_SIZE;
        if (table[code] == null) {
            table[code] = entry;
        } else {
            addOrUpdate(table[code], entry);
        }
    }

    public V get(K key) {
        int code = key.hashCode() % MAX_SIZE;
        Entry<K, V> entry = table[code];
        if (entry == null) {
            return null;
        } else {
            while (entry != null) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
                entry = entry.next;
            }
        }
        return null;
    }

    public void remove(K key) {
        int code = key.hashCode() % MAX_SIZE;
        Entry<K, V> entry = table[code];
        if (entry == null) {
            return;
        } else {
            Entry<K, V> dummy = new Entry("0", "0");
            dummy.next = entry;
            Entry prev = dummy;
            while (entry != null) {
                if (entry.key.equals(key)) {
                    prev.next = entry.next;
                    break;
                }
                prev = entry;
                entry = entry.next;
            }
            table[code] = dummy.next;
        }
    }

    public boolean containsKey(String key) {
        int code = key.hashCode() % MAX_SIZE;
        Entry<K, V> entry = table[code];
        if (entry == null) {
            return false;
        } else {
            while (entry != null) {
                if (entry.key.equals(key)) {
                    return true;
                }
                entry = entry.next;
            }

        }
        return false;
    }

    public void addOrUpdate(Entry head, Entry entry) {
        while (head.next != null) {
            if (head.key.equals(entry.key)) {
                head.value = entry.value;
                return;
            }
            head = head.next;
        }
        head.next = entry;
    }

    public static void main(String[] args) {

    }

}

class Entry<K, V> {
    K key;
    V value;
    Entry next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
    }
}
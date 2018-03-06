package edu.helen.datastructure;

/**
 * https://discuss.leetcode.com/topic/102606/design-a-hashmap/3
 *
 * @param <K>
 * @param <V>
 */
public class MyHashtable<K, V> {
//    private final int MAX_SIZE = 10;
//    private Entry[] table;
//
//    public MyHashtable() {
//        table = new Entry[MAX_SIZE];
//    }
//
//    public void put(K key, V value) {
//        Entry entry = new Entry(key, value);
//        int code = key.hashCode() % MAX_SIZE;
//        if (table[code] == null) {
//            table[code] = entry;
//        } else {
//            addOrUpdate(table[code], entry);
//        }
//    }
//
//    public V get(K key) {
//        int code = key.hashCode() % MAX_SIZE;
//        Entry<K, V> entry = table[code];
//        if (entry == null) {
//            return null;
//        } else {
//            while (entry != null) {
//                if (entry.key.equals(key)) {
//                    return entry.value;
//                }
//                entry = entry.next;
//            }
//        }
//        return null;
//    }
//
//    public void remove(K key) {
//        int code = key.hashCode() % MAX_SIZE;
//        Entry<K, V> entry = table[code];
//        if (entry == null) {
//            return;
//        } else {
//            Entry<K, V> dummy = new Entry("0", "0");
//            dummy.next = entry;
//            Entry prev = dummy;
//            while (entry != null) {
//                if (entry.key.equals(key)) {
//                    prev.next = entry.next;
//                    break;
//                }
//                prev = entry;
//                entry = entry.next;
//            }
//            table[code] = dummy.next;
//        }
//    }
//
//    public boolean containsKey(String key) {
//        int code = key.hashCode() % MAX_SIZE;
//        Entry<K, V> entry = table[code];
//        if (entry == null) {
//            return false;
//        } else {
//            while (entry != null) {
//                if (entry.key.equals(key)) {
//                    return true;
//                }
//                entry = entry.next;
//            }
//
//        }
//        return false;
//    }
//
//    public void addOrUpdate(Entry head, Entry entry) {
//        while (head.next != null) {
//            if (head.key.equals(entry.key)) {
//                head.value = entry.value;
//                return;
//            }
//            head = head.next;
//        }
//        head.next = entry;
//    }

    private Entry[] table;
    private int MAX_SIZE = 10;

    public MyHashtable (){
        table = new Entry[MAX_SIZE];
    }
    private void addOrUpdate(Entry head, Entry entry){
        while(head.next!=null){
            if(head.key.equals(entry.key)){
                head.value = entry.value;
                return;
            }
            head = head.next;
        }
        head.next = entry;
    }
    public void put(Entry entry){
        int hash = entry.hashCode()%MAX_SIZE;
        Entry head = table[hash];
        if(head==null){
            table[hash] = entry;
        }else{
            addOrUpdate(head,entry);
        }
    }
    public V get(K key){
        int hash = key.hashCode()%MAX_SIZE;
        Entry entry = table[hash];
        if(entry==null){
            return null;
        }else{
            while(entry!=null){
                if(entry.key.equals(key)){
                    return (V) entry.value;
                }
                entry = entry.next;
            }
            return null;
        }
    }
    public boolean containsKey(K key){
        int hash = key.hashCode()%MAX_SIZE;
        Entry entry = table[hash];
        if(entry ==null){
            return false;
        }else{
            while(entry!=null){
                if(entry.key.equals(key)){
                    return true;
                }
                entry = entry.next;
            }
            return false;
        }
    }
    public void remove(Entry entry){
        int hash = entry.key.hashCode()%MAX_SIZE;
        Entry head = table[hash];
        if(head==null){
            return;
        }else{
            Entry dummy = new Entry(0,0);
            Entry prev = dummy;
            prev.next = head;
            while(head!=null){
                if(head.key.equals(entry.key)){
                    prev.next = head.next;
                    return;
                }
                prev = head;
                head = head.next;
            }
            table[hash] = dummy.next;
        }
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
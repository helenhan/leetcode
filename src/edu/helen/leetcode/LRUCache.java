package edu.helen.leetcode;

import com.sun.media.sound.DLSInfo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Helen on 2/6/2017.
 */
public class LRUCache {

//    class DLinkedNode {
//        int key;
//        int value;
//        DLinkedNode pre;
//        DLinkedNode post;
//    }
//
//    /**
//     * Always add the new node right after head;
//     */
//    private void addNode(DLinkedNode node){
//        node.pre = head;
//        node.post = head.post;
//
//        head.post.pre = node;
//        head.post = node;
//    }
//
//    /**
//     * Remove an existing node from the linked list.
//     */
//    private void removeNode(DLinkedNode node){
//        DLinkedNode pre = node.pre;
//        DLinkedNode post = node.post;
//
//        pre.post = post;
//        post.pre = pre;
//    }
//
//    /**
//     * Move certain node in between to the head.
//     */
//    private void moveToHead(DLinkedNode node){
//        this.removeNode(node);
//        this.addNode(node);
//    }
//
//    // pop the current tail.
//    private DLinkedNode popTail(){
//        DLinkedNode res = tail.pre;
//        this.removeNode(res);
//        return res;
//    }
//
//    private Hashtable<Integer, DLinkedNode>
//            cache = new Hashtable<>();
//    private int count;
//    private int capacity;
//    private DLinkedNode head, tail;
//
//    public LRUCache(int capacity) {
//        this.count = 0;
//        this.capacity = capacity;
//
//        head = new DLinkedNode();
//        head.pre = null;
//
//        tail = new DLinkedNode();
//        tail.post = null;
//
//        head.post = tail;
//        tail.pre = head;
//    }
//
//    public int get(int key) {
//
//        DLinkedNode node = cache.get(key);
//        if(node == null){
//            return -1; // should raise exception here.
//        }
//
//        // move the accessed node to the head;
//        this.moveToHead(node);
//
//        return node.value;
//    }
//
//
//    public void set(int key, int value) {
//        DLinkedNode node = cache.get(key);
//
//        if(node == null){
//
//            DLinkedNode newNode = new DLinkedNode();
//            newNode.key = key;
//            newNode.value = value;
//
//            this.cache.put(key, newNode);
//            this.addNode(newNode);
//
//            ++count;
//
//            if(count > capacity){
//                // pop the tail
//                DLinkedNode tail = this.popTail();
//                this.cache.remove(tail.key);
//                --count;
//            }
//        }else{
//            // update the value.
//            node.value = value;
//            this.moveToHead(node);
//        }
//
//    }

    class DLinkNode{
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;
        DLinkNode(int key, int value){
            this.key =key;
            this.value = value;
        }
    }

    void addNode(DLinkNode node){
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    void removeNode(DLinkNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    void moveNode2Head(DLinkNode node){
        removeNode(node);
        addNode(node);
    }
    void popTail(){
        map.remove(tail.pre.key);
        removeNode(tail.pre);
    }
    Map<Integer,DLinkNode> map = new HashMap<>();
    int capacity;
    DLinkNode head;
    DLinkNode tail;
    int count = 0;
    public LRUCache(int capacity){
        this.capacity = capacity;
        head = new DLinkNode(0,0);
        tail = new DLinkNode(0,0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public int get(int key) {
        if(map.get(key)!=null){
            DLinkNode node = map.get(key);
            moveNode2Head(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.get(key)!=null){
            DLinkNode node = map.get(key);
            node.value = value;
            moveNode2Head(node);
        }else{
            DLinkNode newnode = new DLinkNode(key,value);
            map.put(key,newnode);
            addNode(newnode);
            ++count;
            if(count>capacity){
                popTail();
                --count;
            }

        }
    }

}

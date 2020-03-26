package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MyHashMap<K, V> {
    private Node<K, V>[] MyHashM;
    private int size = 0;
    private int capacity = 16;

    public MyHashMap() {
        MyHashM = new Node[capacity];
    }

    public boolean insert(final K key, final V value) {
        if (size + 1 == capacity) {
            grow();
        }
        Node<K, V> newNode = new Node<K, V>(key, value);
        int index = newNode.hash();
        if (MyHashM[index] == null) {
            return add(index, newNode);
        }
        List<Node<K, V>> nodeList = MyHashM[index].getNodes();
        for (Node<K, V> node : nodeList) {
            if (newValue(node, newNode, value)) {
                return true;
            } else if (collision(node, newNode, nodeList)) {
                return true;
            }
        }
        return false;
    }

    private void grow() {
        Node<K, V>[] old = MyHashM;
        capacity = capacity * 2;
        MyHashM = new Node[capacity];
        size = 0;
        for (Node<K, V> node : old) {
            if (node != null) {
                for (Node<K, V> n : node.getNodes()) {
                    insert(n.key, n.value);
                }
            }
        }
    }

    private boolean add(int index, Node<K, V> newNode) {
        MyHashM[index] = new Node<>(null, null);
        MyHashM[index].getNodes().add(newNode);
        size++;
        return true;
    }

    private boolean newValue(final Node<K, V> exist, final Node<K, V> newNode, final V value) {
        if (exist.getK().equals(newNode.getK()) && !exist.getV().equals(newNode.getV())) {
            exist.setV(value);
            return true;
        }
        return false;
    }

    private boolean collision(final Node<K, V> exist, final Node<K, V> newNode, final List<Node<K, V>> nodeList) {
        nodeList.add(newNode);
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean delete(final K key) {
        int index = key.hashCode();
        if (MyHashM[index] == null) return false;
        if (MyHashM[index].getNodes().size() == 1) {
            MyHashM[index] = null;
            return true;
        }
        List<Node<K, V>> nodeList = MyHashM[index].getNodes();
        for (Node<K, V> node : nodeList) {
            if (node.getK().equals(key)) {
                nodeList.remove(node);
                return true;
            }
        }
        return false;
    }

    private int hash(final K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % MyHashM.length;
    }

    public V get(final K key) {
        int index = hash(key);
        if (index < MyHashM.length && MyHashM[index] != null) {
            if (MyHashM[index].getNodes().size() == 1) {
                return MyHashM[index].getNodes().get(0).getV();
            }
            List<Node<K, V>> nodeList = MyHashM[index].getNodes();
            for (Node<K, V> node : nodeList) {
                if (node.getK().equals(key)) {
                    return node.getV();
                }
            }
        }
        return null;
    }


    private class Node<K, V> {
        int hash;
        private K key;
        private V value;
        private List<Node<K, V>> nodes;

        private Node(K key, V value) {
            this.value = value;
            this.key = key;
            nodes = new LinkedList<Node<K, V>>();
        }

        private List<Node<K, V>> getNodes() {
            return nodes;
        }

        private int hash() {
            return hashCode() % MyHashM.length;
        }

        private K getK() {
            return this.key;
        }

        private V getV() {
            return this.value;
        }

        private void setV(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Node) {
                Node<K, V> node = (Node) o;
                return (Objects.equals(key, node.getK()) &&
                        Objects.equals(value, node.getV()) ||
                        Objects.equals(hash, node.hashCode()));
            }
            return false;
        }

        @Override
        public int hashCode() {
            hash = 31;
            hash = hash * 17 + key.hashCode();
            return hash;

        }
    }

}

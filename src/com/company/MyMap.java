package com.company;

public interface MyMap<K,V> {
    boolean insert(K key,  V value);
    boolean delete(K key );
    V get(K key);
    int size();

}


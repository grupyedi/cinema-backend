package com.grupyedi.webservice.datastructures;

public interface Map<K, V> {
    /**
     *
     * @param key to get the value with key
     * @return the assigned value; else null
     */
    V get(Object key);

    /**
     *
     * @return true if empty; else false
     */
    boolean isEmpty();

    /**
     *
     * @param key with which the specified value is to be associated
     * @param value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    V put(K key, V value);

    /**
     *
     * @param key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    V remove(Object key);

    /**
     *
     * @return the number of key-value mappings in this map
     */
    int size();
}

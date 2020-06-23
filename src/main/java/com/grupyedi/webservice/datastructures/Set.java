package com.grupyedi.webservice.datastructures;

import java.util.Arrays;
import java.util.Iterator;

public class Set<E extends Comparable<E>> implements Iterable<E>{
    private HashMap<E,E> map;
    private int dataOrder[];
    private static final int capacity = 4;
    private int numKeys;

    public Set() {
        map = new HashMap<>();
        dataOrder = new int[capacity];
        numKeys = 0;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < numKeys;
            }

            @Override
            public E next() {
                return map.byIndex(dataOrder[currentIndex++]);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    /**
     *
     * @param e to add in set
     * @return null , if key is unique and added to the map, or Old Value of the key , if key is duplicate
     */
    public boolean add(E e) {
        if(numKeys == dataOrder.length-1){
            reSize();
        }
        if(map.put(e, e)==null){
            reOrder(e);
            return true;
        }
        return false;
    }

    /**
     * Creates the needed space
     */
    private void reSize(){
        dataOrder = Arrays.copyOf(dataOrder, dataOrder.length*2);
    }

    /**
     * Orders the set sequence according with accounting the new element
     * @param e the new element that is added
     */
    private void reOrder(E e){
        for(int i = 0; i < numKeys; i++){
            if(e.compareTo(map.byIndex(dataOrder[i])) < 0){
                for(int j = numKeys; j > i; j--){
                    dataOrder[j] = dataOrder[j-1];
                }
                dataOrder[i] = map.find(e);
                ++numKeys;
                return;
            }
        }
        dataOrder[numKeys] = map.find(e);
        ++numKeys;
        return;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(int i = 0; i < numKeys; i++){
            sb.append(map.byIndex(dataOrder[i]));
            if(i != numKeys-1)
                sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }

    /**
     *
     * @param element to remove from the set
     * @return true if this set contained the specified element, or false
     */
    public boolean remove(E element){
        int indx = map.find(element);
        if(map.remove(element) == null)
            return false;
        for(int i = 0; i < numKeys; i++){
            if(dataOrder[i] == indx){
                for(int j = i; j < numKeys; j++){
                    dataOrder[j] = dataOrder[j+1];
                }
                --numKeys;
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return the number of elements in this set
     */
    public int size(){
        return numKeys;
    }

    /**
     *
     * @return the first (lowest) element currently in this set
     */
    public E first(){
        return map.byIndex(dataOrder[0]);
    }

    /**
     *
     * @return the last (highest) element currently in this set
     */
    public E last(){
        return map.byIndex(dataOrder[numKeys-1]);
    }

    /**
     *
     * @return true if this set contains no elements, or false
     */
    public boolean isEmpty(){
        return numKeys == 0;
    }

    /**
     *
     * @param key to be checked for containment in this set
     * @return true if this set contains the specified element, or false
     */
    public boolean contains(Object key){
        return map.get(key) != null;
    }

    /**
     *
     * @param fromElement low endpoint of the returned set
     * @param fromInclusive true if the low endpoint is to be included in the returned view
     * @param toElement high endpoint of the returned set
     * @param toInclusive true if the high endpoint is to be included in the returned view
     * @return a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive
     */
    public Set<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive){
        Set<E> tmp = new Set<E>();
        for(int i = 0; i < numKeys; i++){
            E element = map.byIndex(dataOrder[i]);
            if(fromInclusive && toInclusive){
                if(fromElement.compareTo(element) <= 0 && toElement.compareTo(element) >= 0)
                    tmp.add(element);
            }else if(!fromInclusive && toInclusive){
                if(fromElement.compareTo(element) < 0 && toElement.compareTo(element) >= 0)
                    tmp.add(element);
            }else if(fromInclusive){
                if(fromElement.compareTo(element) <= 0 && toElement.compareTo(element) > 0)
                    tmp.add(element);
            }else{
                if(fromElement.compareTo(element) < 0 && toElement.compareTo(element) > 0)
                    tmp.add(element);
            }
        }
        return tmp;
    }

    /**
     *
     * @param fromElement low endpoint (inclusive) of the returned set
     * @param toElement high endpoint (exclusive) of the returned set
     * @return a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive
     */
    public Set<E> subSet(E fromElement, E toElement){
        return subSet(fromElement, true, toElement, true);
    }

    /**
     *
     * @param fromElement low endpoint (inclusive) of the returned set
     * @return a view of the portion of this set whose elements are greater than or equal to fromElement
     */
    public Set<E> tailSet(E fromElement){
        return subSet(fromElement, map.byIndex(dataOrder[numKeys-1]));
    }

    /**
     *
     * @param fromElement low endpoint of the returned set
     * @param inclusive true if the low endpoint is to be included in the returned view
     * @return a view of the portion of this set whose elements are greater than or equal to fromElement
     */
    public Set<E> tailSet(E fromElement, boolean inclusive){
        return subSet(fromElement, inclusive, map.byIndex(dataOrder[numKeys-1]), true);
    }

    /**
     *
     * @param toElement high endpoint (exclusive) of the returned set
     * @return a view of the portion of this set whose elements are strictly less than toElement
     */
    public Set<E> headSet(E toElement){
        return subSet(map.byIndex(dataOrder[0]), toElement);
    }

    /**
     *
     * @param toElement high endpoint of the returned set
     * @param inclusive true if the high endpoint is to be included in the returned view
     * @return a view of the portion of this set whose elements are less than (or equal to, if inclusive is true) toElement
     */
    public Set<E> headSet(E toElement, boolean inclusive){
        return subSet(map.byIndex(dataOrder[0]), true, toElement, inclusive);
    }

    /**
     *
     * @param element the value to match
     * @return the least element greater than or equal to e, or null if there is no such element
     */
    public E ceiling(E element){
        return ceilingOrHigher(element, true);
    }

    /**
     *
     * @param element the value to match
     * @return the least element greater than e, or null if there is no such element
     */
    public E higher(E element){
        return ceilingOrHigher(element, false);
    }

    /**
     *
     * @param element the value to match
     * @param isCeiling if true acts as ceiling, or acts as higher
     * @return the found value according to its parameters
     */
    private E ceilingOrHigher(E element, boolean isCeiling){
        for(int i = 0; i < numKeys; i++){
            E tmp = map.byIndex(dataOrder[i]);
            if(isCeiling){
                if(tmp.compareTo(element) >= 0)
                    return tmp;
            }else {
                if(tmp.compareTo(element) > 0)
                    return tmp;
            }
        }
        return null;
    }

    /**
     *
     * @param element the value to match
     * @param isFloor if true acts as floor, or acts as lower
     * @return the found value according to its parameters
     */
    private E floorOrLower(E element, boolean isFloor){
        for(int i = numKeys-1; i >= 0; i--){
            E tmp = map.byIndex(dataOrder[i]);
            if(isFloor){
                if(tmp.compareTo(element) <= 0)
                    return tmp;
            }else{
                if(tmp.compareTo(element) < 0)
                    return tmp;
            }
        }
        return null;
    }

    /**
     *
     * @param element the value to match
     * @return the greatest element less than or equal to e, or null if there is no such element
     */
    public E floor(E element){
        return floorOrLower(element, true);
    }

    /**
     *
     * @param element the value to match
     * @return the greatest element less than e, or null if there is no such element
     */
    public E lower(E element){
        return floorOrLower(element, false);
    }

    private E remove(E element, int trash){
        int indx = map.find(element);
        E tmp = map.remove(element);
        if(tmp == null)
            return tmp;
        for(int i = 0; i < numKeys; i++){
            if(dataOrder[i] == indx){
                for(int j = i; j < numKeys; j++){
                    dataOrder[j] = dataOrder[j+1];
                }
                --numKeys;
                return tmp;
            }
        }
        return tmp;
    }

    /**
     *
     * @return the first element, or null if this set is empty
     */
    public E pollFirst(){
        return remove(map.byIndex(dataOrder[0]), 0);
    }

    /**
     *
     * @return the last element, or null if this set is empty
     */
    public E pollLast(){
        return remove(map.byIndex(dataOrder[numKeys-1]), 1);
    }

    public boolean testAddingTraversingAndRemoving(){
        Set<Integer> s = new Set<Integer>();
        s.add(4); s.add(7); s.add(2); s.add(17); s.add(13); s.add(15); s.add(5);
        System.out.println("Elements are added, with the order: 4, 7, 2, 17, 13, 15");
        System.out.println("Set: " + s);
        Iterator<Integer> it = s.iterator();
        System.out.println("Navigating with iterator");
        while(it.hasNext()){
            System.out.print(it.next() +" ");
        }
        System.out.println("Removing first, last and a middle element.");
        s.remove(2); s.remove(17); s.remove(7);
        System.out.println("Set: " + s);
        return true;
    }

    public boolean testVariousSubSettMethods(){
        Set<Integer> s = new Set<Integer>();
        s.add(4); s.add(7); s.add(2); s.add(17); s.add(13); s.add(15); s.add(5); s.add(23); s.add(11); s.add(19);
        System.out.println("Set: " + s);
        System.out.println("Subset from 11 to 17 will be returned from subset method");
        System.out.println("Subset: " + s.subSet(11,17));
        System.out.println("Tail Subset from 13");
        System.out.println("Tail Subset: " + s.tailSet(13));
        System.out.println("Head Subset to 15");
        System.out.println("Head Subset: " + s.headSet(15));
        return true;
    }

    public boolean testEdgeElementMethods(){
        Set<Integer> s = new Set<Integer>();
        s.add(4); s.add(7); s.add(2); s.add(17); s.add(13); s.add(15); s.add(5); s.add(23); s.add(11); s.add(19);
        System.out.println("Set: " + s);
        System.out.println("Ceiling of 17: " + s.ceiling(17));
        System.out.println("Floor of 17: " + s.ceiling(17));
        System.out.println("Higher of 17: " + s.higher(17));
        System.out.println("Lower of 17: " + s.lower(17));
        return true;
    }

    public static void main(String args[]){

    }
}
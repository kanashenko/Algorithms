package datastructs;

public class OpenAddressingHashTable<K,V> {

    private class Entry<K,V>{
        K key;
        V value;
    }
    private int size, capacity, threshold;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int DEFAULT_CAPACITY = 10;
    private double loadFactor;

    private K[] keys;
    private V[] values;

    protected OpenAddressingHashTable(){
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    protected OpenAddressingHashTable(int capacity){
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    protected OpenAddressingHashTable(int capacity, double loadFactor){
        if(capacity <= 0) throw  new IllegalArgumentException("Illegal capacity "+ capacity);
        if(loadFactor <= 0) throw  new IllegalArgumentException("Illegal loadFactor "+ loadFactor);
       this.loadFactor = loadFactor;
       this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
       threshold = (int) (capacity * loadFactor);

       keys =   (K[]) new Object[capacity];
       values = (V[]) new Object[capacity];

    }
}

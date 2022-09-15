package main.java;

//TODO: Refactor to be String Key, E Value to be more general
/*
* This class is a basic data structure for the HashTable data structure.
* It holds a String key, and for simplicity, an int for Key (instead of generic type)
* I verified with driver code
* */
public class HashEntry {
    private final String key;
    private int value;

    public HashEntry(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int newVal){
        this.value = newVal;
    }

}

package main.java;

import main.java.Exceptions.keyDoesntExistException;
import main.java.Exceptions.keyExistsException;

import java.util.ArrayList;



import static java.util.Objects.hash;

//TODO: Consider refactoring this to be an array of generic Type E
/*
* * Does not account for case where keys collide on the HashTable:
 *  See http://math.oxford.emory.edu/site/cs171/collisionResolution/
* */

public class HashTable {
    private final ArrayList<HashEntry> hashIndicies;
    //private int capacity;

    public HashTable(int capacity){
        if(capacity > 0){
            hashIndicies = new ArrayList<HashEntry>(capacity);
            for(int i=0; i<capacity; i++){
                hashIndicies.add((HashEntry) null);
            }
        } else throw new IndexOutOfBoundsException();
    }


    public HashTable(){
        hashIndicies = new ArrayList<HashEntry>(11);
        for(int i=0; i<11; i++){
            hashIndicies.add((HashEntry) null);
        }
    }


    //helper function to compute hashtable index given a key
    private int compute(String key){
        int hash = hash(key);
        int index = hash % hashIndicies.size();
        return index;
    }


    /*
     * Expected Input: String to be used as a key
     * Expected Output: Return true if key exists, false otherwise.
     */
    public Boolean keyExists(String key){
        int index = compute(key);

        //the computed index has a non-null key value pair
        if(hashIndicies.get(index) != null && hashIndicies.get(index).getKey() == key){
            return true;
        }

        return false;
    }



    /*
     * Expected Input: String key, and int value to be associated with the key
     * Expected Output: adds a key / value pair to the hashtable
     * AND does not add if the key already exists
     */

    public void add(String key, int value) throws keyExistsException {
        HashEntry hashEntry = new HashEntry(key, value);
        int index = compute(key);


        if(keyExists(key)){
            throw new keyExistsException("Sorry, this key already exists in the hashtable./n " +
                    "Please use the update(), remove(), or getValue() methods with this key as a parameter.");

        }
        else {
            hashIndicies.set(index, hashEntry);
        }


    }


    /*
     * Expected Input: String key, and int value to be associated with the key
     * Expected Output: updates the int a key / value pair to the hashtable
     * if the key already exists. If it does not exist, do nothing
     */
    public void update(String key, int newVal) throws keyDoesntExistException{
        HashEntry hashEntry = new HashEntry(key, newVal);
        int index = compute(key);


        if(keyExists(key)){
            hashIndicies.set(index, hashEntry);
        }
        else {
            throw new keyDoesntExistException("Sorry, this key does not exist in the hashtable./n " +
                    "There is nothing to update.");
        }

    }



    /*
     * Expected Input: String key
     * Expected Output: Remove the HashEntry corresponding to the given KEY, if the key already exists.
     * If it does not exist, do nothing
     */
    public void remove(String key) throws keyDoesntExistException{
        int index = compute(key);


        if(keyExists(key)){
            hashIndicies.set(index, null);
        }
        else {
            throw new keyDoesntExistException("Sorry, this key does not exist in the hashtable./n " +
                    "There is nothing to remove.");
        }



    }





    /*
     * Expected Input: String key
     * Expected Output: Returns integer value given a key
     * AND Returns null if the key is not in the hashtable
     */
    public int getValue(String key) throws keyDoesntExistException{
        int index = compute(key);

        if(keyExists(key)){
            return hashIndicies.get(index).getValue();
        }
        else {
            throw new keyDoesntExistException("Sorry, this key does not exist in the hashtable./n " +
                    "There is nothing to retrieve.");
        }


    }

    @Override
    public String toString()
    {
        return hashIndicies.toString();
    }



    private class HashEntry {
        private final String key;
        private int value;

        private HashEntry(String key, int value) {
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

        @Override
        public String toString(){
            return "(" + this.key + " : " + this.value + ")";
        }

    }





}






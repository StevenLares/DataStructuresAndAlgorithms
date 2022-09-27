package main.java;

import java.util.ArrayList;
import java.util.LinkedList;

import static java.util.Objects.hash;

//TODO: Consider refactoring this to be an array of generic Type E

public class HashTable {
    private ArrayList<LinkedList> hashIndicies;

    public HashTable(int arrayLength){
        if(arrayLength > 0){
            hashIndicies = new ArrayList<LinkedList>(arrayLength);
        } else throw new IndexOutOfBoundsException();
    }


    public HashTable(){
        hashIndicies = new ArrayList<LinkedList>(11);
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

        if(hashIndicies.get(index) == null){ //the computed index does not have any key,value pairs
            return false;
        }
        else {
            LinkedList<HashEntry> linkedList = hashIndicies.get(index);
            for (HashEntry hashEntry : linkedList) {
                if(hashEntry.getKey() == key){
                    return true;
                }
            }
        }

        return false;


    }



    /*
     * Expected Input: String key, and int value to be associated with the key
     * Expected Output: adds a key / value pair to the hashtable
     * AND does not add if the key already exists
     */

    public void add(String key, int value){
        HashEntry hashEntry = new HashEntry(key, value);
        int index = compute(key);

        //case where the given index does not have any entries
        if(hashIndicies.get(index) == null){
            LinkedList<HashEntry> linkedList = new LinkedList<HashEntry>();
            hashIndicies.set(index, linkedList); //create new linkedList, add the key there.
        } else if (keyExists(key) == false){
            LinkedList<HashEntry> linkedList = hashIndicies.get(index); //create ref. to linkedList at this index
            linkedList.add(hashEntry); //add the hashEntry to the linkedList
        } else System.out.println("Sorry, this key already exists in the hashtable./n " +
                "Please use the update(), remove(), or getValue() methods with this key as a parameter.");


    }


    /*
     * Expected Input: String key, and int value to be associated with the key
     * Expected Output: updates the int a key / value pair to the hashtable
     * if the key already exists. If it does not exist, do nothing
     * Does not account for case where keys collide on the HashTable:
     * See http://math.oxford.emory.edu/site/cs171/collisionResolution/
     */
    public void update(String key, int newVal){
        if(keyExists(key) == false){
            System.out.println("Sorry, this key does not exist in the hashtable./n There is nothing to update.");
        }
        else {
            int index = compute(key);
            LinkedList<HashEntry> linkedList = hashIndicies.get(index);
            for (HashEntry hashEntry : linkedList) {
                if(hashEntry.getKey() == key){
                    int oldValue = hashEntry.getValue();
                    hashEntry.setValue(newVal);
                    System.out.println("Key " + key + ": Value updated from " + oldValue + " to " + newVal);
                    break;
                }
            }
        }

    }



    /*
     * Expected Input: String key
     * Expected Output: Remove the HashEntry corresponding to the given KEY, if the key already exists.
     * If it does not exist, do nothing
     */
    public void remove(String key){
        if(keyExists(key) == false){
            System.out.println("Sorry, this key does not exist in the hashtable./n There is nothing to remove.");
        }
        else {
            int index = compute(key);
            LinkedList<HashEntry> linkedList = hashIndicies.get(index);
            for (HashEntry hashEntry : linkedList) {
                if(hashEntry.getKey() == key){
                    int value = hashEntry.getValue();
                    linkedList.remove(hashEntry);
                    System.out.println("Key / Value pair was removed from hashtable: " + key + " : " + value);
                    break;
                }
            }
        }


    }





    /*
     * Expected Input: String key
     * Expected Output: Returns integer value given a key
     * AND Returns null if the key is not in the hashtable
     */
    public Integer getValue(String key){
        if(keyExists(key) == false){
            System.out.println("Sorry, this key does not exist in the hashtable./n There is no value to retrieve.");
            return null;
        }
        else {
            int index = compute(key);
            LinkedList<HashEntry> linkedList = hashIndicies.get(index);
            for (HashEntry hashEntry : linkedList) {
                if(hashEntry.getKey() == key){
                    return hashEntry.getValue();
                }
            }
        }
        return null;

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

    }





}






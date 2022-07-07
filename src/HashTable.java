import java.util.ArrayList;
import java.util.LinkedList;

import static java.util.Objects.hash;

public class HashTable {
    private ArrayList<LinkedList> hashIndicies; //TODO: change this to custom built arraylist

    public HashTable(int arrayLength){
        if(arrayLength > 0){
            hashIndicies = new ArrayList<LinkedList>(arrayLength);
        } else throw new IndexOutOfBoundsException(); //TODO: write custom error handler
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




    //this function adds a key / value pair to the hashtable.
    //does not add if the key already exists
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



    //returns value given a key
    //returns null if the key is not in the hashtable
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




}






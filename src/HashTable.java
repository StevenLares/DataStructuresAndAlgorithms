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


    //this function adds a key / value pair to the hashtable.
    public void add(String key, int value, boolean replace){
        HashEntry hashEntry = new HashEntry(key, value);
        int index = compute(key);

        //case where the given index does not have any entries
        if(hashIndicies.get(index) == null){
            LinkedList<HashEntry> linkedList = new LinkedList<HashEntry>();
            hashIndicies.set(index, linkedList); //create new linkedList, add the key there.
        } else { //index has entries
            //TODO: Implement functionality

        }



    }


    public void replace(){

    }



    public Integer getValue(String key){
        int index = compute(key);

        if(hashIndicies.get(index) != null){
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






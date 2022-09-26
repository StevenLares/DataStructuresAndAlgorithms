package main.java;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayList<E> {
    private E[] array;
    private int arrayListIterator;

    public ArrayList(E e) {
        this.arrayListIterator = 1;

        // @SuppressWarnings("unchecked")
        this.array = (E[]) new Object[1];
        array[0] = e;

    }

    /*
     * Expected Input:
     * Data of type E, which is specified at the time of object creation
     * AND assumes arrayListIterator started at 1 at the time of main.java.ArrayList creation.

     * * Expected Output:
     * adds data to array of type E AND increments arrayListIterator by 1
     * AND doubles underlying array if arrayListIterator is finally equal to array.length
     * */
    public void add(E data) {
        if (arrayListIterator == array.length) {
            duplicateArray();
        }

        array[arrayListIterator] = data;
        arrayListIterator++;
    }



    /*
     * Expected Input: Data of Type E, Positive integer (primitive type) starting from 0 which should be no larger than the array size
     * Expected Output: Overwrites the underlying array with input data E at the given input index
     * AND it does not increment arrayListIterator by 1 AND does not double the array size to increase space. In other words, this is purely for overwriting
     * array elements.
     * */

    public void set(E data, int index) {
        if (validIndex(index) == false) {
            throw new IndexOutOfBoundsException();
        } else array[index] = data;
    }


    /*
     * Expected Input: Positive integer (primitive type) starting from 0 which should be no larger than the array size
     *
     * Expected Output: Data of Type E from the underlying array
     *
     * */
    public E get(int index) {
        if (validIndex(index) == false) {
            throw new IndexOutOfBoundsException();
        } else return array[index];
    }



    /*
     * Expected Input:
     * Expected Output:
     * */
    private boolean validIndex(int index) {
        if (index > array.length - 1 || index > arrayListIterator - 1 || index > array.length - 1 || index < 0) {
            return false;
        } else return true;
    }




    private void duplicateArray() {
        //this is the built-in java implementation
        this.array = Arrays.copyOf(array, array.length * 2);
    }



    @Override
    public String toString() {
        String array_contents;

        if (arrayListIterator <= 0) {
            return "[]";
        }
        else {
            if(array[0] == null){
                array_contents = "NULL";
            }
            else {
                array_contents = array[0].toString();
            }

            for (int i = 1; i < arrayListIterator; i++) {
                if(array[i] == null){
                    array_contents = array_contents + ", NULL";
                }
                else {
                    array_contents = array_contents + ", " + array[i].toString();
                }

            }
            array_contents = "[" + array_contents + "]";

        }

        return array_contents;


    }






}

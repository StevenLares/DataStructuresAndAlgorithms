import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayList<E> {
    private E[] array;
    private int arrayListIterator;

    public ArrayList(Class<E> arrayType){
        this.arrayListIterator = 1;

        //@SuppressWarnings("unchecked")
        this.array = (E[]) Array.newInstance(arrayType, 1);

    }

    /*
    * Expected Input:
    * Data of type E, which is specified at the time of object creation
    * AND assumes arrayListIterator started at 1 at the time of ArrayList creation.

    * * Expected Output:
    * adds data to array of type E AND increments arrayListIterator by 1
    * AND doubles underlying array if arrayListIterator is finally equal to array.length
    * */
    public void add(E data){
        if(arrayListIterator == array.length){
            duplicateArray();
        }
        array[arrayListIterator - 1] = data;
        arrayListIterator++;
    }

    /*
     * Expected Input: Data of type E, which is specified at the time of object creation
     * AND Positive Index, that is less than or equal to arrayListIterator (the arraylist length from user perspective)
     * AND assumes arrayListIterator started at 1 at the time of ArrayList creation.
     *
     * Expected Output:
     * Overwrites the underlying array with input data E at the given input index
     * AND increments arrayListIterator by 1
     * AND doubles underlying array if arrayListIterator is finally equal to array.length

     * */
    public void add(E data, int index){
        if(validIndex(index) == false){
            throw new IndexOutOfBoundsException();

        }
        else if (array[index] != null){
            throw new IndexOutOfBoundsException(); //TODO: actually create a new exception here
        }
        else {
            array[index] = data;
            arrayListIterator++;
            if(arrayListIterator == array.length){
                duplicateArray();
            }
        }
    }

    /*
     * Expected Input:
     * Expected Output:
     * */
    public E get(int index){
        if(validIndex(index) == false){
            throw new IndexOutOfBoundsException();
        }
        else return array[index];
    }

    /*
     * Expected Input:
     * Expected Output:
     * */
    public void set(E data, int index){
        if(validIndex(index) == false){
            throw new IndexOutOfBoundsException();
        }
        else array[index] = data;
    }


    /*
     * Expected Input:
     * Expected Output:
     * */
    private boolean validIndex(int index) {
        if(index > array.length - 1 || index > arrayListIterator - 1) {
            return false;
        }
        else return true;
    }


    /*
     * Expected Input:
     * Expected Output:
     * */

    private void duplicateArray() {

        //this is the built-in java implementation
        //this.array = Arrays.copyOf(array, array.length * 2);

        //this is an implementation that is more manual
        E[] temp = (E[]) Array.newInstance(array.getClass(), array.length * 2);
        for (int i = 0; i < array.length; i++){
            temp[i] = array[i];
        }
        this.array = temp;

        //this should be run regardless of which implementation you use
        arrayListIterator++;


    }

}

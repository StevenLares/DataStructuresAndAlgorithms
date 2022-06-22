import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayList<E> {
    private E[] array;
    private int listLen;

    public ArrayList(Class<E> arrayType){
        this.listLen = 1;

        //@SuppressWarnings("unchecked")
        this.array = (E[]) Array.newInstance(arrayType, 1);

    }

    public void add(E data){
        if(listLen == array.length){
            duplicateArray();
        }
        array[listLen - 1] = data;
        listLen++;
    }

    public void add(E data, int index){
        if(validIndex(index) == false){
            throw new IndexOutOfBoundsException();

        }
        else if (array[index] != null){
            throw new IndexOutOfBoundsException(); //TODO: actually create a new exception here
        }
        else {
            array[index] = data;
            listLen++;
            if(listLen == array.length){
                duplicateArray();
            }
        }
    }

    public E get(int index){
        if(validIndex(index) == false){
            throw new IndexOutOfBoundsException();
        }
        else return array[index];
    }

    public void set(E data, int index){
        if(validIndex(index) == false){
            throw new IndexOutOfBoundsException();
        }
        else array[index] = data;
    }

    private boolean validIndex(int index) {
        if(index > array.length - 1 || index > listLen - 1) {
            return false;
        }
        else return true;
    }

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
        listLen++;


    }

}

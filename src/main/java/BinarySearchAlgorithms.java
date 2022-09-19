package main.java;

public class BinarySearchAlgorithms {



    //Expected Input: Sorted integer array, and integer to search for
    //Expected Output: Index of input integer if it is found in array,
    //but if not found it will return -1.

    //Public facing method used to facilitate recursive version of the algorithm.
    //checks for valid inputs
    public int RecursiveBinarySearch(int[] array, int x){
        if(array.length <= 0) {
            return -1; //not valid
        }
        else return RecursiveBinarySearch(array, x, 0, array.length - 1);
    }


    //Private method called by the public method of the same name
    //Expected Input: Sorted integer array, and integer to search for.
    // Integers start and end are adjusted each time it is called.
    //Expected Output: Index of input integer if it is found in array,
    //but if not found it will return -1.
    private int RecursiveBinarySearch(int[] array, int x, int start, int end){
        if(start ==end) {
            if (array[start] == x) {
                return start;
            } else return -1; //not found
        }
        else {
            int mid = (start + end) / 2;
            if (array[mid] == x) {
                return mid;
            }
            else if (array[mid] > x) {
                return RecursiveBinarySearch(array, x, start, mid - 1);
            }
            else return RecursiveBinarySearch(array, x, mid + 1, end);
        }

    }



    //Expected Input: Sorted integer array, and integer to search for
    //Expected Output: Index of input integer if it is found in array,
    //but if not found it will return -1.

    //iterative version
    //meant as an alternative to the recursive version
    public int IterativeBinarySearch(int[] array, int x) {
        int mid = 0;
        int start = 0;
        int end = array.length - 1;

        if(array.length <= 0) {
            return -1; //not valid
        }
        else {

            while (start != end) {
                mid = (start + end) / 2;
                if (array[mid] == x) {
                    return mid;
                } else if (array[mid] > x) {
                    end = mid - 1;
                } else start = mid + 1;
            }
            if (array[start] == x) {
                return start;
            } else return -1; //not found

        }


    }





}
 
    


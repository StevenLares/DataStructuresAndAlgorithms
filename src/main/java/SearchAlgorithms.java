package main.java;/*
* Stores the search algorithms that can be used for
* integer arrays, trees, graphs, and heaps.
*
* */

public class SearchAlgorithms {

    //Used to facilitate recursive version of the algorithm.
    //This is public facing
    public int RecursiveBinarySearch(int[] array, int x){
        if(array.length <= 0) {
            return -1; //not valid
        }
        else return RecursiveBinarySearch(array, x, 0, array.length - 1);
    }


    //recursive version of the algorithm
    //this is the version that runs privately
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

    //iterative version
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
 
    


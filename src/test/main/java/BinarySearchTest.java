package test.main.java;

import main.java.BinarySearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void recursiveBinarySearch_oneEntry() {
        int[] arr = new int []{1};
        assertEquals(0, BinarySearch.RecursiveBinarySearch(arr, 1));

    }

    @Test
    void recursiveBinarySearch_twoEntries() {
        int[] arr = new int []{1,2};
        assertEquals(0, BinarySearch.RecursiveBinarySearch(arr, 1));
        assertEquals(1, BinarySearch.RecursiveBinarySearch(arr, 2));

    }

    @Test
    void recursiveBinarySearch_threeEntries() {
        int[] arr = new int []{1,2,3};
        assertEquals(0, BinarySearch.RecursiveBinarySearch(arr, 1));
        assertEquals(1, BinarySearch.RecursiveBinarySearch(arr, 2));
        assertEquals(2, BinarySearch.RecursiveBinarySearch(arr, 3));


    }

    @Test
    void recursiveBinarySearch_EightEntries() {
        int[] arr = new int []{1,2,3,4,5,6,7,8};
        assertEquals(0, BinarySearch.RecursiveBinarySearch(arr, 1));
        assertEquals(1, BinarySearch.RecursiveBinarySearch(arr, 2));
        assertEquals(2, BinarySearch.RecursiveBinarySearch(arr, 3));
        assertEquals(3, BinarySearch.RecursiveBinarySearch(arr, 4));
        assertEquals(4, BinarySearch.RecursiveBinarySearch(arr, 5));
        assertEquals(5, BinarySearch.RecursiveBinarySearch(arr, 6));
        assertEquals(6, BinarySearch.RecursiveBinarySearch(arr, 7));
        assertEquals(7, BinarySearch.RecursiveBinarySearch(arr, 8));

    }

    @Test
    void iterativeBinarySearch_oneEntry() {
        int[] arr = new int []{1};
        assertEquals(0, BinarySearch.IterativeBinarySearch(arr, 1));

    }

    @Test
    void iterativeBinarySearch_twoEntries() {
        int[] arr = new int []{1,2};
        assertEquals(0, BinarySearch.IterativeBinarySearch(arr, 1));
        assertEquals(1, BinarySearch.IterativeBinarySearch(arr, 2));

    }

    @Test
    void iterativeBinarySearch_threeEntries() {
        int[] arr = new int []{1,2,3};
        assertEquals(0, BinarySearch.IterativeBinarySearch(arr, 1));
        assertEquals(1, BinarySearch.IterativeBinarySearch(arr, 2));
        assertEquals(2, BinarySearch.IterativeBinarySearch(arr, 3));

    }

    @Test
    void iterativeBinarySearch_EightEntries() {
        int[] arr = new int []{1,2,3,4,5,6,7,8};
        assertEquals(0, BinarySearch.IterativeBinarySearch(arr, 1));
        assertEquals(1, BinarySearch.IterativeBinarySearch(arr, 2));
        assertEquals(2, BinarySearch.IterativeBinarySearch(arr, 3));
        assertEquals(3, BinarySearch.IterativeBinarySearch(arr, 4));
        assertEquals(4, BinarySearch.IterativeBinarySearch(arr, 5));
        assertEquals(5, BinarySearch.IterativeBinarySearch(arr, 6));
        assertEquals(6, BinarySearch.IterativeBinarySearch(arr, 7));
        assertEquals(7, BinarySearch.IterativeBinarySearch(arr, 8));

    }



}
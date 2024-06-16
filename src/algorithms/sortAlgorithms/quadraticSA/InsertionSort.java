package algorithms.sortAlgorithms.quadraticSA;

import algorithms.sortAlgorithms.*;
/*
The insertion sort algorithm is arguably the best O(n^2) sorting algorithm
It is still easier to understand like the rest of the O(n^2) algorithms
Insertion sort works by bringing the ith element to the left until the element left of i is smaller

Time complexity:
The best case for quick sort is O(n) if the array is already sorted
The average case is O(n^2)
The worst case is O(n^2)

Space complexity:
The space complexity is O(1)

Pros:
Very easy to understand compared to bubble sort!
Works very nicely with smaller arrays and nearly sorted arrays
It is a stable sort! (45a and 45b maintain relative positions)

Cons:
Not the best with larger arrays
Still less favourable than the recursive sorts
 */

public class InsertionSort {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) { // Start at i = 0 because we are comparing with j
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] unsortedArray = SortAlgorithmHelper.fillWithElements(1000,1,10);
        SortAlgorithmHelper.printArray(unsortedArray, false);
        SortAlgorithmHelper.startTime();
        insertionSort(unsortedArray);
        SortAlgorithmHelper.endTime();
        SortAlgorithmHelper.printArray(unsortedArray, true);
        SortAlgorithmHelper.printRuntime();
    }
}

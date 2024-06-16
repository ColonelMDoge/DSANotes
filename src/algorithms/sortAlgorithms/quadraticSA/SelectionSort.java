package algorithms.sortAlgorithms.quadraticSA;

import algorithms.sortAlgorithms.*;

/*
The selection sort algorithm is another popular sorting algorithm like bubble sort
It is also the contender for the most inefficient sorting algorithm with the same time complexity as bubble sort
Selection sort works by finding the smallest element and comparing it with the current element, then swapping if it is smaller

Time complexity:
The best case for quick sort is O(n^2) if the array is already sorted
The average case is O(n^2)
The worst case is O(n^2)

Space complexity:
The space complexity is O(1)

Pros:
Very easy to understand compared to bubble sort!
Works very nicely with smaller arrays

Cons:
It is the one of the most inefficient algorithm compared to other O(n^2) algorithms
Not the best with larger arrays
NOT A STABLE SORT!!! (45a and 45b in an array could end up as 45b and 45a)
 */

public class SelectionSort {
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minimum_index = i;
            for (int j = i + 1; j < array.length; j++) { // Find the minimum value and copy its index value
                if (array[j] < array[minimum_index]) {
                    minimum_index = j;
                }
            }
            // Swap the found minimum index with the current i position
            int temp = array[minimum_index];
            array[minimum_index] = array[i];
            array[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] unsortedArray = SortAlgorithmHelper.fillWithElements(1000,1,10);
        SortAlgorithmHelper.printArray(unsortedArray, false);
        SortAlgorithmHelper.startTime();
        selectionSort(unsortedArray);
        SortAlgorithmHelper.endTime();
        SortAlgorithmHelper.printArray(unsortedArray, true);
        SortAlgorithmHelper.printRuntime();
    }
}

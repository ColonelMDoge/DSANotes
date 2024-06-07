package sortAlgorithms.quadraticSA;

import sortAlgorithms.AlgorithmHelper;

/*
The bubble sort algorithm is one of the most well-known algorithms for being the easiest to understand
However, it is one of the inefficient sorting algorithms compared to others with the same time complexity
Bubble sorting checks two adjacent elements and swaps if one is less than the other

Time complexity:
The best case for quick sort is O(n) if the array is already sorted
The average case is O(n^2)
The worst case is O(n^2)

Space complexity:
The space complexity is O(1)

Pros:
Very easy to understand!
It is a stable sort! (45a and 45b maintain relative positions)

Cons:
It is the most inefficient algorithm compared to other O(n^2) algorithms
Not the best with larger arrays
 */

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) { // Loop ends until j < array.length - i - 1 due to the remaining i elements being sorted
                if (array[j] > array[j + 1]) { // Swaps the elements at j and j + 1
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] unsortedArray = AlgorithmHelper.fillWithElements(1000,1,10);
        AlgorithmHelper.printArray(unsortedArray, false);
        AlgorithmHelper.startTime();
        bubbleSort(unsortedArray);
        AlgorithmHelper.endTime();
        AlgorithmHelper.printArray(unsortedArray, true);
        AlgorithmHelper.printRuntime();
    }
}

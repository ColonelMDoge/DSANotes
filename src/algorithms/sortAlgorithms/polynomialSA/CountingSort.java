package algorithms.sortAlgorithms.polynomialSA;

import algorithms.sortAlgorithms.*;

/*
The counting sort algorithm is an interesting approach to sorting without comparing values
Counting sort calculates each occurrence of a value and determines the correct position to place it in

Time complexity:
The time complexity throughout is O(n + m), n and m being the size of the arrays

Space complexity:
The space complexity is also O(n + m)

Pros:
Time complexity usually beats the comparison sorting algorithms!
It is a stable sort! (45a and 45b maintain relative positions)

Cons:
Does not work with decimals as we use integer index numbers
Not the best with a large range of numbers (increases the space required)
 */

public class CountingSort {
    public static void countingSort(int[] array) {
        int max = 0;
        for (int j : array) { // Find the max number to determine length of countArray
            max = Math.max(max, j);
        }
        int[] countArray = new int[max + 1];
        for (int j : array) {
            countArray[j]++; // Increase the occurrence of each value
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i] + countArray[i - 1]; // Add the previous index value to itself
        }
        int[] outputArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) { // Starting from the end keeps the sort stable
            outputArray[countArray[array[i]] - 1] = array[i]; // Places the value of index i to the correct position
            countArray[array[i]]--; // Subtracts the count to place identical values consecutively
        }
        System.arraycopy(outputArray, 0, array, 0, array.length);
    }
    public static void main(String[] args) {
        int[] unsortedArray = SortAlgorithmHelper.fillWithElements(1000,1,10);
        SortAlgorithmHelper.printArray(unsortedArray, false);
        SortAlgorithmHelper.startTime();
        countingSort(unsortedArray);
        SortAlgorithmHelper.endTime();
        SortAlgorithmHelper.printArray(unsortedArray, true);
        SortAlgorithmHelper.printRuntime();
    }
}


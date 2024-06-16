package algorithms.sortAlgorithms.loglinearSA;

import algorithms.sortAlgorithms.*;

/*
The quick sort algorithm is a recursive divide and conquer method to sort an array using a pivot.
The pivot's final position is determined so that all elements left of it are equal or smaller to itself
and all elements right of it are greater than or equal to itself.
We recursively call the quickSort algorithm on the two sub-arrays left and right of the pivot, using a partition method
The base case is when the end index is less than or equal to the start, meaning that the given sub-array cannot be further divided

Time complexity:
The best case for quick sort is O(n log n)
The average case is O(n log n) making quick sort the very popular choice
The worst case is O(n^2) when the elements are already sorted

Space complexity:
Without the recursive call, the space complexity is O(1)
With the recursive calls, the space complexity at worse is O(n)

Pros:
Divide and conquer with recursion!
Very efficient for large arrays!

Cons:
If the pivot is chosen poorly the time complexity becomes O(n^2)
Not the best with smaller arrays
NOT A STABLE SORT!!! (45a and 45b in an array could end up as 45b and 45a)
 */

public class QuickSort { // "Last element is the pivot" strategy
    public static void quickSort(int[] array, int start, int end) {
        if (end <= start) return;
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    public static int partition(int[] array, int start_partition_index, int end_partition_index) {
        int pivot = array[end_partition_index]; // The pivot we choose is the last element of the partition
        int i = start_partition_index - 1; // i is the start index minus 1
        for (int j = start_partition_index; j <= end_partition_index; j++) {
            if (array[j] < pivot) { // Swap i and j if array[j] is less than the pivot
                i++; // Increase i by one (Also ensures if the array[j] is the first element i will not be out of bounds)
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        i++; // Increase i by one because the pivot's location is the array[i + 1]
        int temp = array[i];
        array[i] = array[end_partition_index];
        array[end_partition_index] = temp;
        return i; // return the index of the correctly placed pivot
    }
    public static void main(String[] args) {
        int[] unsortedArray = SortAlgorithmHelper.fillWithElements(1000,1,10);
        SortAlgorithmHelper.printArray(unsortedArray, false);
        SortAlgorithmHelper.startTime();
        quickSort(unsortedArray, 0 , unsortedArray.length - 1);
        SortAlgorithmHelper.printArray(unsortedArray, true);
        SortAlgorithmHelper.printRuntime();
    }
}

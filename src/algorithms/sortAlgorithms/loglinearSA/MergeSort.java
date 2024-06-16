package algorithms.sortAlgorithms.loglinearSA;

import algorithms.sortAlgorithms.*;

/*
The merge sort algorithm is a popular divide and conquer sorting algorithm
It works by continuously dividing an array into smaller sub-arrays until a sub-array is of length 1 or 2
Then it swaps the small array to sort it
After it continuously re-merges two sub-arrays back up until the entire array is sorted

Time complexity:
The time complexity throughout for merge sort is O(n log n)

Space complexity:
The extra space required during merge sort takes O(n) space

Pros:
Divide and conquer with recursion!
Very efficient for large arrays!
It is a stable sort! (45a and 45b maintain relative positions)

Cons:
Requires extra space to store the values (the temp array)
 */

public class MergeSort {
    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) { // Base case
            int mid = (start + end) / 2; // Gets the midpoint to "split" the given subarray into two
            mergeSort(array, start, mid); // Continuously divides the left subarray
            mergeSort(array, mid + 1, end); // Continuously divides the right subarray
            merge(array, start, mid, end); // Merges the sub-arrays from the bottom to top.
        }
    }
    private static void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[array.length];
        int leftSubPos = start; // The position of the "left" subarray
        int rightSubPos = mid + 1; // The position of the "right" subarray
        int positionToReplace = start; // The position of the temp array where to place sorted values

        while (!(leftSubPos > mid && rightSubPos > end)) { // Continously merge until the leftSubPos is exhausted or until rightSubPos is exhausted
            if ((leftSubPos > mid) || ((rightSubPos <= end) && (array[rightSubPos] < array[leftSubPos]))) {
                temp[positionToReplace] = array[rightSubPos];
                rightSubPos++;
            } else {
                temp[positionToReplace] = array[leftSubPos];
                leftSubPos++;
            }
            positionToReplace++; // After determining the smallest value, go to the next position of the temp array
        }

        // Copies the temp array to the original array
        if (end + 1 - start >= 0) System.arraycopy(temp, start, array, start, end + 1 - start);
    }
    public static void main(String[] args) {
        int[] unsortedArray = SortAlgorithmHelper.fillWithElements(1000,1,10);
        SortAlgorithmHelper.printArray(unsortedArray, false);
        SortAlgorithmHelper.startTime();
        mergeSort(unsortedArray, 0 , unsortedArray.length - 1);
        SortAlgorithmHelper.endTime();
        SortAlgorithmHelper.printArray(unsortedArray, true);
        SortAlgorithmHelper.printRuntime();
    }
}

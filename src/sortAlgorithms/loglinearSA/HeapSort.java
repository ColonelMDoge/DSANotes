package sortAlgorithms.loglinearSA;

import sortAlgorithms.AlgorithmHelper;

/*
The heap sort algorithm is a well known sorting algorithm that uses the heap data structure to sort elements
The heap binary tree ensures that the largest value is the root node, while its child nodes are less or equal to itself
By retrieving the root node and heapify the affected binary tree, we can keep grabbing the next element

Time complexity:
The time complexity throughout for heap sort is O(n log n) making it a nice go-to sorting algorithm

Space complexity:
Without the recursive call, the space complexity is O(1)
With the recursive calls, the space complexity at worse is O(n)

Pros:
Very simple to understand a binary tree!
Very efficient for large arrays!

Cons:
Not the best with complex data
NOT A STABLE SORT!!! (45a and 45b in an array could end up as 45b and 45a)
 */

public class HeapSort {
    public static void heapSort(int[] array) {
        int length = array.length;
        // Heapify the array
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }
        // Retrieve the root node as it is now the largest, then heapify the subtree after
        for (int i = length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }
    public static void heapify(int[] array, int length, int index) {
        int root_index = index; // The root node will be the current index of the subtree for now
        int left_node = 2 * index + 1; // The left child node
        int right_node = 2 * index + 2; // The right child node
        if (left_node < length && array[left_node] > array[root_index]) { // Set the root index to the left child node
            root_index = left_node;
        }
        if (right_node < length && array[right_node] > array[root_index]) { // Set the root index to the right child node
            root_index = right_node;
        }
        // If the root index is not the current root of the subtree we must swap them as the current root is smaller than its child node
        if (root_index != index) {
            int temp = array[root_index];
            array[root_index] = array[index];
            array[index] = temp;
            heapify(array, length, root_index);
        }
    }
    public static void main(String[] args) {
        int[] unsortedArray = AlgorithmHelper.fillWithElements(1000,1,10);
        AlgorithmHelper.printArray(unsortedArray, false);
        AlgorithmHelper.startTime();
        heapSort(unsortedArray);
        AlgorithmHelper.endTime();
        AlgorithmHelper.printArray(unsortedArray, true);
        AlgorithmHelper.printRuntime();
    }
}

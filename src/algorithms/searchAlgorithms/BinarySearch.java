package algorithms.searchAlgorithms;

/*
The binary search algorithm is the most well known searching algorithm to find an index of the given target element
It works by retrieving the middle element of the array and comparing it with the target
If the middle element is too large or too small than the target, then the search is reduced

Time complexity:
The average time complexity for binary search is O(log n)

Space complexity:
The space complexity is O(1) for iterating version of the binary search
 */
public class BinarySearch {
    public static int binarySearch(int[] array, int elementToBeFound) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (start + end) / 2; // Middle element of the sub-array
            if (array[mid] == elementToBeFound) return mid;
            else if (array[mid] > elementToBeFound) end = mid - 1;
            else start = mid + 1;
        }
        return -1; // Return -1 if the value does not exist
    }
    public static void main(String[] args) {
        int[] sortedArray = {4,19,28,34,103,294,295,481,511,543,583,677,679,680,694,782};
        int target = 34;
        for (int element : sortedArray) {
            System.out.print(element + " ");
        }
        System.out.println();
        int foundIndex = binarySearch(sortedArray, target);
        System.out.println("Index of target " + target + " is: " + foundIndex);
    }
}

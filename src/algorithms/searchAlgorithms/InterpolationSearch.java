package algorithms.searchAlgorithms;

/*
The interpolation search algorithm is is similar to binary search to find an index of the given target element
It works by calculating a probe and comparing it to the target based on the location of the target
If the target is near a certain area of the array, the search algorithm will search near there

Time complexity:
The average time complexity for interpolation search is O(log(log n)) for uniformly distributed data
The worst case is O(n) is the values increase exponentially

Space complexity:
The space complexity is O(1)
 */

public class InterpolationSearch {
    public static int interpolationSearch(int[] array, int target) {
        int end = array.length - 1;
        int start = 0;
        while (target >= array[start] && target <= array[end] && start <= end) {
            int probe = start + (end - start) * (target - array[start]) / (array[end] - array[start]);
            if (array[probe] == target) return probe;
            else if (probe > target) end = probe - 1;
            else start = probe + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] sortedArray = {3,6,9,12,15,18,21,24,27,30,33,36,39,42,45,48,51,54,57,60};
        int target = 42;
        for (int element : sortedArray) {
            System.out.print(element + " ");
        }
        System.out.println();
        int foundIndex = interpolationSearch(sortedArray, target);
        System.out.println("Index of target " + target + " is: " + foundIndex);
    }
}

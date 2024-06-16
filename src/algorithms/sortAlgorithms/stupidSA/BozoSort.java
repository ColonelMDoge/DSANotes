package algorithms.sortAlgorithms.stupidSA;

import algorithms.sortAlgorithms.*;

/*
The bozo sort is another funky inefficient sorting algorithm relying on RNGesus
Similar to bogo sort, it randomly swaps two elements until the array is sorted
Pray to RNGesus for this algorithm to work in your favour

Time complexity:
The best case for quick sort is O(n) if the array if the shuffle magically sorts your algorithm first try
The average case is O(n*n!)
The worst case is O(INFINITY AND BEYOND!) because it could swap forever

Space complexity:
The space complexity is O(1)

Pros:
Another easy to understand algorithm!
On average it is better than bogo sort!

Cons:
RNGesus is never in your favour, so it is still a bad sorting algorithm
Takes the timespan of the sun to sort a large array
 */

public class BozoSort {
    public static void bozoSort(int[] array) {
        while (SortAlgorithmHelper.isSorted(array)) {
            // Get random indices and swap their elements
            int randomIndex1 = (int)(Math.random()*array.length);
            int randomIndex2 = (int)(Math.random()*array.length);
            int temp = array[randomIndex1];
            array[randomIndex1] = array[randomIndex2];
            array[randomIndex2] = temp;
        }
    }
    public static void main(String[] args) {
        int[] unsortedArray = SortAlgorithmHelper.fillWithElements(10,1,10);
        SortAlgorithmHelper.printArray(unsortedArray, false);
        SortAlgorithmHelper.startTime();
        bozoSort(unsortedArray);
        SortAlgorithmHelper.endTime();
        SortAlgorithmHelper.printArray(unsortedArray, true);
        SortAlgorithmHelper.printRuntime();
    }
}

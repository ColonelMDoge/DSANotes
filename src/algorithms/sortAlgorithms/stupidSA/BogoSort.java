package algorithms.sortAlgorithms.stupidSA;

import algorithms.sortAlgorithms.*;
import java.util.Random;

/*
The bogo sort algorithm is one of the funny sorts, as it is known for being one of the worst sorting algorithms
Basically, continuously shuffle the array until it is magically sorted
Pray to RNGesus for this algorithm to work in your favour

Time complexity:
The best case for quick sort is O(n) if the array if the shuffle magically sorts your algorithm first try
The average case is O(n*n!)
The worst case is O(INFINITY AND BEYOND!) because it could shuffle forever

Space complexity:
The space complexity is O(1)

Pros:
Funny sorting algorithm and truly the easiest to understand
Theoretically could sort it in one try, making this theoretically the best sorting algorithm

Cons:
RNGesus is never in your favour, so it is still a bad sorting algorithm
Takes the timespan of the universe to sort a large array
 */

public class BogoSort {
    public static void bogoSort(int[] array) {
        while(!SortAlgorithmHelper.isSorted(array)) {
            // Fisher-Yates algorithm for shuffling an array
            Random random = new Random();
            for (int i = array.length - 1; i > 0; i--) {
                int index = random.nextInt(i + 1);
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] unsortedArray = SortAlgorithmHelper.fillWithElements(10,1,10);
        SortAlgorithmHelper.printArray(unsortedArray, false);
        SortAlgorithmHelper.startTime();
        bogoSort(unsortedArray);
        SortAlgorithmHelper.endTime();
        SortAlgorithmHelper.printArray(unsortedArray, true);
        SortAlgorithmHelper.printRuntime();
    }
}

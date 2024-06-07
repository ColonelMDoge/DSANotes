package sortAlgorithms.stupidSA;

import sortAlgorithms.AlgorithmHelper;
import java.util.Arrays;

/*
The stalin sort algorithm is one of the funny sorts, as it is known for technically sorting an array by removing elements out of place
Basically, purge any element that is less than the element to the left of itself
This ensures that all elements will be sorted after removing the "outliers"

Time complexity:
The average case throughout for stalin sort is O(n), traversing through the array once

Space complexity:
The space complexity is O(n) because we need a temporary array to store the new values

Pros:
Funny sorting algorithm and purges any element that is deemed out of place
Sorts the algorithm in O(n) time and is the best if you disregard the loss of elements

Cons:
You lose a lot of the original elements
 */

public class StalinSort {
    public static int[] stalinSort(int[] array) {
        int[] newArray = new int[array.length];
        int newArrayIndex = 1;
        newArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (newArray[newArrayIndex - 1] <= array[i]) { // Checks if the array[i] is larger than what is currently in the temp array
                newArray[newArrayIndex] = array[i];
                newArrayIndex++;
            }
        }
        return Arrays.copyOfRange(newArray, 0, newArrayIndex);
    }
    public static void main(String[] args) {
        int[] unsortedArray = AlgorithmHelper.fillWithElements(1000,1,10);
        AlgorithmHelper.printArray(unsortedArray, false);
        AlgorithmHelper.startTime();
        unsortedArray = stalinSort(unsortedArray);
        AlgorithmHelper.endTime();
        AlgorithmHelper.printArray(unsortedArray, true);
        AlgorithmHelper.printRuntime();
    }
}

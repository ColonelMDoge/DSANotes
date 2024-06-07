package sortAlgorithms.polynomialSA;

/*
The radix sort algorithm is another interesting way to sort an array
It works by using each place value and sorting the individual columns (ones, tens, hundreds, etc)
The algorithm uses counting sort for each place value

Time complexity:
The time complexity throughout is O(d(n + b)), d being number of digits, n is the number of elements, and b being the number system base

Space complexity:
The space complexity is O(n + b) to recopy the output of size n back into the original after each place value, b, has been sorted

Pros:
Time complexity usually beats the comparison sorting algorithms!
It is a stable sort due to counting sort also being stable! (45a and 45b maintain relative positions)

Cons:
Uses counting sort, so the cons of it apply here as well
 */

import sortAlgorithms.AlgorithmHelper;

public class RadixSort {
    public static int getMaxNum(int[] arr) {
        int max = 0;
        for (int j : arr) { // Find the max number to determine length of countArray
            max = Math.max(max, j);
        }
        return max;
    }
    public static void countingSort(int[] array, int exponent) {
        int[] countArray = new int[10]; // Count will now be a length of 10 because each place value could be 0 to 9
        for (int j : array) {
            countArray[(j / exponent) % 10]++; // Increase the occurrence of each place value
        }
        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i - 1]; // Add the previous index value to itself
        }
        int[] outputArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) { // Starting from the end keeps the sort stable
            outputArray[countArray[(array[i] / exponent) % 10] - 1] = array[i]; // Places the value of index i to the correct position
            countArray[(array[i] / exponent) % 10]--; // Subtracts the count to place identical values consecutively
        }
        System.arraycopy(outputArray, 0, array, 0, array.length);
    }
    public static void radixSort(int[] array) {
        int maxNum = getMaxNum(array);
        for (int exponent = 1; maxNum / exponent > 0; exponent *= 10) {
            countingSort(array, exponent);
        }
    }
    public static void main(String[] args) {
        int[] unsortedArray = AlgorithmHelper.fillWithElements(1000,1,10);
        AlgorithmHelper.printArray(unsortedArray, false);
        AlgorithmHelper.startTime();
        radixSort(unsortedArray);
        AlgorithmHelper.endTime();
        AlgorithmHelper.printArray(unsortedArray, true);
        AlgorithmHelper.printRuntime();
    }
}

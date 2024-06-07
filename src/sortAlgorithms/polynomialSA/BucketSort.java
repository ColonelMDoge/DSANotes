package sortAlgorithms.polynomialSA;

import sortAlgorithms.AlgorithmHelper;

/*
The bucket sort algorithm is another interesting way to sort values
Bucket sort works by adding the value to a list array at the index of the integer cast of itself times ten
The individual lists (buckets) will then be sorted using any sorting algorithm desired
In this approach, decimal values are used in a range between n and n+1
This approach also uses insertion sort to sort each bucket

Time Complexity:
The best case is O(n + k) due to n being number of elements and k being the time it takes to sort the buckets
The average case is O(n + k) as well
The worst case will always be the worst case of the sorting algorithm used for each bucket
This is due to the chance that all elements are placed in one bucket
Since this approach uses insertion sort, the worst case will be O(n^2)

Space Complexity:
The space complexity is also O(n + k)

Pros:
Unique for using buckets to sort an array!
It is a stable sort due to insertion sort also being stable! (45a and 45b maintain relative positions)

Cons:
Required more space due to the creation of each individual bucket
Less uniformity of the elements will near the worst case as more elements are in less buckets
 */
import java.util.*;
public class BucketSort {
    public static void insertionSort(List<Double> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(i)) {
                    double temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                }
            }
        }
    }
    public static void bucketSort(double[] array) {
        @SuppressWarnings("unchecked")
        List<Double>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>(); // Create each bucket
        }
        for (double element : array) {
            buckets[(int) (buckets.length * element)].add(element); // Add element to the index of the int value of itself times 10
        }
        for (List<Double> bucket : buckets) { // Sort each bucket
            insertionSort(bucket);
        }
        int index = 0;
        for (List<Double> bucket : buckets) { // Copy each bucket back to the original array
            for (Double element : bucket) {
                array[index] = element;
                index++;
            }
        }
    }
    public static void main(String[] args) {
        double[] unsortedArray = AlgorithmHelper.fillWithElements(1000,0.0,0.99);
        AlgorithmHelper.printArray(unsortedArray, false);
        AlgorithmHelper.startTime();
        bucketSort(unsortedArray);
        AlgorithmHelper.endTime();
        AlgorithmHelper.printArray(unsortedArray, true);
        AlgorithmHelper.printRuntime();
    }
}


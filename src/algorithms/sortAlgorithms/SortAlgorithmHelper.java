package algorithms.sortAlgorithms;

public class SortAlgorithmHelper {
    private static long previousTime;
    public static int[] fillWithElements(int size, int from, int to) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (to - from + 1) + from);
        }
        return array;
    }
    public static double[] fillWithElements(int size, double from, double to) {
        double[] array = new double[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(String.format("%.2f",Math.random() * (to - from) + from));
        }
        return array;
    }
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) return false;
        }
        return true;
    }
    public static void printArray(int[] array, boolean sorted) {
        if (sorted) System.out.print("Sorted array: ");
        else System.out.print("Unsorted array: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void printArray(double[] array, boolean sorted) {
        if (sorted) System.out.print("Sorted array: ");
        else System.out.print("Unsorted array: ");
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void startTime() {
        previousTime = System.currentTimeMillis();
    }
    public static void endTime() {
        previousTime = System.currentTimeMillis() - previousTime;
    }
    public static void printRuntime() {
        System.out.println("The algorithm took: " + previousTime + " milliseconds");
    }
}

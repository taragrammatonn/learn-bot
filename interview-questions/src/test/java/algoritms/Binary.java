package algoritms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Binary {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);


            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            int i1 = arr[j];
            if (i1 < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;


        return i + 1;
    }

    static int binarySearch(int[] ints, int i) {

        int low = 0;
        int high = ints.length - 1;

        int tryCount = 0;
        while (low <= high) {
            tryCount++;
            int mid = (low + high) / 2;

            int guess = ints[mid];

            if (guess == i) {
                System.out.println(tryCount);
                return guess;
            }

            if (guess > i)
                high = mid - 1;
             else
                 low = mid + 1;
        }

        return 0;
    }
}

package Week4;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Sorts {
    public static int[] selectionSort (int[] arr){
        for (int i = 0; i < arr.length; i++){
            int currMin = -1;
            int currIndex = -1;
            for (int n = i; n < arr.length; n++){
                if (currIndex == -1 || currMin > arr[n]){
                    currIndex = n;
                    currMin = arr[n];
                }
            }
            int temp = arr[currIndex];
            arr[currIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static int[] bubbleSort (int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            boolean swapped = false;
            for (int n = 0; n < arr.length - i - 1; n++){
                if (arr[n] > arr[n+1]){
                    int temp = arr[n+1];
                    arr[n+1] = arr[n];
                    arr[n] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                return arr;
            }
        }
        return arr;
    }

    public static int[] insertionSort (int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int n = i - 1;
            while (n >= 0 && arr[n] > temp) {
                arr[n+1] = arr[n];
                n--;
            }
            arr[n+1] = temp;
        }
        return arr;
    }

    public static boolean sorted(int[] arr){
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < arr[i - 1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("Selection Sort:");
        double sum = 0;
        for (int i = 0; i < 3; i++){
            In in = new In("Algorithm/data/8Kints.txt");
            String[] text = in.readAllStrings();
            int[] input = Arrays.stream(text).mapToInt(Integer::parseInt).toArray();
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (8Kints.txt): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            In in = new In("Algorithm/data/16Kints.txt");
            String[] text = in.readAllStrings();
            int[] input = Arrays.stream(text).mapToInt(Integer::parseInt).toArray();
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (16Kints.txt): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            In in = new In("Algorithm/data/32Kints.txt");
            String[] text = in.readAllStrings();
            int[] input = Arrays.stream(text).mapToInt(Integer::parseInt).toArray();
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (32Kints.txt): " + (sum / 1000000 / 3) + " ms");

        System.out.println("----------");

        sum = 0;
        for (int i = 0; i < 5; i++){
            int[] input = IntStream.rangeClosed(1, 8000).toArray();
            StdRandom.shuffle(input);
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (8K random): " + (sum / 1000000 / 5) + " ms");

        sum = 0;
        for (int i = 0; i < 5; i++){
            int[] input = IntStream.rangeClosed(1, 16000).toArray();
            StdRandom.shuffle(input);
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (16K random): " + (sum / 1000000 / 5) + " ms");

        sum = 0;
        for (int i = 0; i < 5; i++){
            int[] input = IntStream.rangeClosed(1, 32000).toArray();
            StdRandom.shuffle(input);
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (32K random): " + (sum / 1000000 / 5) + " ms");

        System.out.println("----------");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = IntStream.rangeClosed(1, 8000).toArray();
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (8K sorted): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = IntStream.rangeClosed(1, 16000).toArray();
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (16K sorted): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = IntStream.rangeClosed(1, 32000).toArray();
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (32K sorted): " + (sum / 1000000 / 3) + " ms");

        System.out.println("----------");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = IntStream.rangeClosed(1, 8000).map(n -> 8000 + 1 - n).toArray();
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (8K reversed): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = IntStream.rangeClosed(1, 16000).map(n -> 16000 + 1 - n).toArray();
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (16K reversed): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = IntStream.rangeClosed(1, 32000).map(n -> 32000 + 1 - n).toArray();
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (32K reversed): " + (sum / 1000000 / 3) + " ms");

        System.out.println("----------");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = new int[8000];
            Arrays.fill(input, 100);
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (8K all 100): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = new int[16000];
            Arrays.fill(input, 100);
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (16K all 100): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = new int[32000];
            Arrays.fill(input, 100);
            double start = System.nanoTime();
            Sorts.selectionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (32K all 100): " + (sum / 1000000 / 3) + " ms");

        System.out.println("----------");
        System.out.println("----------");

        System.out.println("Insertion Sort:");
        sum = 0;
        for (int i = 0; i < 3; i++){
            In in = new In("Algorithm/data/8Kints.txt");
            String[] text = in.readAllStrings();
            int[] input = Arrays.stream(text).mapToInt(Integer::parseInt).toArray();
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (8Kints.txt): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            In in = new In("Algorithm/data/16Kints.txt");
            String[] text = in.readAllStrings();
            int[] input = Arrays.stream(text).mapToInt(Integer::parseInt).toArray();
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (16Kints.txt): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            In in = new In("Algorithm/data/32Kints.txt");
            String[] text = in.readAllStrings();
            int[] input = Arrays.stream(text).mapToInt(Integer::parseInt).toArray();
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (32Kints.txt): " + (sum / 1000000 / 3) + " ms");

        System.out.println("----------");

        sum = 0;
        for (int i = 0; i < 5; i++){
            int[] input = IntStream.rangeClosed(1, 8000).toArray();
            StdRandom.shuffle(input);
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (8K random): " + (sum / 1000000 / 5) + " ms");

        sum = 0;
        for (int i = 0; i < 5; i++){
            int[] input = IntStream.rangeClosed(1, 16000).toArray();
            StdRandom.shuffle(input);
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (16K random): " + (sum / 1000000 / 5) + " ms");

        sum = 0;
        for (int i = 0; i < 5; i++){
            int[] input = IntStream.rangeClosed(1, 32000).toArray();
            StdRandom.shuffle(input);
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (32K random): " + (sum / 1000000 / 5) + " ms");

        System.out.println("----------");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = IntStream.rangeClosed(1, 8000).toArray();
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (8K sorted): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = IntStream.rangeClosed(1, 16000).toArray();
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (16K sorted): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = IntStream.rangeClosed(1, 32000).toArray();
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (32K sorted): " + (sum / 1000000 / 3) + " ms");

        System.out.println("----------");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = IntStream.rangeClosed(1, 8000).toArray();
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (8K reversed): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = IntStream.rangeClosed(1, 16000).toArray();
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (16K reversed): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = IntStream.rangeClosed(1, 32000).map(n -> 32000 + 1 - n).toArray();
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (32K reversed): " + (sum / 1000000 / 3) + " ms");

        System.out.println("----------");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = new int[8000];
            Arrays.fill(input, 100);
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (8K all 100): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = new int[16000];
            Arrays.fill(input, 100);
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (16K all 100): " + (sum / 1000000 / 3) + " ms");

        sum = 0;
        for (int i = 0; i < 3; i++){
            int[] input = new int[32000];
            Arrays.fill(input, 100);
            double start = System.nanoTime();
            Sorts.insertionSort(input);
            double end = System.nanoTime();
            sum += end - start;
        }
        System.out.println("Average Time (32K all 100): " + (sum / 1000000 / 3) + " ms");
    }
}
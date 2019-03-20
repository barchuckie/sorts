import comparators.AscendingComparator;
import comparators.DescendingComparator;
import it.unimi.dsi.util.XoShiRo256StarStarRandom;
import sort.*;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sorter {

    private Sort getSortFromString(String type, int[] array) {
        switch (type) {
            case "select":
                return new SelectSort(array);
            case "insert":
                return new InsertionSort(array);
            case "heap":
                return new HeapSort(array);
            case "quick":
                return new QuickSort(array);
            case "mquick":
                return new ModifiedQuickSort(array);
            default:
                ErrPrinter.printUsage();
                System.exit(0);
                return null;
        }
    }

    private Comparator<Integer> getComparator(boolean asc) {
        if(asc) {
            return new AscendingComparator();
        } else {
            return new DescendingComparator();
        }
    }

    private boolean checkSorting(int[] model, int[] array, boolean asc) {
        boolean isDifferent = false;
        if(asc) {
            for (int i = 0; i < array.length; i++) {
                if(model[i] != array[i]) {
                    isDifferent = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if(model[array.length - 1 - i] != array[i]) {
                    isDifferent = true;
                    break;
                }
            }
        }
        return isDifferent;
    }

    public void runSorting(String type, boolean asc) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert number of keys: ");
        int length = scanner.nextInt();
        int[] array = new int[length];

        System.out.println("Insert keys: ");

        for(int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

        Sort sort = getSortFromString(type, array);
        Comparator<Integer> comparator = getComparator(asc);

        int[] model = Arrays.copyOf(array, length);

        int[] sortedArray = sort.sort(comparator);
        Arrays.sort(model);

        if(checkSorting(model, array, asc)) {
            System.out.println("Array sorted incorrectly.");
        } else {
            System.out.println("Array sorted correctly.");
        }

        System.out.println("Number of sorted elements: " + sort.getSwapCounter());

        for (int key : sortedArray) {
            System.out.print(key + " ");
        }
        System.out.println();
    }

    public void runStatistics(String fileName, int repeats) {
        XoShiRo256StarStarRandom rand = new XoShiRo256StarStarRandom();

        try(PrintWriter writer = new PrintWriter(fileName, StandardCharsets.UTF_8)) {

            for (int n = 100; n <= 10000; n += 100) {
                for(int i = 0; i < repeats; i++) {
                    int[] array = new int[n];
                    for (int j = 0; j < n; j++) {
                        array[j] = rand.nextInt();
                    }

                    StatisticsRunner runner = new StatisticsRunner(writer);
                    Comparator<Integer> comparator = new AscendingComparator();

                    Sort heapSort = new HeapSort(Arrays.copyOf(array, n));
                    runner.run(n, heapSort, comparator);

                    Sort insertionSort = new InsertionSort(Arrays.copyOf(array, n));
                    runner.run(n, insertionSort, comparator);

                    Sort modifiedQuickSort = new ModifiedQuickSort(Arrays.copyOf(array, n));
                    runner.run(n, modifiedQuickSort, comparator);

                    Sort quickSort = new QuickSort(Arrays.copyOf(array, n));
                    runner.run(n, quickSort, comparator);

                    Sort selectSort = new SelectSort(Arrays.copyOf(array, n));
                    runner.run(n, selectSort, comparator);

                    writer.println();
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}

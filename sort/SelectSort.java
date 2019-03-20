package sort;

import java.util.Comparator;

public class SelectSort extends Sort {

    public SelectSort(int[] array) {
        super(array);
    }

    @Override
    void sortArray(Comparator<Integer> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                //ErrPrinter.printCompare(array[j], array[min]);
                increaseCompareCounter();
                if (comparator.compare(array[j], array[min]) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                swap(i, min);
            }
        }
    }
}

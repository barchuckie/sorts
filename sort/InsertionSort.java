package sort;

import java.util.Comparator;

public class InsertionSort extends Sort {

    public InsertionSort(int[] array) {
        super(array);
    }

    @Override
    void sortArray(Comparator<Integer> comparator) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;

            //ErrPrinter.printCompare(i + " (index)", 0 + "");
            //ErrPrinter.printCompare(array[i], key);
            increaseCompareCounter();
            increaseCompareCounter();
            while (i >= 0 && comparator.compare(array[i], key) > 0) {
                //ErrPrinter.printSwap(array[i+1], array[i]);
                increaseSwapCounter();
                array[i + 1] = array[i];
                i--;
            }

            array[i + 1] = key;
        }
    }
}

package sort;

import java.util.Comparator;

public class ModifiedQuickSort extends QuickSort {

    public ModifiedQuickSort(int[] array) {
        super(array);
    }

    @Override
    protected int choosePartitionValue(int p, int r) {
        int median = array[(p + r)/2];

        if(median > array[p] && median > array[r]) {
            if(array[p] > array[r]) {
                median = array[p];
            } else {
                median = array[r];
            }
        }

        return median;
    }

    @Override
    protected void quickSort(int p, int r, Comparator<Integer> c) {
        if(p + 15 < r) {
            int q = partition(p, r, c);
            quickSort(p, q, c);
            quickSort(q + 1, r, c);
        } else {
            for (int j = p + 1; j < r + 1; j++) {
                int key = array[j];
                int i = j - 1;

                //ErrPrinter.printCompare(i + " (index)", 0 + "");
                //ErrPrinter.printCompare(array[i], key);
                increaseCompareCounter();
                increaseCompareCounter();
                while (i >= p && c.compare(array[i], key) > 0) {
                    //ErrPrinter.printSwap(array[i+1], array[i]);
                    increaseSwapCounter();
                    array[i + 1] = array[i];
                    i--;
                }

                array[i + 1] = key;
            }
        }
    }
}

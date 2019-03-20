package sort;

import java.util.Comparator;

public class QuickSort extends Sort {

    public QuickSort(int[] array) {
        super(array);
    }

    @Override
    void sortArray(Comparator<Integer> comparator) {
        quickSort(0, array.length - 1, comparator);
    }

    protected void quickSort(int p, int r, Comparator<Integer> c) {
        if(p < r) {
            int q = partition(p, r, c);
            quickSort(p, q, c);
            quickSort(q + 1, r, c);
        }
    }

    protected int choosePartitionValue(int p, int r) {
        return array[p];
    }

    protected int partition(int p, int r, Comparator<Integer> c) {
        int x = choosePartitionValue(p, r);
        int i = p - 1;
        int j = r + 1;

        while(true) {

            do {
                j--;
                //ErrPrinter.printCompare(array[j], x);
                increaseCompareCounter();
            } while (c.compare(array[j], x) > 0);

            do {
                i++;
                //ErrPrinter.printCompare(array[i], x);
                increaseCompareCounter();
            } while (c.compare(array[i], x) < 0);

            if(i < j) {
                swap(i, j);
            } else {
                return j;
            }

        }
    }
}

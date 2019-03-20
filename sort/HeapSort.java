package sort;

import java.util.Comparator;

public class HeapSort extends Sort {

    private int heapSize;

    public HeapSort(int[] array) {
        super(array);
        heapSize = 0;
    }

    @Override
    void sortArray(Comparator<Integer> comparator) {
        buildHeap(comparator);

        for(int i = array.length-1; i > 0; --i) {
            swap(0, i);

            heapSize--;
            heapify(0, comparator);
        }
    }

    private int parent(int i) {
        return i/2;
    }

    private int left(int i) {
        return 2*(i+1)-1;
    }

    private int right(int i) {
        return 2*(i+1);
    }

    private void heapify(int i, Comparator<Integer> c) {
        int left = left(i);
        int right = right(i);
        int largest;

        //ErrPrinter.printCompare(left + " (left child idx)", heapSize + " (heapSize)");
        increaseCompareCounter();
        if (left < heapSize) {
            //ErrPrinter.printCompare(array[i], array[left]);
            increaseCompareCounter();
            if (c.compare(array[left], array[i]) > 0) largest = left;
            else largest = i;
        } else largest = i;

        //ErrPrinter.printCompare(right + " (right child idx)", heapSize + " (heapSize)");
        increaseCompareCounter();
        if(right < heapSize) {
            //ErrPrinter.printCompare(array[largest], array[right]);
            increaseCompareCounter();
            if(c.compare(array[right], array[largest]) > 0) largest = right;
        }

        if(largest != i) {
            swap(i, largest);
            heapify(largest, c); //???
        }
    }

    private void buildHeap(Comparator<Integer> c) {
        heapSize = array.length;
        for(int i = array.length/2; i >= 0; --i) {
            heapify(i, c);
        }
    }
}

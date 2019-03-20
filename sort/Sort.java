package sort;

import java.util.Comparator;

public abstract class Sort {
    int[] array;
    private int compareCounter;
    private int swapCounter;
    private long elapsedTime;

    Sort(int[] array) {
        this.array = array;
        compareCounter = 0;
        swapCounter = 0;
        elapsedTime = 0;
    }

    public int getCompareCounter() {
        return compareCounter;
    }

    public int getSwapCounter() {
        return swapCounter;
    }

    public long getTime() {
        return elapsedTime;
    }

    void increaseSwapCounter() {
        swapCounter++;
    }

    void increaseCompareCounter() {
        compareCounter++;
    }

    public int[] sort(Comparator<Integer> comparator) {
        compareCounter = 0;
        swapCounter = 0;
        elapsedTime = 0;

        long startTime = System.nanoTime();

        sortArray(comparator);

        elapsedTime = System.nanoTime() - startTime;
        /*ErrPrinter.printCompareCount(compareCounter);
        ErrPrinter.printSwapCount(swapCounter);
        ErrPrinter.printTotalTime(elapsedTime);*/

        return array;
    }

    void swap(int i, int j) {
        //ErrPrinter.printSwap(array[i], array[j]);
        swapCounter++;
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    abstract void sortArray(Comparator<Integer> comparator);
}

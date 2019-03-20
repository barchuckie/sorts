import sort.Sort;

import java.io.PrintWriter;
import java.util.Comparator;

public class StatisticsRunner {

    private PrintWriter writer;

    public StatisticsRunner(PrintWriter writer) {
        this.writer = writer;
    }

    public void run(int n, Sort sort, Comparator<Integer> comparator) {
        sort.sort(comparator);

        writer.print(n + ", " + sort.getCompareCounter() + ", "
                + sort.getSwapCounter() + ", " + sort.getTime() + ", ");
    }

}

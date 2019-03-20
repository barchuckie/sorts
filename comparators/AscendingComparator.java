package comparators;

import java.util.Comparator;
import java.util.Objects;

public class AscendingComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 > o2) return 1;
        if (Objects.equals(o1, o2)) return 0;
        return -1;
    }

}

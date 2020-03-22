package sorting;

import dataStructures.ArrayList;
import dataStructures.List;
import iteration.Iterator;

public class CompoundComparator implements Comparator {
    private final List _comparators = new ArrayList();

    public void addComparator(Comparator comparator) {
        assert comparator != null : "omparator can’t be null";
        assert comparator != this : "can’t add comparator to itself";
        _comparators.add(comparator);
    }

    public int compare(Object left, Object right) {
        int result = 0;
        Iterator i = _comparators.iterator();
        for (i.first(); !i.isDone(); i.next()) {
            result = ((Comparator) i.current()).compare(left, right);
            if (result != 0) {
                break;
            }
        }
        return result;
    }
}
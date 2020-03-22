package sorting;

import dataStructures.LinkedList;
import dataStructures.List;
import iteration.Iterator;

public class InsertionSortListSorter implements ListSorter {
    private final Comparator _comparator;
    public InsertionSortListSorter(Comparator comparator) {
        assert comparator != null : "comparator cannot be null";
        _comparator = comparator;
    }

    public List sort(List list) {
        assert list != null : "list cannot be null";
        final List result = new LinkedList();
        Iterator it = list.iterator();
        for (it.first(); !it.isDone(); it.next()) {
            int slot = result.size();
            while (slot > 0) {
                if (_comparator.compare(it.current(), result.get(slot - 1)) >= 0) {
                    break;
                }
                --slot;
            }
            result.insert(slot, it.current());
        }
        return result;
    }
}

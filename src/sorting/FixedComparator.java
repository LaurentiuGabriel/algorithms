package sorting;

public class FixedComparator implements Comparator {
    private final int _result;
    public FixedComparator(int result) {
        _result = result;
    }
    public int compare(Object left, Object right) {
        return _result;
    }
}
package dataStructures;

import sorting.Comparator;

public class HeapOrderedListPriorityQueue implements Queue {
    private final List _list;
    private final Comparator _comparator;
    public HeapOrderedListPriorityQueue(Comparator comparator) {
        assert comparator != null : "comparator cannot be null";
        _comparator = comparator;_list = new ArrayList();
    }

    public void enqueue(Object value) {
        _list.add(value);
        swim(_list.size() - 1);
    }

    private void swim(int index) {
        if (index == 0) {return;}
        int parent = (index - 1) / 2;
        if (_comparator.compare(_list.get(index), _list.get(parent)) > 0) {
            swap(index, parent);
            swim(parent);
            }
    }

    private void swap(int index1, int index2) {
        Object temp = _list.get(index1);
        _list.set(index1, _list.get(index2));
        _list.set(index2, temp);
    }

    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Object result = _list.get(0);
        if (_list.size() > 1) {
            _list.set(0, _list.get(_list.size() - 1));
            sink(0);}
        _list.delete(_list.size() - 1);
        return result;
    }

    private void sink(int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left >= _list.size()) {return;}
        int largestChild = left;
        if (right < _list.size()) {
            if (_comparator.compare(_list.get(left), _list.get(right)) < 0) {largestChild = right;
            }
        }
        if (_comparator.compare(_list.get(index), _list.get(largestChild)) < 0) {
            swap(index, largestChild);
            sink(largestChild);
        }
    }

    public void clear() {
        _list.clear();
    }

    public int size() {
        return _list.size();
    }

    public boolean isEmpty() {
        return _list.isEmpty();
    }
}

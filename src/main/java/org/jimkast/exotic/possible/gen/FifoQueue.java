package org.jimkast.exotic.possible.gen;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

public final class FifoQueue<T> implements List<T> {
    private final Number max;
    private final List<T> origin;

    public FifoQueue(Number max, LinkedList<T> origin) {
        this.max = max;
        this.origin = origin;
    }

    @Override
    public boolean add(T t) {
        if(origin.size() == max.intValue()) {
            origin.remove(0);
        }
        return origin.add(t);
    }

    @Override
    public int size() {
        return origin.size();
    }

    @Override
    public boolean isEmpty() {
        return origin.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return origin.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return origin.iterator();
    }

    @Override
    public Object[] toArray() {
        return origin.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return origin.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return origin.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return origin.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return origin.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return origin.removeAll(c);
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return origin.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return origin.retainAll(c);
    }

    @Override
    public void clear() {
        origin.clear();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return origin.addAll(index, c);
    }

    @Override
    public T get(int index) {
        return origin.get(index);
    }

    @Override
    public T set(int index, T element) {
        return origin.set(index, element);
    }

    @Override
    public void add(int index, T element) {
        origin.add(index, element);
    }

    @Override
    public T remove(int index) {
        return origin.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return origin.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return origin.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return origin.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return origin.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return origin.subList(fromIndex, toIndex);
    }
}

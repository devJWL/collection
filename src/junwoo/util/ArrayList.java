package junwoo.util;

import java.util.NoSuchElementException;

public class ArrayList <E> implements List <E> {
    private Object[] data;
    private int capacity;
    private int size;

    public ArrayList() {
        final int INIT_CAPACITY = 10;
        capacity = INIT_CAPACITY;
        data = new Object[INIT_CAPACITY];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    @Override
    public boolean add(E element) {
        if (size == capacity) {
            grow();
        }
        data[size++] = element;
        return true;
    }

    private void grow() {
        capacity *= 2;
        Object[] newData = new Object[capacity];
        for (int i = 0; i < size; ++i) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("out of bounds");
        }
        return (E) data[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("out of bounds");
        }
        E e = (E) data[--size];
        data[size] = null;
        return e;
    }

    @Override
    @SuppressWarnings("unchecked")
    public int indexOf(E o) {
        for (int i = 0; i < size; ++i) {
            E item = (E) data[i];
            if (item.equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; --i) {
            E item = (E) data[i];
            if (item.equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    @Override
    public Iterator<E> iterator(int index) {
        return new Iter(index);
    }

    private class Iter implements Iterator<E> {
        private int cursor = -1;

        private Iter() {}
        private Iter(int index) {cursor = index - 1;}

        @Override
        public boolean hasNext() {
            return cursor < size - 1;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No such element");
            }
            return (E) ArrayList.this.data[++cursor];
        }
    }
}

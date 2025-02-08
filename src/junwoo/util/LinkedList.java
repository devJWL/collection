package junwoo.util;

public class LinkedList <E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public LinkedList() {
        first = new Node<>();
        last = new Node<>();
        first.prev = first.next = last;
        last.prev = last.next = first;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    @Override
    public boolean add(E element) {
        if (size == 0) {
            Node<E> newNode = new Node<>(first, last, element);
            first.next = newNode;
            last.prev = newNode;
        }
        else {
            Node<E> newNode = new Node<>(last.prev, last, element);
            last.prev.next = newNode;
            last.prev = newNode;
        }
        ++size;
        return true;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("out of bounds");
        }

        Node<E> node = first;
        while(index > -1) {
            node = node.next;
            --index;
        }
        return node.element;
    }

    @Override
    public E remove() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("out of bounds");
        }
        Node<E> node = last.prev;
        E element = node.element;

        last.prev = node.prev;
        node.prev.next = last;
        --size;

        return element;
    }

    @Override
    public int indexOf(E e) {
        if (size == 0) return -1;
        int index = 0;

        Node<E> node = first.next;
        while(node != last) {
            if (node.element.equals(e)) {
                return index;
            }
            node = node.next;
            ++index;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        if (size == 0) return -1;
        int index = size - 1;

        Node<E> node = last.prev;
        while (node != first) {
            if (node.element.equals(e)) {
                return index;
            }
            node = node.prev;
            --index;
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

    private static class Node<E> {
        Node<E> prev;
        Node<E> next;
        E element;

        public Node() {}
        public Node(Node<E> prev, Node<E> next, E element) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }
    }

    private class Iter implements Iterator<E> {
        private Node<E> cursor;

        private Iter() {
            cursor = first;
        }

        private Iter(int index) {
            cursor = first;
            while(index > 0) {
                cursor = cursor.next;
                --index;
            }
        }

        @Override
        public boolean hasNext() {
            return cursor.next != last;
        }

        @Override
        public E next() {
            cursor = cursor.next;
            return cursor.element;
        }
    }
}

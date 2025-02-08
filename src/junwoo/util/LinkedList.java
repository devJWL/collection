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
        return false;
    }

    @Override
    public boolean add(E element) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public int lastIndexOf(E e) {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterator<E> iterator(int index) {
        return null;
    }

    private static class Node<E> {
        Node<E> prev;
        Node<E> next;
        E data;

        public Node() {}
        public Node(Node<E> prev, Node<E> next, E data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }
}

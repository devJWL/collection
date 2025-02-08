package util;

public class LinkedList <E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public LinkedList() {
        first = new Node<>();
        last = new Node<>();
        first.prev = first.next = last;
        last.prev = last.next = first;
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

package util;

public interface List <E>{
    int size();
    boolean isEmpty();
    boolean contains(E e);
    boolean add(E element);
    E get(int index);
    E remove();
    int indexOf(E e);
    int lastIndexOf(E e);

    Iterator<E> iterator();
    Iterator<E> iterator(int index);
}

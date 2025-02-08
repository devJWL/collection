package util;

import java.util.Iterator;
import java.util.ListIterator;

public interface List <E>{
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    boolean add(E element);
    boolean remove(Object o);
    E get(int index);
    E set(int index, E element);
    E remove(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);

//    Iterator<E> iterator();
//    Iterator<E> iterator(int index);
//    ListIterator<E> listIterator();
//    ListIterator<E> listIterator(int index);
}

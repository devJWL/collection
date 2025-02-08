package junwoo.util;

import java.util.EmptyStackException;

public class Stack <T> extends ArrayList<T>{
    public Stack() {}

    public void push(T element) {
        add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return remove();
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return get(size() - 1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}

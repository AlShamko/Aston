import java.util.Arrays;
import java.util.Collection;


//The second part of my homework. Create an analogue ArrayList.


public class MyArrayList<T> {
    private T[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public MyArrayList() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public boolean add(T element) {
        ensureCapacity(size + 1);
        elements[size] = element;
        size++;
        return true;
    }

    public T remove(int index) {
        checkIndex(index);
        T removedElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return removedElement;
    }

    public T get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public boolean addAll(Collection<? extends T> collection) {
        if (collection == null || collection.isEmpty()) {
            return false;
        }
        ensureCapacity(size + collection.size());
        for (T element : collection) {
            elements[size] = element;
            size++;
        }
        return true;
    }

    public int size() {
        return size;
    }


    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}

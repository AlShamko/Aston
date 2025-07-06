import java.util.ArrayList;
import java.util.List;

import static java.awt.geom.Path2D.contains;


// The first part of my homework. Create an analogue HashSet.


public class MyHash<T> {
    private List<T> elements;

    public MyHash() {
        this.elements = new ArrayList<>();
    }

    public boolean add(T element) {
        if (!contains(element)) {
            return elements.add(element);
        }
        return false;
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public boolean remove(T element) {
        return elements.remove(element);
    }

    public int size() {
        return elements.size();
    }
}

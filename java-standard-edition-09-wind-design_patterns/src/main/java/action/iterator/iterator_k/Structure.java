package action.iterator.iterator_k;


import java.util.Iterator;

public interface Structure {
    void addElement(Person person);
    Object getElement(int index);
    int size();
    Iterator iterator();
}

package action.iterator.iterator_l;


import java.util.Iterator;

public interface Structure {
    void addElement(Person person);
    Object getElement(int index);
    int size();
    Iterator iterator();
}

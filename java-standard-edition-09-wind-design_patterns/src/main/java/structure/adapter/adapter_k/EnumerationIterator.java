package structure.adapter.adapter_k;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/11 17:11
 */
public class EnumerationIterator implements Iterator{
    private Enumeration enumeration;

    public EnumerationIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEachRemaining(Consumer action) {
        throw new UnsupportedOperationException();
    }
}

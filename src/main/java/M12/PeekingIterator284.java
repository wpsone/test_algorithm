package M12;

import java.util.Iterator;

//284. 窥探迭代器
public class PeekingIterator284 {
    Iterator<Integer> iterator;
    Integer cur;

    public PeekingIterator284(Iterator<Integer> iterator) {
        this.iterator = iterator;
        cur = iterator.next();
    }

    public Integer peek() {
        return cur;
    }

    public Integer next() {
        Integer ret = cur;
        if (iterator.hasNext()) {
            cur = iterator.next();
        } else {
            cur = null;
        }
        return ret;
    }

    public boolean hasNext() {
        return cur != null;
    }
}

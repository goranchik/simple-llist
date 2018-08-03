import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LList implements Iterable<String> {

    private Item head;

    public LList(String[] items) {
        Arrays.asList(items).forEach(this::add);
    }

    public void add(String value) {
        Item last = head;
        if (null == head) {
            head = new Item(value);
        } else {
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(new Item(value));
        }

    }

    public boolean find(String value) {
        for (String val: this) {
            if (value.equals(val)) {
                return true;
            }
        }
        return false;
    } 

    public void printIter() {
        Iterator<String> iter = this.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public void print() {
        for (String val : this) {
            System.out.println(val);
        }
    }


    @Override
    public Iterator<String> iterator() {
        return new LListIterator();
    }

    private class LListIterator implements Iterator<String> {
        Item next = head;

        @Override
        public boolean hasNext() {
            return null != next;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String current = next.getValue();
            next = next.getNext();
            return current;
        }
    }

}

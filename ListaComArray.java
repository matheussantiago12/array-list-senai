import java.util.Arrays;
import java.util.Objects;

public class ListaComArray<T> implements List<T> {

    private T[] array;
    private boolean resizable;
    private int initialCapacity;
    private Integer counter;
    private final int x = 7;

    public ListaComArray() {
        this(7);
    }

    public ListaComArray(int initialCapacity) {
        this(initialCapacity, Boolean.TRUE);
    }

    public ListaComArray(int initialCapacity, boolean resizable) {
        this.initialCapacity = initialCapacity;
        this.resizable = resizable;
        this.counter = 0;
        this.array = (T[]) new Object[initialCapacity];
    }

    @Override
    public void add(T item) throws Exception {
        if (!this.resizable) {
            if (counter.equals(initialCapacity)) {
                this.indexBiggerOrMinorTheList(counter, counter + 1);
            }
        }

        this.array[counter] = item;
        counter++;

        if (this.resizable && this.counter.equals(array.length)) {
            resizeArrayList();
        }
    }

    @Override
    public void add(int index, T item) throws Exception {
        this.indexBiggerOrMinorTheList(counter, index);

        T[] oldArray = this.toArray();

        for (int i = index; i <= counter; i++) {
            if (index == i) {
                this.array[i] = item;
            } else {
                this.array[i] = oldArray[i - 1];
            }
        }

        counter++;

        if (this.resizable && this.counter.equals(array.length)) {
            resizeArrayList();
        }
    }

    @Override
    public T remove(int index) throws Exception {
        this.indexBiggerOrMinorTheList(counter, index);

        T[] oldArray = this.toArray();
        T oldValue = this.toArray()[index];

        for (int i = index; i < counter; i++) {
            this.array[i] = oldArray[i + 1];
        }

        counter--;

        return oldValue;
    }

    @Override
    public boolean removeFirst(T item) {
        boolean retorno = Boolean.FALSE;

        for (int i = 0; i < this.counter; i++) {
            if (this.array[i].equals(item)) {
                T[] oldArray = this.toArray();

                for (int j = i; j < counter; j++) {
                    this.array[j] = oldArray[j + 1];
                }

                retorno = Boolean.TRUE;
                counter--;
                break;
            }
        }

        return retorno;
    }

    @Override
    public T get(int index) throws Exception {
        this.indexBiggerOrMinorTheList(counter, index);

        return this.toArray()[index];
    }

    @Override
    public void clear() {
        this.array = (T[]) new Object[initialCapacity];
    }

    @Override
    public T set(int index, T item) throws Exception {
        this.indexBiggerOrMinorTheList(counter, index);

        T oldItem = this.toArray()[index];

        this.array[index] = item;

        return oldItem;
    }

    @Override
    public int size() {
        return this.counter;
    }

    @Override
    public boolean isEmpty() {
        return this.counter.equals(0);
    }

    @Override
    public boolean contains(T item) {
        boolean retorno = Boolean.FALSE;

        for (int i = 0; i < counter; i++) {
            if (this.array[i].equals(item)) {
                retorno = Boolean.TRUE;
                break;
            }
        }

        return retorno;
    }

    @Override
    public int indexOf(T item) {
        int index = -1;

        for (int i = 0; i < counter; i++) {
            if (this.array[i].equals(item)) {
                index = i;
                break;
            }
        }

        return index;
    }

    @Override
    public int lastIndexOf(T item) {
        int index = -1;

        for (int i = 0; i < counter; i++) {
            if (this.array[i].equals(item)) {
                index = i;
            }
        }

        return index;
    }

    @Override
    public T[] toArray() {
        return this.array;
    }

    public boolean isFull() {
        if (!this.resizable) {
            return this.counter.equals(this.initialCapacity);
        }

        return Boolean.FALSE;
    }

    private void resizeArrayList() {
        T[] oldArray = this.toArray();

        int oldLength = oldArray.length;
        int newLength = oldLength + X;

        T[] newArray = (T[]) new Object[newLength];

        System.arraycopy(oldArray, 0, newArray, 0, oldLength);

        this.array = newArray;
    }
}

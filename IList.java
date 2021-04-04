public interface IList<T> {
    void add(T item) throws Exception;

    void add(int index, T item) throws Exception;

    T remove(int index) throws Exception;

    boolean removeFirst(T item) throws Exception;

    T get(int index) throws Exception;

    void clear();

    T set(int index, T item) throws Exception;

    int size();

    boolean isEmpty();

    boolean contains(T item);

    int indexOf(T item);

    int lastIndexOf(T item);

    T[] toArray();
}

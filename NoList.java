public class INoList<T> {
    private T info;
    private NoList<T> prox;

    public NoList() {
        new NoList<T>(null, null);
    }

    public NoList(T info, NoList<T> prox) {
        this.info = info;
        this.prox = prox;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoList<T> getNext() {
        return prox;
    }

    public void setNext(NoList<T> prox) {
        this.prox = prox;
    }
}

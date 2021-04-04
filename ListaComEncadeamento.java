import java.util.Objects;

public class ListaComEncadeamento<T> implements ILista<T> {
    private NoLista first;
    private NoLista last;
    private Integer counter;

    ListaComEncadeamento() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    @Override
    public void add(T item) {
        NoLista newNo = new NoLista(item, null);

        if (counter.equals(0)) {
            first = new NoLista(null, newNo);
        } else {
            boolean isLooping = true;
            NoLista noLista = this.first.getNext();

            do {
                if (Objects.isNull(noLista.getNext())) {
                    isLooping = false;

                    noLista.setNext(newNo);
                }

                noLista = noLista.getNext();
            } while (isLooping);
        }

        last = new NoLista(newNo.getInfo(), null);
        counter++;
    }

    @Override
    public void add(int index, T item) {

        if (this.counter.equals(0)) {
            NoLista newNo = new NoLista(item, null);
            this.first = new NoLista(null, newNo);
            this.last = new NoLista(item, null);
        } else {
            NoLista noListaLooping = this.first.getNext();
            NoLista noListaLoopingAnterior = this.first;
            boolean isLooping = true;
            int indexLooping = 0;

            do {
                if (indexLooping == index) {
                    isLooping = false;

                    NoLista newNo = new NoLista(item, noListaLooping);
                    noListaLoopingAnterior.setNext(newNo);
                } else {
                    noListaLoopingAnterior = noListaLooping;
                    noListaLooping = noListaLooping.getNext();
                    indexLooping++;
                }
            } while (isLooping);
        }

        counter++;
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    private int size() {
        return this.counter;
    }

    @Override
    public boolean isEmpty() {
        return this.counter.equals(0);
    }

    @Override
    public T remove(int index){
        T oldValue = null;

        NoLista noListaLooping = this.first.getNext();
        NoLista noListaLoopingAnterior = this.first;
        boolean isLooping = true;
        int indexLooping = 0;

        do {
            if (indexLooping == index) {
                oldValue = (T) noListaLooping.getInfo();

                NoLista noReplace = noListaLooping.getNext();
                if (Objects.isNull(noReplace)) {
                    noListaLoopingAnterior.setNext(null);
                    this.last = noListaLoopingAnterior;
                } else {
                    noListaLoopingAnterior.setNext(noReplace);
                }

                isLooping = false;
            } else {
                noListaLoopingAnterior = noListaLooping;
                noListaLooping = noListaLooping.getNext();
                indexLooping++;
            }
        } while (isLooping);

        counter--;
        return oldValue;
    }

    @Override
    public boolean removeFirst(T item) {
        boolean retorno = false;
        NoLista noListaLooping = this.first.getNext();
        boolean isLooping = true;
        int indexLooping = 0;

        do {
            if (Objects.isNull(noListaLooping)) {
                isLooping = false;
            } else {
                if (noListaLooping.getInfo().equals(item)) {
                    this.remove(indexLooping);
                    isLooping = false;
                    retorno = true;
                } else {
                    noListaLooping = noListaLooping.getNext();
                    indexLooping++;
                }
            }
        } while (isLooping);

        return retorno;
    }

    @Override
    public T get(int index) {
        T item = null;

        NoLista noListaLooping = this.first.getNext();
        boolean isLooping = true;
        int indexLooping = 0;

        do {
            if (index == indexLooping) {
                item = (T) noListaLooping.getInfo();
                isLooping = false;
            } else {
                noListaLooping = noListaLooping.getNext();
                indexLooping++;
            }
        } while (isLooping);

        return item;
    }

    @Override
    public T set(int index, T item) {
        T retorno = null;
        NoLista noListaLooping = this.first.getNext();
        NoLista noListaLoopingAnterior = this.first;
        boolean isLooping = true;
        int indexLooping = 0;

        do {
            if (index == indexLooping) {
                retorno = (T) noListaLooping.getInfo();
                NoLista newNo = new NoLista(item, noListaLooping.getNext());
                noListaLoopingAnterior.setNext(newNo);
                isLooping = false;
            } else {
                noListaLoopingAnterior = noListaLooping;
                noListaLooping = noListaLooping.getNext();
                indexLooping++;
            }
        } while (isLooping);

        return retorno;
    }

    @Override
    public boolean contains(T item) {
        boolean retorno = false;
        if (Objects.nonNull(this.first)) {
            NoLista noListaLooping = this.first.getNext();
            boolean isLooping = true;
            int indexLooping = 0;

            do {
                if (Objects.isNull(noListaLooping)) {
                    isLooping = false;
                } else {
                    if (noListaLooping.getInfo().equals(item)) {
                        isLooping = false;
                        retorno = true;
                    } else {
                        noListaLooping = noListaLooping.getNext();
                        indexLooping++;
                    }
                }
            } while (isLooping);
        }

        return retorno;
    }

    @Override
    public int indexOf(T item) {
        int indice = -1;

        if (Objects.nonNull(this.first)) {
            NoLista noListaLooping = this.first.getNext();
            boolean isLooping = true;
            int indexLooping = 0;

            do {
                if (Objects.isNull(noListaLooping)) {
                    isLooping = false;
                } else {
                    if (noListaLooping.getInfo().equals(item)) {
                        indice = indexLooping;
                        isLooping = false;
                    } else {
                        noListaLooping = noListaLooping.getNext();
                        indexLooping++;
                    }
                }
            } while (isLooping);
        }

        return indice;
    }

    @Override
    public int lastIndexOf(T item) {
        int indice = -1;

        if (Objects.nonNull(this.first)) {
            NoLista noListaLooping = this.first.getNext();
            boolean isLooping = true;
            int indexLooping = 0;

            do {
                if (Objects.isNull(noListaLooping)) {
                    isLooping = false;
                } else {
                    if (noListaLooping.getInfo().equals(item)) {
                        indice = indexLooping;
                    } else {
                        noListaLooping = noListaLooping.getNext();
                        indexLooping++;
                    }
                }
            } while (isLooping);
        }

        return indice;
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[counter];

        if (Objects.nonNull(this.first)) {
            NoLista noListaLooping = this.first.getNext();
            boolean isLooping = true;
            int indexLoaping = 0;

            do {
                if (Objects.isNull(noListaLooping)) {
                    isLooping = false;
                } else {
                    array[indexLoaping] = (T) noListaLooping.getInfo();
                    noListaLooping = noListaLooping.getNext();
                    indexLoaping++;
                }
            } while (isLooping);
        }

        return array;
    }
}

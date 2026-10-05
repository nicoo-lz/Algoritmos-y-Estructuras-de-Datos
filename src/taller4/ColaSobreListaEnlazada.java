public class ColaSobreListaEnlazada implements Cola {
    private Node inicio;
    private Node fin;

    public ColaSobreListaEnlazada() {
        inicio = null;
        fin = null;
    }

    public void enqueue(int elem) {
        Node ultimo = new Node(elem);

        if (inicio == null) {
            inicio = ultimo;
            fin = ultimo;
        }
        else {
            fin.next = ultimo;
            fin = ultimo;
        }
    }

    public int dequeue() {
        int res = inicio.data;
        inicio = inicio.next;
        return res;
    }

    public int front() {
        return inicio.data;
    }

    public int rear() {
        return fin.data;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public boolean isFull() {
        return false;
    }
}

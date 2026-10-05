public class PilaSobreListaEnlazada implements Pila {
    private Node cima;

    public PilaSobreListaEnlazada() {
        cima = null;
    }

    public void push(int elem) {
        Node nuevaCima = new Node(elem);
        nuevaCima.next = cima;
        cima = nuevaCima;
    }

    public int pop() {
        int res = cima.data;
        cima = cima.next;
        return res;
    }

    public int top() {
        return cima.data;
    }

    public boolean isEmpty() {
        return cima == null;
    }

    public boolean isFull() {
        return false;
    }
}

public class PilaSobreArreglo implements Pila {
    private int[] elems;
    private int cima;

    public PilaSobreArreglo(int capacity) {
        elems = new int[capacity];
        cima = 0;
    }

    public void push(int elem) {
        elems[cima] = elem;
        cima++;
    }

    public int pop() {
        cima--;
        return elems[cima];
    }

    public int top() {
        return elems[cima-1];
    }

    public boolean isEmpty() {
        return cima == 0;
    }

    public boolean isFull() {
        return cima == elems.length;
    }
}

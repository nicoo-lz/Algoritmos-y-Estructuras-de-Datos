public class ColaSobreArregloCircular implements Cola {
    private int[] elems;
    private int inicio;
    private int fin;

    public ColaSobreArregloCircular(int i) {
        elems = new int[i+1];
        inicio = 0;
        fin = 0;
    }

    // Inserta en el final (tail)
    public void enqueue(int elem) {
        if (isFull()) {
            throw new RuntimeException();
        }
        elems[fin] = elem;
        fin = (fin + 1) % elems.length;
    }

    // Obtiene el elemento del frente (head)
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        int res = elems[inicio];
        inicio = (inicio + 1) % elems.length;
        return res;
    }

    // Obtiene el elemento del frente (head)
    public int front() {
        return elems[inicio];
    }

    // Obtiene el elemento del final (tail)
    public int rear() {
        return elems[fin - 1];
    }

    public boolean isEmpty() {
        return inicio == fin;
    }

    public boolean isFull() {
        return ((fin + 1) % elems.length) == inicio;
    }
}

package aed;

public class ListaEnlazada<T> {
    private Nodo primero;
    private Nodo ultimo;

    private class Nodo {
        private T valor;
        private Nodo anterior;
        private Nodo siguiente;

        public Nodo(T elem) {
            valor = elem;
            anterior = null;
            siguiente = null;
        }
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
    }

    public int longitud() {
        if (primero == null) {
            return 0;
        }
        else {
            int len = 1;
            Nodo actual = primero;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
                len += 1;
            }

            return len;
        }
    }

    public void agregarAdelante(T elem) {
        Nodo elemento = new Nodo(elem);

        // caso lista vacia
        if (primero == null) {
            primero = elemento;
            ultimo = elemento;
        }
        else {
            elemento.siguiente = primero;
            primero = elemento;
        }
    }

    public void agregarAtras(T elem) {
        Nodo elemento = new Nodo(elem);

        if (primero == null) {
            primero = elemento;
            ultimo = elemento; 
        }
        else {
            ultimo.siguiente = elemento;
            elemento.anterior = ultimo;
            ultimo = elemento;
        }
    }

    public T obtener(int i) {
        if (i < 0 || i >= longitud()) {
            return null;
        }
        else {
            int j = 0;
            Nodo actual = primero;

            while (j != i) {
                actual = actual.siguiente;
                j++;
            }
            return actual.valor;
        }
    }

    public void eliminar(int i) {
        if (i == 0) {
            primero = primero.siguiente;
            primero.anterior = null;
        }
        else if (i == longitud()-1) {
            ultimo = ultimo.anterior;
            ultimo.siguiente = null;
        }
        else {
            
        }
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public class ListaIterador{
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public ListaIterador iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}

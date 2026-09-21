package aed;

public class ListaEnlazada<T> {
    private Nodo primero;
    private Nodo ultimo;

    private class Nodo {
        // Nodo doblemente enlazado
        T valor;
        Nodo anterior;
        Nodo siguiente;

        public Nodo(T val) {
            valor = val;
            anterior = null;
            siguiente = null;
        }

    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
    }

    public int longitud() {
        // funciona para la lista vacia
        Nodo actual = primero;
        int len = 0;

        while (actual != null) {
            actual = actual.siguiente;
            len++;
        }

        return len;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        // caso lista vacia
        if (longitud() == 0) {
            primero = nuevo;
            ultimo = nuevo;
        }
        else {
        // caso lista no vacia
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        }
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        // caso lista vacia
        if (longitud() == 0) {
            primero = nuevo;
            ultimo = nuevo;
        }
        else {
            // caso lista no vacia
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    public T obtener(int i) {
        // asumo que el indice es valido, es decir, la lista no puede ser vacia
        int j = 0;
        Nodo actual = primero;

        while (j != i) {
            actual = actual.siguiente;
            j++;
        }

        return actual.valor;
    }

    public void eliminar(int i) {
        // asumo que i es un indice valido, entonces la lista no puede ser vacia
        if (longitud() == 1) {
            primero = null;
            ultimo = null;
        }
        else {
            // se que len >= 2 entonces primero != ultimo
            if (i == 0) {
                primero = primero.siguiente;
                primero.anterior = null;
            }
            else if (i == longitud()-1) {
                ultimo = ultimo.anterior;
                ultimo.siguiente = null;
            }
            else {
                Nodo actual = primero;
                int j = 0;

                while (j != i-1) {
                    actual = actual.siguiente;
                    j++;
                }

                actual.siguiente = actual.siguiente.siguiente;
                actual.siguiente.anterior = actual;
            }
        }

    }

    public void modificarPosicion(int indice, T elem) {
        // asumo que el indice es valido
        Nodo actual = primero;
        int j = 0;

        while (j != indice) {
            actual = actual.siguiente;
            j++;
        }

        actual.valor = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        // asumo que lista != null. Pero funciona para una lista vacia como una lista no vacia
        Nodo actual = lista.primero;

        while (actual != null) {
            agregarAtras(actual.valor);
            actual = actual.siguiente;
        }
    }
    
    @Override
    public String toString() {
        // caso lista vacia
        if (longitud() == 0) {
            return "[]";
        }
        else {
            String res = "[";
            Nodo actual = primero;

            while (actual.siguiente != null) {
                res += actual.valor + ", ";
                actual = actual.siguiente;
            }

            res += actual.valor + "]";
            return res;
        }
    }

    public class ListaIterador {
        // el iterador sera un puntero a un nodo
        Nodo actual;

        public ListaIterador() {
            actual = primero;
        }

        public boolean haySiguiente() {
            // este metodo funciona bien para listas vacias y no vacias
            return actual != null;
        }

        public boolean hayAnterior() {
            // es mejor separar en casos
            // si la lista es vacia es false
            if (longitud() == 0) {
                return false;
            }
            // ahora, la unica forma de que actual sea null es que ya haya recorrido toda la lista
            // entonces hay anterior
            if (actual == null) {
                return true;
            }
            return actual.anterior != null;
        }

        public T siguiente() {
            T res = actual.valor;
            actual = actual.siguiente;
            return res;
        }


        public T anterior() {
            // si ya habia recorrido toda la lista entonces anterior es el ultimo elemento de la lista
            if (actual == null) {
                actual = ultimo;
                return actual.valor;
            }
            actual = actual.anterior;
            return actual.valor;
       }
    }

    public ListaIterador iterador() {
        return new ListaIterador();
    }

}


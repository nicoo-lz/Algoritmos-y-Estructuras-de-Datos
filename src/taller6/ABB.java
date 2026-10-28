package aed;

import java.util.*;

public class ABB<T extends Comparable<T>> {
    private Nodo _raiz;
    private int _cardinal;

    private class Nodo {
        Nodo padre;
        Nodo izq;
        Nodo der;
        T valor;

        Nodo (T v) {
            valor = v;
            padre = null;
            izq = null;
            der = null;
        }
    }

    public ABB() {
        _raiz = null;
        _cardinal = 0;
    }

    public int cardinal() {
        return _cardinal;
    }

    public T minimo(){  // asumo que el conjunto tiene al menos 1 elem
        Nodo actual = _raiz;

        while (actual.izq != null) {
            actual = actual.izq;
        }

        return actual.valor;
    }

    public T maximo(){  // asumo que el conjunto tiene al menos 1 elem
        Nodo actual = _raiz;

        while (actual.der != null) {
            actual = actual.der;
        }

        return actual.valor;

    }

    public void insertar(T elem){
        if (_cardinal == 0) {
            _raiz = new Nodo(elem);
            _cardinal++;
        }
        else {  // tengo por lo menos 1 nodo
            Nodo actual = _raiz;
            Nodo ultimoNodoVisitado = _raiz;

            while (actual != null) {  // busco el lugar a insertar
                int comp = elem.compareTo(actual.valor);

                if (comp == 0) {
                    return;  // elem ya esta, no hago nada
                }
                else if (comp > 0) {
                    ultimoNodoVisitado = actual;
                    actual = actual.der;
                }
                else {
                    ultimoNodoVisitado = actual;
                    actual = actual.izq;
                }
            }

            if (elem.compareTo(ultimoNodoVisitado.valor) > 0) {  // es hijo derecho
                Nodo hijo = new Nodo(elem);
                ultimoNodoVisitado.der = hijo;
                hijo.padre = ultimoNodoVisitado;
            }
            else {   // es hijo izquierdo
                Nodo hijo = new Nodo(elem);
                ultimoNodoVisitado.izq = hijo;
                hijo.padre = ultimoNodoVisitado;
            }

            _cardinal++;
        }
    }

    public boolean pertenece(T elem){
        Nodo actual = _raiz;

        while (actual != null && actual.valor.compareTo(elem) != 0) {   // mientras no lo encontre me muevo
            int comp = actual.valor.compareTo(elem);

            if (comp > 0) {
                actual = actual.izq;
            }
            else {
                actual = actual.der;
            }
        }

        return actual != null;  // salgo con actual siendo un nodo (esta) o siendo null (no esta)
    }

    public void eliminar(T elem){
        if (!pertenece(elem)) {
            return;  // elem no esta, asi que no hago nada
        }
        else {  // se que elem esta en el arbol, asi que lo primero que hago es buscarlo
            Nodo actual = _raiz;

            while (actual.valor.compareTo(elem) != 0) {
                int comp = elem.compareTo(actual.valor);

                if (comp > 0) {
                    actual = actual.der;
                }
                else {
                    actual = actual.izq;
                }
            }

            // ahora tengo al elem en actual. Debo decidir que caso de borrado es, nodo hoja, 1h o 2h
            if (actual.izq == null && actual.der == null) {   // caso 1: nodo hoja
                if (actual.padre == null) {  // caso especial: el nodo hoja es la raiz, sin padre
                    _raiz = null;
                    _cardinal--;
                    return;
                }
                int comp = actual.valor.compareTo(actual.padre.valor);

                if (comp > 0) {
                    actual.padre.der = null;
                }
                else {
                    actual.padre.izq = null;
                }
                _cardinal--;
            }
            else if (actual.izq == null || actual.der == null) {  // caso 2: nodo solo con 1 hijo
                if (actual.padre == null) {  // caso especial en que borro la raiz, sin padre
                    if (actual.izq == null) {
                        _raiz = actual.der;
                    }
                    else {
                        _raiz = actual.izq;
                    }
                    _raiz.padre = null;
                    _cardinal--;
                    return;
                }

                if (actual.padre.izq == actual && actual.izq == null) {  // nodo izq hijo der
                    actual.padre.izq = actual.der;
                    actual.der.padre = actual.padre;
                }
                else if (actual.padre.izq == actual) {   // nodo izq hijo izq
                    actual.padre.izq = actual.izq;
                    actual.izq.padre = actual.padre;
                }
                else if (actual.izq == null) {   // nodo der hijo der
                    actual.padre.der = actual.der;
                    actual.der.padre = actual.padre;
                }
                else {   // nodo der hijo izq
                    actual.padre.der = actual.izq;
                    actual.izq.padre = actual.padre;
                }
                _cardinal--;
            }
            else {   // caso 3: nodo con dos hijos con sucesor inmediato
                Nodo minimo = actual.der;

                while (minimo.izq != null) {
                    minimo = minimo.izq;
                }

                actual.valor = minimo.valor;
                if (minimo.der == null && minimo.padre == actual) {   // minimo es hoja y ES subarbol
                    actual.der = null;
                }
                else if (minimo.der == null) {   // minimo es hoja y NO es subarbol
                    minimo.padre.izq = null;
                }
                else if (minimo.padre == actual) {  // minimo tiene hijo der y es la raiz del subarbol
                    minimo.padre.der = minimo.der;
                    minimo.der.padre = minimo.padre;
                }
                else {   // minimo tiene hijo der y su padre es derecho
                    minimo.padre.izq = minimo.der;
                    minimo.der.padre = minimo.padre;
                }
                _cardinal--;
            }
        }
    }

    public String toString(){
        ABB_Iterador it = new ABB_Iterador();
        String res = "{";
        boolean primero = true;  // el primer elemento se inserta solo, los demas como ",elem"

        while (it.haySiguiente()) {
            if (primero) {
                res += it.siguiente();
                primero = false;
            }
            else {
                res += "," + it.siguiente();
            }
        }

        res += "}";
        return res;
    }

    public class ABB_Iterador {
        private Nodo _actual;

        public ABB_Iterador() {
            _actual = _raiz;

            if (_actual != null) {
                while (_actual.izq != null) {
                    _actual = _actual.izq;
                }
            }
        }

        public boolean haySiguiente() {            
            return _actual != null;
        }
    
        public T siguiente() {
            T res = _actual.valor;

            if (_actual.der != null) { // caso en que actual tiene subarbol der, busco el sucesor inmed
                _actual = _actual.der;

                while (_actual.izq != null) {
                    _actual = _actual.izq;
                }
            }
            else {   // caso en que actual NO tiene subarbol der, busco su primer padre der
                while (_actual != _raiz && _actual.padre.der == _actual) {   // voy subiendo hasta encontrar a mi padre der
                    _actual = _actual.padre;
                }
                _actual = _actual.padre;
            }
            return res;
        }
    }

    public ABB_Iterador iterador() {
        return new ABB_Iterador();
    }

}

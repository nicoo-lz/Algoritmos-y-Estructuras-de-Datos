package taller1;

class Funciones {

    /***  Primera parte: Funciones en java ***/

    int cuadrado(int x) {
        return x * x;
    }

    double distancia(double x, double y) {
        /* uso el metodo estatico sqrt() de la clase Math. Ademas, la clase Math ya viene importada
        por default en el package java.lang */
        return Math.sqrt(x * x + y * y);
    }

    boolean esPar(int n) {
        return n % 2 == 0;
    }

    boolean esBisiesto(int n) {
        return (n % 4 == 0 && n % 100 != 0) || (n % 400 == 0);
    }

    int factorialIterativo(int n) {
        // variable acumuladora
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    int factorialRecursivo(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorialRecursivo(n-1);
    }

    // ver explicacion en el cuaderno
    boolean esPrimo(int n) {
        // me saco de encima casos triviales
        if (n < 2) {
            return false;
        }

        int divisor = 2;

        while (n % divisor != 0) {
            divisor++;
        }

        // dos posibilidades, o salgo del while con div = n (es primo) o salgo con div < n (no es primo)
        return divisor == n;
    }

    int sumatoria(int[] numeros) {
        // variable acumuladora
        int sumat = 0;

        for (int numero : numeros) {
            sumat += numero;
        }

        return sumat;
    }

    int busqueda(int[] numeros, int buscado) {
        int i = 0;

        while (numeros[i] != buscado) {
            i++;
        }

        return i;
    }

    // ver explicacion en el cuaderno
    boolean tienePrimo(int[] numeros) {
        int pos = 0;

        while (pos < numeros.length && !esPrimo(numeros[pos])) {
            pos++;
        }

        return pos < numeros.length;
    }

    boolean todosPares(int[] numeros) {
        for (int numero : numeros) {
            if (numero % 2 != 0) {
                return false;
            }
        }

        // si finaliza el for completo entonces no habia impares
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        // descarto casos triviales
        if (s1.length() > s2.length()) {
            return false;
        }

        // ahora estoy seguro de que |s1| <= |s2|
        int i = 0;

        while (i < s1.length() && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }

        return i == s1.length();

    }

    // funcion auxiliar para esSufijo
    String invertir(String texto) {
        String res = "";

        for (int i = texto.length()-1; i >= 0; i--) {
            res += texto.charAt(i);
        }

        return res;
    }


    boolean esSufijo(String s1, String s2) {
        return esPrefijo(invertir(s1), invertir(s2));
    }

    /***  Segunda parte: Debugging ***/

    boolean xor(boolean a, boolean b) {
        return (a || b) && !(a && b);
    }

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;

        if (xs.length != ys.length) {
            return false;
        }

        for (int i = 0; i < xs.length; i++) {
            if (xs[i] != ys[i]) {
                res = false;
            }
        }
        return res;
    }

    boolean ordenado(int[] xs) {
        boolean res = true;

        for (int i = 0; i < xs.length-1; i++) {
            if (xs[i] > xs [i+1]) {
                res = false;
            }
        }

        return res;
    }

    int maximo(int[] xs) {
        int res = xs[0];
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] > res) res = xs[i];
        }
        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = true;

        for (int x : xs) {
            if (!(x > 0)) {
                res = false;
            }
        }
        return res;
    }

}

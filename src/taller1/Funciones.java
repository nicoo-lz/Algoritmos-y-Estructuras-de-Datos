package aed;

class Funciones {

/***  Primera parte: Funciones en java ***/

    int cuadrado(int x) {
        return x * x;
    }

    double distancia(double x, double y) {
        return Math.sqrt((x*x) + (y*y));
    }

    boolean esPar(int n) {
        return n % 2 == 0;
    }

    boolean esBisiesto(int n) {
        return (n % 400 == 0) || ((n % 4 == 0) && (n % 100 != 0));
    }

    int factorialIterativo(int n) {
        int res = 1;

        for (int i = 1; i <= n; i++) {
            res *= i;
        }

        return res;
    }

    int factorialRecursivo(int n) {
        if (n == 0) {
            return 1;
        }
        else {
            return n * factorialRecursivo(n-1);
        }
    }

    boolean esPrimo(int n) {        
        boolean res = true;

        if (n == 0 || n == 1) {
            res = false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                res = false;
            }
        }

        return res;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        
        for (int i = 0; i < numeros.length; i++) {
            res += numeros[i];
        }

        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                res = i;
            }
        }

        return res;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false;

        for (int numero : numeros) {
            if (esPrimo(numero)) {
                res = true;
            }
        }

        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;

        for (int numero : numeros) {
            if (numero % 2 != 0) {
                res = false;
            }
        }

        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        boolean res = true;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                res = false;
            }
        }

        return res;
    }

    String invertirString(String palabra) {
        String res = "";
        
        for (int i = palabra.length()-1; i >= 0; i--) {
            res += palabra.charAt(i);
        }

        return res;
    }


    boolean esSufijo(String s1, String s2) {
        return esPrefijo(invertirString(s1), invertirString(s2));
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
            if (x <= 0) {
                res = false;
            }
        }
        return res;
    }

}
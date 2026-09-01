class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] recordatorios;

    public ArregloRedimensionableDeRecordatorios() {
        recordatorios = new Recordatorio[0];
    }

    public int longitud() {
        return recordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio copiaRecordatorio = new Recordatorio(i);
        recordatorios = agregarRecordatorio(recordatorios, copiaRecordatorio);
    }

    private Recordatorio[] agregarRecordatorio(Recordatorio[] arreglo, Recordatorio i) {
        Recordatorio[] nuevoArreglo = new Recordatorio[arreglo.length+1];

        for (int j = 0; j < arreglo.length; j++) {
            nuevoArreglo[j] = arreglo[j];
        }

        nuevoArreglo[arreglo.length] = i;
        return nuevoArreglo;
    }

    public Recordatorio obtener(int i) {
        Recordatorio copiaRecordatorio = new Recordatorio(recordatorios[i]);
        return copiaRecordatorio;
    }

    public void quitarAtras() {
        if (recordatorios.length == 0) {
            return;
        }
        else {
            recordatorios = eliminarRecordatorio(recordatorios);
        }
    }

    private Recordatorio[] eliminarRecordatorio(Recordatorio[] array) {
        Recordatorio[] nuevoArray = new Recordatorio[array.length-1];

        for (int i = 0; i < nuevoArray.length; i++) {
            nuevoArray[i] = array[i];
        }

        return nuevoArray;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        Recordatorio copiaValor = new Recordatorio(valor);
        recordatorios[indice] = copiaValor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        Recordatorio[] recordatoriosRes = new Recordatorio[vector.longitud()];

        for (int i = 0; i < vector.longitud(); i++) {
            recordatoriosRes[i] = vector.obtener(i);
        }

        recordatorios = recordatoriosRes;
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios arregloCopia = new ArregloRedimensionableDeRecordatorios(this);
        return arregloCopia;
    }
}

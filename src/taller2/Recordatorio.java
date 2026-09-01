public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;


    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);
        this.horario = new Horario(horario);
    }

    public Recordatorio(Recordatorio otro) {
        this.mensaje = otro.mensaje;
        this.fecha = new Fecha(otro.fecha);
        this.horario = new Horario(otro.horario);
    }

    public Horario horario() {
        Horario horarioCopia = new Horario(horario);
        return horarioCopia;
    }

    public Fecha fecha() {
        Fecha fechaCopia = new Fecha(fecha);
        return fechaCopia;
    }

    public String mensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return mensaje + " @ " + fecha.toString() + " " + horario.toString();
    }

    @Override
    public boolean equals(Object otro) {
        if (otro == null) {
            return false;
        }
        else if (otro.getClass() != this.getClass()) {
            return false;
        }
        else {
            Recordatorio otroRecordatorio = (Recordatorio) otro;
            return (mensaje.equals(otroRecordatorio.mensaje)) && (fecha.equals(otroRecordatorio.fecha)) && (horario.equals(otroRecordatorio.horario));  
        }
    }

}

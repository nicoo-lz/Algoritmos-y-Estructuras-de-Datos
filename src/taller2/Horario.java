public class Horario {
    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public Horario(Horario horario) {
        this.hora = horario.hora;
        this.minutos = horario.minutos;
    }

    public int hora() {
        return hora;
    }

    public int minutos() {
        return minutos;
    }

    @Override
    public String toString() {
        return hora + ":" + minutos;
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
            Horario otroHorario = (Horario) otro;
            return (otroHorario.hora == hora) && (otroHorario.minutos == minutos);
        }
    }

}

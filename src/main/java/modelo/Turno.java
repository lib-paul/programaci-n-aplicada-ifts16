
package modelo;
import java.time.*;

public class Turno {
    private int id_paciente;
    private int id_medico;
    private LocalDate fecha;
    private LocalTime hora;

    @Override
    public String toString() {
        return "Turno{" + "id_paciente=" + id_paciente + ", id_medico=" + id_medico + ", fecha=" + fecha + ", hora=" + hora + '}';
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}

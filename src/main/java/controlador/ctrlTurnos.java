package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.*;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import vista.*;
import modelo.*;

public class ctrlTurnos implements ActionListener {

    private Medico medico;
    private Paciente paciente;
    private formTurnos frm;
    private ConsultasTurnos consultaTurnos;
    private Turno turno;

    public ctrlTurnos(Medico medico, Paciente paciente, formTurnos frm, ConsultasTurnos consulta) {
        this.medico = medico;
        this.paciente = paciente;
        this.frm = frm;
        this.consultaTurnos = consulta;
        this.frm.comboEspecialidades.addActionListener(this);
        this.frm.btnBuscarPaciente.addActionListener(this);
        this.frm.cmbMedicos.addActionListener(this);
        this.frm.btnCargarTurno.addActionListener(this);
    }

    public void iniciar() throws SQLException {
        frm.setTitle("Alta Turnos");
        frm.setLocationRelativeTo(null);

        consultaTurnos.buscarEspecialidades(frm.comboEspecialidades, medico);

    }

    public void cargarDias() {
        //Carga los dias disponibles
        DefaultListModel listaNueva = new DefaultListModel();
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(2);
        var listOfDates = startDate.datesUntil(endDate).collect(Collectors.toList());
        listaNueva.addAll(listOfDates);
        frm.listDias.setModel(listaNueva);

    }

    public void cargarHoras() {
        //Carga los horarios disponibles
        DefaultListModel listaNueva = new DefaultListModel();
        ArrayList<LocalTime> intervals = new ArrayList<>();
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(20, 30);
        while (startTime.isBefore(endTime)) {
            intervals.add(startTime);
            startTime = startTime.plusMinutes(30);
        }
        listaNueva.addAll(intervals);
        //buscarHorariosOcupados()...
        frm.listHoras.setModel(listaNueva);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.comboEspecialidades) {
            frm.cmbMedicos.removeAllItems();
            String especialidadSeleccionada = frm.comboEspecialidades.getItemAt(frm.comboEspecialidades.getSelectedIndex());
            consultaTurnos.buscarMedicos(frm.cmbMedicos, especialidadSeleccionada);

        }
        if (e.getSource() == frm.btnBuscarPaciente) {
            int dni = Integer.parseInt(frm.txtBuscarDNI.getText());
            consultaTurnos.cargarTablaPaciente(frm.tablaDatosPaciente, dni);
            cargarDias();
            cargarHoras();

        }
        if (e.getSource() == frm.btnCargarTurno) {
            String fecha = String.valueOf(frm.listDias.getSelectedValue());
            String hora = String.valueOf(frm.listHoras.getSelectedValue());    
            var idPaciente = ((int) frm.tablaDatosPaciente.getValueAt(0, 3));
            String[] medico = frm.cmbMedicos.getItemAt(frm.cmbMedicos.getSelectedIndex()).split("-");
            int idMedico = Integer.parseInt(medico[0]) ;
           try {
               consultaTurnos.cargarTurno(idPaciente,idMedico, fecha, hora, frm.comboEspecialidades.getItemAt(frm.comboEspecialidades.getSelectedIndex()));
               consultaTurnos.cargarTablaIntermediaTP(idPaciente);
           } catch (SQLException ex) {
               Logger.getLogger(ctrlTurnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

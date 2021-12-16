package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/* Jeje picaron */
public class ConsultasTurnos extends conexionBDD {

    //Cargar las especialidades en el combobox
    public void buscarEspecialidades(JComboBox combo, Medico medico) throws SQLException {
        PreparedStatement pps;
        ResultSet rs;
        String sql = "SELECT especialidad.id, especialidad.nombre_especialidad as 'especialidades' FROM turnospi.especialidad";
        try {
            Connection con = conexion();
            pps = con.prepareStatement(sql);
            rs = pps.executeQuery();
            while (rs.next()) {
                combo.addItem(rs.getString("especialidades"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarMedicos(JComboBox combo, String especialidadSeleccionada) {
        PreparedStatement pps;
        ResultSet rs;
        String sql = "SELECT medico.id_medico, medico.nombres, especialidad.nombre_especialidad FROM medico INNER JOIN medico_especialidad ON (medico_especialidad.id_medico = medico.id_medico) INNER JOIN especialidad ON (medico_especialidad.id_especialidad = especialidad.id) WHERE especialidad.nombre_especialidad = ?;";
        combo.removeAllItems();
        try {
            Connection con = conexion();
            pps = con.prepareStatement(sql);
            pps.setString(1, especialidadSeleccionada);
            rs = pps.executeQuery();
            while (rs.next()) {

                combo.addItem(rs.getString("id_medico") + "-" + rs.getString("nombres") + "-" + rs.getString("nombre_especialidad"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarHorariosOcupados(Turno turno) {

    }

    public void cargarTurno(int idPaciente, int idMedico, String date, String time, String especialidad) throws SQLException {
        PreparedStatement pps;
        Connection con = conexion();

        String sql = "INSERT INTO turnos (idPaciente,IdMedico,Fecha,Horario,nombre_especialidad) VALUES (?,?,?,?,?);";
        try {
            pps = con.prepareStatement(sql);
            pps.setInt(1, idPaciente);
            pps.setInt(2, idMedico);
            pps.setString(3, date);
            pps.setString(4, time);
            pps.setString(5, especialidad);
            pps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarTablaIntermediaTP(int idPaciente) throws SQLException {
        PreparedStatement pps;
        ResultSet rs;
        String sql = "SELECT MAX(idTurno) FROM turnos WHERE turnos.idPaciente=?;";
        int idTurno = 0;
        Connection con = conexion();
        pps = con.prepareStatement(sql);
        pps.setInt(1, idPaciente);
        rs = pps.executeQuery();
        if (rs.next()) {
            idTurno = rs.getInt("MAX(idTurno)");
        }
        String sql2 = "INSERT INTO paciente_turnos (id_paciente,id_turnos) VALUES (?,?);";
        pps = con.prepareStatement(sql2);
        pps.setInt(1, idPaciente);
        pps.setInt(2, idTurno);
        pps.execute();

    }

    public void cargarTablaPaciente(JTable tabla, int dni) {
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        String sql = "SELECT paciente.nombres,paciente.apellido,paciente.documento,paciente.id_paciente FROM paciente WHERE documento=?";
        try {
            Connection con = conexion();
            PreparedStatement pps = null;
            ResultSet rs = null;
            pps = con.prepareStatement(sql);
            pps.setInt(1, dni);
            rs = pps.executeQuery();

            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();

            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("DNI");
            modelo.addColumn("ID");

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasTurnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

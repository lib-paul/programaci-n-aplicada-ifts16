package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vista.formAltaPaciente;

public class Consultas extends conexionBDD {

    /* Paciente */
    public boolean altaPaciente(Paciente paciente) throws SQLException {
        PreparedStatement pps;
        Connection con = conexion();
        String sql = "INSERT INTO paciente (nombre, apellido, documento, direccion, email, telefono_fijo, telefono_celular, departamento, codigo_postal, id_localidad) VALUES (?,?,?,?,?,?,?,?,?,?);";

        try {
            pps = con.prepareStatement(sql);

            pps.setString(1, paciente.getNombre());
            pps.setString(2, paciente.getApellido());
            pps.setInt(3, paciente.getDni());
            pps.setString(4, paciente.getDireccion());
            pps.setString(5, paciente.getEmail());
            pps.setString(6, paciente.getTel_fijo());
            pps.setString(7, paciente.getTel_cel());
            pps.setString(8, paciente.getDepartamento());
            pps.setInt(9, paciente.getCodigo_postal());
            pps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public boolean cargarComboBox(formAltaPaciente frm) throws SQLException {
        PreparedStatement pps;
        ResultSet rs;
        Connection con = conexion();
        String sql = "SELECT * FROM localidad";

        try {
            pps = con.prepareStatement(sql);
            rs = pps.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
                frm.cob_localidad.addItem(rs.getString("nombre")+rs.getString("id"));
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

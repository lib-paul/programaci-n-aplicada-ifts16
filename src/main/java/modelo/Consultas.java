package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vista.formAltaPaciente;

public class Consultas extends conexionBDD {

    /* Alta Paciente */
    public boolean altaPaciente(Paciente paciente) throws SQLException {
        PreparedStatement pps;
        Connection con = conexion();
        String sql = "INSERT INTO paciente (nombres, apellido, documento, direccion, email, telefono_fijo, telefono_celular, departamento, codigo_postal, id_localidad) VALUES (?,?,?,?,?,?,?,?,?,?);";

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
            pps.setInt(10, paciente.getId_localidad());
            
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
    
    /* Alta Medico */
    public boolean altaMedico(Medico medico) throws SQLException {
        PreparedStatement pps;
        Connection con = conexion();
        String sql = "INSERT INTO medico (nombres, apellido, documento, direccion, email, telefono_fijo, telefono_celular, departamento, codigo_postal, id_localidad) VALUES (?,?,?,?,?,?,?,?,?,?);";

        try {
            pps = con.prepareStatement(sql);

            pps.setString(1, medico.getNombre());
            pps.setString(2, medico.getApellido());
            pps.setInt(3, medico.getDni());
            pps.setString(4, medico.getDireccion());
            pps.setString(5, medico.getEmail());
            pps.setString(6, medico.getTel_fijo());
            pps.setString(7, medico.getTel_cel());
            pps.setString(8, medico.getDepartamento());
            pps.setInt(9, medico.getCodigo_postal());
            pps.setInt(10, medico.getId_localidad());
            
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
    
    /* Cargar Combo Box Altas */
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
                frm.cob_localidad.addItem(rs.getString("id")+"-"+rs.getString("nombre"));
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

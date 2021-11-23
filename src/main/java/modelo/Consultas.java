package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vista.formAgregarEspecialidad;
import vista.formAltaMedico;
import vista.formAltaPaciente;


public class Consultas extends conexionBDD {

    /* INSERT paciente (alta) */
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
    
    /* INSERT medico (alta) */
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
    
    /* SELECT medico (buscar) */
    public boolean buscarMedico(Medico medico) throws SQLException{
        PreparedStatement pps;
        Connection con = conexion();
        ResultSet rs;
        String sql = "SELECT * FROM medico WHERE documento = ?;";

        try{
            pps = con.prepareStatement(sql);
            pps.setString(1, String.valueOf(medico.getDni()));
            rs = pps.executeQuery();
            if(rs.next()){
                medico.setId(Integer.parseInt(rs.getString("id_medico")));
                medico.setId_localidad(Integer.parseInt(rs.getString("id_localidad")));
                medico.setDni(Integer.parseInt(rs.getString("documento")));
                medico.setCodigo_postal(Integer.parseInt(rs.getString("codigo_postal")));
                medico.setNombre(rs.getString("nombres"));
                medico.setApellido(rs.getString("apellido"));
                medico.setEmail(rs.getString("email"));
                medico.setDireccion(rs.getString("direccion"));
                medico.setDepartamento(rs.getString("departamento"));
                medico.setTel_cel(rs.getString("telefono_celular"));
                medico.setTel_fijo(rs.getString("telefono_fijo"));
                return true;
            }
            return false;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    /* SELECT paciente (buscar) */
    public boolean buscarPaciente(Paciente paciente) throws SQLException{
        PreparedStatement pps;
        Connection con = conexion();
        ResultSet rs;
        String sql = "SELECT * FROM paciente WHERE documento = ?;";
        
        try{
            pps = con.prepareStatement(sql);
            pps.setString(1, String.valueOf(paciente.getDni()));
            rs = pps.executeQuery();
            if(rs.next()){
                paciente.setId(Integer.parseInt(rs.getString("id_medico")));
                paciente.setId_localidad(Integer.parseInt(rs.getString("id_localidad")));
                paciente.setDni(Integer.parseInt(rs.getString("documento")));
                paciente.setCodigo_postal(Integer.parseInt(rs.getString("codigo_postal")));
                paciente.setNombre(rs.getString("nombres"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setEmail(rs.getString("email"));
                paciente.setDireccion(rs.getString("direccion"));
                paciente.setDepartamento(rs.getString("departamento"));
                paciente.setTel_cel(rs.getString("telefono_celular"));
                paciente.setTel_fijo(rs.getString("telefono_fijo"));
                return true;
            }
            return false;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    /* INSERT relacion medico_especialidad (agregar especialidad) */
    public boolean agregarEspecialidad(int id_m, int id_e ) throws SQLException {
        PreparedStatement pps;
        Connection con = conexion();
        String sql = "INSERT INTO medico_especialidad (id_medico, id_especialidad) VALUES (?,?);";

        try {
            pps = con.prepareStatement(sql);

            pps.setInt(1, id_m);
            pps.setInt(2, id_e);
            
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
    
    /* cargar combo box localidad -> alta paciente */
    public boolean cargarComboBoxP(formAltaPaciente frm) throws SQLException {
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
    
    /* cargar combo box localidad -> alta medico */
    public boolean cargarComboBoxM(formAltaMedico frm) throws SQLException {
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
    
    /* cargar combo box especialidad */
    public boolean cargarComboBoxE(formAgregarEspecialidad frm) throws SQLException {
        PreparedStatement pps;
        ResultSet rs;
        Connection con = conexion();
        String sql = "SELECT * FROM especialidad";
        try {
            pps = con.prepareStatement(sql);
            rs = pps.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
                frm.cob_especialidades.addItem(rs.getString("id_especialidad")+"-"+rs.getString("nombre_especialidad"));
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

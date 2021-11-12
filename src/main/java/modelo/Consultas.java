package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Consultas extends conexionBDD{
    
    /* Paciente */
    public boolean altaPaciente(Paciente paciente) throws SQLException{
        PreparedStatement pps;
        Connection con = conexion();
        String sql = "INSERT INTO paciente (nombre, apellido, documento, id_direccion, email, telefono_fijo, telefono_celular) VALUES (?,?,?,?,?,?,?)";
        
        try{
            pps = con.prepareStatement(sql);
            
            pps.setString(1,paciente.getNombre());
            pps.setString(2,paciente.getApellido());
            pps.setInt(3,paciente.getDni());
            pps.setInt(4,paciente.getId_direccion());
            pps.setString(5,paciente.getEmail());
            pps.setString(6,paciente.getTel_fijo());
            pps.setString(7,paciente.getTel_cel());
            
            pps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    
    }
    
}

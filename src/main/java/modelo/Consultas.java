package modelo;

import java.sql.*;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Consultas extends conexionBDD {

    /* INSERT paciente (alta) */
    public boolean altaPaciente(Paciente paciente) throws SQLException {
        PreparedStatement pps;
        Connection con = conexion();
        String sql = "INSERT INTO paciente (nombres, apellido, documento, direccion, email, telefono_fijo, telefono_celular, departamento, codigo_postal, localidad) VALUES (?,?,?,?,?,?,?,?,?,?);";
        try {
            pps = con.prepareStatement(sql);
            pps.setString(1, paciente.getNombre());
            pps.setString(2, paciente.getApellido());
            pps.setLong(3, paciente.getDni());
            pps.setString(4, paciente.getDireccion());
            pps.setString(5, paciente.getEmail());
            pps.setString(6, paciente.getTel_fijo());
            pps.setString(7, paciente.getTel_cel());
            pps.setString(8, paciente.getDepartamento());
            pps.setInt(9, paciente.getCodigo_postal());
            pps.setInt(10, paciente.getLocalidad());
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
        String sql = "INSERT INTO medico (nombres, apellido, documento, direccion, email, telefono_fijo, telefono_celular, departamento, codigo_postal, localidad) VALUES (?,?,?,?,?,?,?,?,?,?);";
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
            pps.setInt(10, medico.getLocalidad());

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
    public boolean buscarMedico(Medico medico) throws SQLException {
        PreparedStatement pps;
        Connection con = conexion();
        ResultSet rs;
        String sql = "SELECT * FROM medico WHERE documento = ?;";

        try {
            pps = con.prepareStatement(sql);
            pps.setString(1, String.valueOf(medico.getDni()));
            rs = pps.executeQuery();
            if (rs.next()) {
                medico.setId(Integer.parseInt(rs.getString("id_medico")));
                medico.setLocalidad(Integer.parseInt(rs.getString("localidad")));
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

    /* SELECT paciente (buscar) */
    public boolean buscarPaciente(Paciente paciente) throws SQLException {
        PreparedStatement pps;
        Connection con = conexion();
        ResultSet rs;
        String sql = "SELECT * FROM paciente WHERE documento = ?;";

        try {
            pps = con.prepareStatement(sql);
            pps.setString(1, String.valueOf(paciente.getDni()));
            rs = pps.executeQuery();
            if (rs.next()) {
                paciente.setId(Integer.parseInt(rs.getString("id_paciente")));
                paciente.setLocalidad(Integer.parseInt(rs.getString("localidad")));
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

    /* UPDATE paciente (alta) */
    public boolean updatePaciente(Paciente paciente, int dni) throws SQLException {
        PreparedStatement pps;
        Connection con = conexion();
        String sql = "UPDATE paciente SET nombres=?, apellido=?, documento=?, direccion =?, email=?, telefono_fijo=?, telefono_celular=?, departamento=?, codigo_postal=?, localidad=? WHERE documento=?;";

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
            pps.setInt(10, paciente.getLocalidad());
            pps.setLong(11, dni);
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

    /* UPDATE MEDICO */
    public boolean updateMedico(Medico medico, int dni) throws SQLException {
        PreparedStatement pps;
        Connection con = conexion();
        String sql = "UPDATE medico SET nombres=?, apellido=?, documento=?, direccion =?, email=?, telefono_fijo=?, telefono_celular=?, departamento=?, codigo_postal=?, localidad=? WHERE documento=?;";

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
            pps.setInt(10, medico.getLocalidad());
            pps.setInt(11, dni);
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

    /* INSERT relacion medico_especialidad (agregar especialidad) */
    public boolean agregarEspecialidad(int id_m, int id_e) throws SQLException {
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
    /* Verificación de la especilidadad (duplicados) */
    public boolean verificarEspecialidad(int id_m, int id_e) throws SQLException {
        PreparedStatement pps;
        Connection con = conexion();
        String sql = "SELECT * FROM medico_especialidad WHERE id_medico=?;";
        ResultSet rs;
        try {
            pps = con.prepareStatement(sql);
            pps.setInt(1, id_m);
            rs = pps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("id_especialidad") + rs.getString("id_medico"));
                if (Integer.parseInt(rs.getString("id_especialidad")) == id_e) {
                    return false;
                }
            }

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
        return true;
    }
    /* Eliminación de la especialidad de cada medico */
    public boolean eliminarEspecialidad(int id_medicoCargado, int id_especialidadSeleccionada) throws SQLException {
        PreparedStatement pps;
        Connection con = conexion();
        String sql = "DELETE FROM medico_especialidad WHERE id_medico=? AND id_especialidad=?;";
        if(id_especialidadSeleccionada == 0){
            
        }
        try {
            pps = con.prepareStatement(sql);
            pps.setInt(1, id_medicoCargado);
            pps.setInt(2, id_especialidadSeleccionada);
            pps.execute();

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
        return true;
    }

    /* Cargar combo box especialidad */
    public boolean cargarComboBoxE(JComboBox cob_especialidades) throws SQLException {
        PreparedStatement pps;
        ResultSet rs;
        Connection con = conexion();
        String sql = "SELECT * FROM especialidad";
        try {
            pps = con.prepareStatement(sql);
            rs = pps.executeQuery();
            while (rs.next()) {
                cob_especialidades.addItem(rs.getString("id") + "-" + rs.getString("nombre_especialidad"));
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
    
    /* Cargar la lista de especialidades para el medico seleccionado */
    public boolean ListaEspecialidades(DefaultListModel list_especialidades, Medico medico) throws SQLException {

        PreparedStatement pps;
        Connection con = conexion();
        ResultSet rs;
        String sql = "SELECT especialidad.nombre_especialidad FROM medico_especialidad INNER JOIN especialidad ON medico_especialidad.id_especialidad = id WHERE medico_especialidad.id_medico = ?";
        try {
            pps = con.prepareStatement(sql);
            pps.setInt(1, medico.getId());
            rs = pps.executeQuery();
            while (rs.next()) {
                list_especialidades.addElement(rs.getString("nombre_especialidad"));
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
    
    /* Cargar la tabla de medicos o pacientes para ver los registros */
    public void cargarTabla(JTable tabla, String variable) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion();
        String sql = null;
        
        if (variable == "Paciente") {
            sql = "SELECT id_paciente, nombres, apellido, documento, direccion, email, telefono_fijo, telefono_celular FROM paciente ";
        } else if (variable == "Medico") {
            sql = "SELECT id_medico, nombres, apellido, documento, direccion, email, telefono_fijo, telefono_celular FROM medico ";
        }

        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        ResultSetMetaData rsMD = rs.getMetaData();
        int cantidadColumnas = rsMD.getColumnCount();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Documento");
        modelo.addColumn("Direccion");
        modelo.addColumn("Email");
        modelo.addColumn("Tel Fijo");
        modelo.addColumn("Tel Celular");

        while (rs.next()) {
            Object[] filas = new Object[cantidadColumnas];
            for (int i = 0; i < cantidadColumnas; i++) {
                filas[i] = rs.getObject(i + 1);
            }
            modelo.addRow(filas);
        }
    }
    /* Elimina el registro de la tabla anteriormente cargada seleccionado */
    public void eliminarRegistroTabla(JTable tabla, String variable) throws SQLException {
        PreparedStatement pps = null;
        Connection con = conexion();
        String sql = null;
        int Fila = tabla.getSelectedRow();
        int id = (int) tabla.getValueAt(Fila, 0);
        if (variable == "Paciente") {
            sql = "DELETE FROM paciente WHERE id_paciente=?";
        } else if (variable == "Medico") {
            sql = "DELETE FROM medico WHERE id_medico=?";
        }
        pps = con.prepareStatement(sql);
        pps.setInt(1, id);
        pps.execute();

    }
    /**
     * ************************************
     */
    /**
     * *************** OLD ****************
     */
    /**
     * ************************************
     */
    /*
    cargar combo box localidad paciente
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
    
    cargar combobox localidad medico
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
    
     */
}

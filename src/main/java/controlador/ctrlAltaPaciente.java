package controlador;
import vista.formAltaPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Consultas;
import modelo.Paciente;





public class ctrlAltaPaciente implements ActionListener {
    
    private Paciente paciente;
    private formAltaPaciente frm;
    private Consultas consulta;

    public ctrlAltaPaciente(Paciente paciente, formAltaPaciente frm, Consultas consulta) {
        this.paciente = paciente;
        this.frm = frm;
        this.consulta = consulta;
        this.frm.bt_alta.addActionListener(this);
        this.frm.bt_vaciar.addActionListener(this);
        this.frm.bt_atras.addActionListener(this);
    }

    
    public void iniciar(){
        frm.setTitle("Alta Paciente");
        frm.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        /* Alta Paciente */
        if(e.getSource() == frm.bt_alta){
            paciente.setNombre(frm.txt_nombre.getText());
            paciente.setApellido(frm.txt_apellido.getText());
            paciente.setDni(Integer.parseInt(frm.txt_dni.getText()));
            paciente.setDireccion(frm.txt_direccion.getText());
            paciente.setEmail(frm.txt_email.getText());
            paciente.setCodigo_postal(Integer.parseInt(frm.txt_cp.getText()));
            paciente.setTel_fijo(frm.txt_tf.getText());
            paciente.setTel_cel(frm.txt_tc.getText());
            String[] localidades= frm.cob_localidad.getItemAt(frm.cob_localidad.getSelectedIndex()).split("-");
            System.out.println(localidades[0]);
            paciente.setId_localidad(Integer.parseInt(localidades[0]));
            if(frm.chb_edificio.isSelected()){
                paciente.setDepartamento(frm.txt_depa.getText());
            }else{
                paciente.setDepartamento("");
            }
            try {
                if(consulta.altaPaciente(paciente)){
                    JOptionPane.showMessageDialog(null, "Registro guardado.");
                    limpiar();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar.");
                limpiar();
                Logger.getLogger(ctrlAltaPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Limpiar
        if(e.getSource() == frm.bt_vaciar){
            limpiar();
        }
    }
    
    private void limpiar(){
        frm.txt_nombre.setText(null);
        frm.txt_apellido.setText(null);
        frm.txt_dni.setText(null);
        frm.txt_direccion.setText(null);
        frm.txt_cp.setText(null);
        frm.txt_email.setText(null);
        frm.txt_tf.setText(null);
        frm.txt_tc.setText(null);
    }

}

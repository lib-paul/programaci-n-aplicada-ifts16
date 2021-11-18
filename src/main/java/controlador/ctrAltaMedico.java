package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Consultas;
import modelo.Medico;
import vista.formAltaMedico;


public class ctrAltaMedico implements ActionListener{
        
    private Medico medico;
    private formAltaMedico frm;
    private Consultas consulta;

    public ctrAltaMedico(Medico medico, formAltaMedico frm, Consultas consulta) {
        this.medico = medico;
        this.frm = frm;
        this.consulta = consulta;
        this.frm.bt_alta.addActionListener(this);
        this.frm.bt_vaciar.addActionListener(this);
        this.frm.bt_atras.addActionListener(this);
    }
    
    public void iniciar(){
        frm.setTitle("Alta Medico");
        frm.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        /* Alta Medico */
        if(e.getSource() == frm.bt_alta){
            medico.setNombre(frm.txt_nombre.getText());
            medico.setApellido(frm.txt_apellido.getText());
            medico.setDni(Integer.parseInt(frm.txt_dni.getText()));
            medico.setDireccion(frm.txt_direccion.getText());
            medico.setEmail(frm.txt_email.getText());
            medico.setCodigo_postal(Integer.parseInt(frm.txt_cp.getText()));
            medico.setTel_fijo(frm.txt_tf.getText());
            medico.setTel_cel(frm.txt_tc.getText());
            String[] localidades= frm.cob_localidad.getItemAt(frm.cob_localidad.getSelectedIndex()).split("-");
            System.out.println(localidades[0]);
            medico.setId_localidad(Integer.parseInt(localidades[0]));
            if(frm.chb_edificio.isSelected()){
                medico.setDepartamento(frm.txt_depa.getText());
            }else{
                medico.setDepartamento("");
            }
            try {
                if(consulta.altaMedico(medico)){
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

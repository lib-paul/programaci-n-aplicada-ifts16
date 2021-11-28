package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Consultas;
import modelo.Medico;
import vista.formAgregarEspecialidad;
import vista.formMod;


public class ctrAgregarEspecialidad implements ActionListener {
    
    /* atributos */
    private Medico medico;
    private formAgregarEspecialidad frm;
    private Consultas consulta;
    
    /* constructor */
    public ctrAgregarEspecialidad(formAgregarEspecialidad frm, Consultas consulta, Medico medico){
        this.frm = frm;
        this.consulta = consulta;
        this.medico = medico;
        this.frm.bt_agregar.addActionListener(this);
        this.frm.bt_eliminar.addActionListener(this);
        this.frm.bt_atras.addActionListener(this);
    }
    
    /* iniciador */
    public void iniciar(){
        frm.setTitle("Agregar Especialidad");
        frm.setLocationRelativeTo(null);
    }
    
    
    /* controlador de agregar especialidad */
    @Override
    public void actionPerformed(ActionEvent e){
        
        
        /* si se apreta el boton de "agregar" */
        if(e.getSource() == frm.bt_agregar){
            String [] especialidad = frm.cob_especialidades.getSelectedItem().toString().split("-");
            int id_especialidad = Integer.parseInt(especialidad[0]);
            int id_medico = medico.getId();
            try {
                consulta.agregarEspecialidad(id_medico, id_especialidad);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
        }
        /* si se apreta el boton de "eliminar" */
        if(e.getSource() == frm.bt_eliminar){
            
        }
        /* si se apreta el boton de "atras" */
        if(e.getSource() == frm.bt_atras){
            frm.setVisible(false);
            frm.dispose();
        }
    }
 
}

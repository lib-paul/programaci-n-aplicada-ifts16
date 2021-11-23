package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Consultas;
import vista.formAgregarEspecialidad;


public class ctrAgregarEspecialidad implements ActionListener {
    
    /* atributos */
    private formAgregarEspecialidad frm;
    private Consultas consulta;
    
    /* constructor */
    public ctrAgregarEspecialidad(formAgregarEspecialidad frm, Consultas consulta) {
        this.frm = frm;
        this.consulta = consulta;
        this.frm.bt_atras.addActionListener(this);
        this.frm.bt_guardar.addActionListener(this);
    }
    
    /* iniciador */
    public void iniciar(){
        frm.setTitle("Agregar Especialidad");
        frm.setLocationRelativeTo(null);
    }
    
    /* controlador de agregar especialidad */
    @Override
    public void actionPerformed(ActionEvent e){
        /* si se apreta el boton "alta" */
        if(e.getSource() == frm.bt_guardar){
            String [] especialidad = frm.cob_especialidades.getItemAt(frm.cob_especialidades.getSelectedIndex()).split("-");
            int id_especialidad = Integer.parseInt(especialidad[0]);
            int id_medico = 3;
            try{
                if(consulta.agregarEspecialidad(id_medico, id_especialidad)){
                    JOptionPane.showMessageDialog(null, "Especialidad registrada con exito.");
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error al registrar especialidad.");
            }
        }
    }
 
}

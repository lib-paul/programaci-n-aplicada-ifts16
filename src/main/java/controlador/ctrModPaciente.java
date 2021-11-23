package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Consultas;
import modelo.Paciente;
import vista.formModPaciente;


public class ctrModPaciente implements ActionListener{
        
    /* atributos */
    private Paciente mod;
    private formModPaciente frm;
    private Consultas consulta;
    
    /* constructor */
    public ctrModPaciente(Paciente mod, formModPaciente frm, Consultas consulta) {
        this.mod = mod;
        this.frm = frm;
        this.consulta = consulta;
        this.frm.bt_guardar.addActionListener(this);
        this.frm.bt_atras.addActionListener(this);
        this.frm.bt_buscar.addActionListener(this);
    }
    
    /* iniciador */
    public void iniciar(){
        frm.setTitle("Modificar Paciente");
        frm.setLocationRelativeTo(null);
    }
    
    /* controlador de mod paciente */
    @Override
    public void actionPerformed(ActionEvent e){
        
        /* boton busqueda */
        if(e.getSource() == frm.bt_buscar){
            mod.setDni(Integer.parseInt(frm.txt_buscar_dni.getText()));
            try {
                if(consulta.buscarPaciente(mod)){
                    
                    frm.txt_nombre.setText(mod.getNombre());
                    frm.txt_apellido.setText(mod.getApellido());
                    frm.txt_dni.setText(String.valueOf(mod.getDni()));
                    //frm.cob_localidad
                    frm.txt_direccion.setText(mod.getDireccion());
                    frm.txt_depa.setText(mod.getDepartamento());
                    frm.txt_cp.setText(String.valueOf(mod.getCodigo_postal()));
                    frm.txt_email.setText(mod.getEmail());
                    frm.txt_tf.setText(mod.getTel_fijo());
                    frm.txt_tc.setText(mod.getTel_cel());

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se encontró el resultado.");
            }
        }
    }
}
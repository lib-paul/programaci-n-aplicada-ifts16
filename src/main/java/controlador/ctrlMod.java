package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Consultas;
import modelo.Medico;
import modelo.Paciente;
import vista.formAgregarEspecialidad;
import vista.formMod;

public class ctrlMod implements ActionListener {

    /* atributos */
    private Medico medico;
    private Paciente paciente;
    private formMod frm;
    private Consultas consulta;

    /* constructor */
    public ctrlMod(Medico medico, Paciente paciente, formMod frm, Consultas consulta) {
        this.medico = medico;
        this.paciente = paciente;
        this.frm = frm;
        this.consulta = consulta;
        this.frm.bt_agregar_especialidad.addActionListener(this);
        this.frm.bt_guardar.addActionListener(this);
        this.frm.bt_atras.addActionListener(this);
        this.frm.bt_buscar.addActionListener(this);
        this.frm.persona_medico.addActionListener(this);
    }

    /* iniciador */
    public void iniciar() {
        frm.setTitle("Modificar");
        frm.setLocationRelativeTo(null);
        frm.jLabel8.setVisible(false);
        frm.bt_agregar_especialidad.setVisible(false);
    }

    /* controlador de mod paciente */
    @Override
    public void actionPerformed(ActionEvent e) throws NumberFormatException {
        if ("Paciente".equals(frm.persona_medico.getItemAt(frm.persona_medico.getSelectedIndex()))) {
            frm.jLabel8.setVisible(false);
            frm.bt_agregar_especialidad.setVisible(false);
            /*-------BUSCAR PACIENTE-------*/
            if (e.getSource() == frm.bt_buscar) {

                try {
                    paciente.setDni(Integer.parseInt(frm.txt_buscar_dni.getText()));
                } catch (NumberFormatException b) {
                    System.out.println("NUMERO GRANDE");
                }

                try {
                    if (consulta.buscarPaciente(paciente)) {
                        if (paciente.getDepartamento() != null) {
                            frm.chb_edificio.setSelected(true);
                            frm.txt_depa.setEnabled(true);
                        }
                        frm.txt_nombre.setText(paciente.getNombre());
                        frm.txt_apellido.setText(paciente.getApellido());
                        frm.txt_dni.setText(String.valueOf(paciente.getDni()));
                        frm.cob_localidad.setSelectedIndex(paciente.getLocalidad());
                        frm.txt_direccion.setText(paciente.getDireccion());
                        frm.txt_depa.setText(paciente.getDepartamento());
                        frm.txt_cp.setText(String.valueOf(paciente.getCodigo_postal()));
                        frm.txt_email.setText(paciente.getEmail());
                        frm.txt_tf.setText(paciente.getTel_fijo());
                        frm.txt_tc.setText(paciente.getTel_cel());

                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "No se encontró el resultado.");
                }
            }

            /*--------GUARDAR PACIENTE----------*/
            if (e.getSource() == frm.bt_guardar) {
                try {
                    int dni_viejo = paciente.getDni();
                    paciente.setNombre(frm.txt_nombre.getText());
                    paciente.setApellido(frm.txt_apellido.getText());
                    paciente.setDni(Integer.parseInt(frm.txt_dni.getText()));
                    paciente.setDireccion(frm.txt_direccion.getText());
                    paciente.setEmail(frm.txt_email.getText());
                    paciente.setCodigo_postal(Integer.parseInt(frm.txt_cp.getText()));
                    paciente.setTel_fijo(frm.txt_tf.getText());
                    paciente.setTel_cel(frm.txt_tc.getText());
                    paciente.setLocalidad(frm.cob_localidad.getSelectedIndex());
                    if (frm.chb_edificio.isSelected()) {
                        paciente.setDepartamento(frm.txt_depa.getText());
                    } else {
                        //paciente.setDepartamento(""); NO HACE FALTA
                    }
                    if (consulta.updatePaciente(paciente, dni_viejo)) {
                        JOptionPane.showMessageDialog(null, "Registro guardado.");
                        limpiar();
                    }
                } catch (NumberFormatException n) {
                    System.out.println("Error formato de datos");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar.");
                    limpiar();
                    Logger.getLogger(ctrlMod.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if ("Medico".equals(frm.persona_medico.getItemAt(frm.persona_medico.getSelectedIndex()))) {
            frm.jLabel8.setVisible(true);
            frm.bt_agregar_especialidad.setVisible(true);
            /*-----------BUSCAR MEDICO-------------*/
            if (e.getSource() == frm.bt_buscar) {
                medico.setDni(Integer.parseInt(frm.txt_buscar_dni.getText()));
                try {
                    if (consulta.buscarMedico(medico)) {
                        if (medico.getDepartamento() != null) {
                            frm.chb_edificio.setSelected(true);
                            frm.txt_depa.setEnabled(true);
                        }

                        frm.txt_nombre.setText(medico.getNombre());
                        frm.txt_apellido.setText(medico.getApellido());
                        frm.txt_dni.setText(String.valueOf(medico.getDni()));
                        frm.cob_localidad.setSelectedIndex(medico.getLocalidad());
                        frm.txt_direccion.setText(medico.getDireccion());
                        frm.txt_depa.setText(medico.getDepartamento());
                        frm.txt_cp.setText(String.valueOf(medico.getCodigo_postal()));
                        frm.txt_email.setText(medico.getEmail());
                        frm.txt_tf.setText(medico.getTel_fijo());
                        frm.txt_tc.setText(medico.getTel_cel());

                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "No se encontró el resultado.");
                }
            }

            /*--------GUARDAR MEDICO----------*/
            if (e.getSource() == frm.bt_guardar) {
                medico.setNombre(frm.txt_nombre.getText());
                medico.setApellido(frm.txt_apellido.getText());
                medico.setDni(Integer.parseInt(frm.txt_dni.getText()));
                medico.setDireccion(frm.txt_direccion.getText());
                medico.setEmail(frm.txt_email.getText());
                medico.setCodigo_postal(Integer.parseInt(frm.txt_cp.getText()));
                medico.setTel_fijo(frm.txt_tf.getText());
                medico.setTel_cel(frm.txt_tc.getText());
                medico.setLocalidad(frm.cob_localidad.getSelectedIndex());
                if (frm.chb_edificio.isSelected()) {
                    medico.setDepartamento(frm.txt_depa.getText());
                } else {
                    //medico.setDepartamento(""); NO HACE FALTA
                }
                try {
                    if (consulta.updateMedico(medico, medico.getDni()) /*&& consulta.agregarEspecialidad(id medico, id especialidad )*/) {
                        JOptionPane.showMessageDialog(null, "Registro guardado.");
                        limpiar();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar.");
                    limpiar();
                    Logger.getLogger(ctrlAltas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            /*--------AGREGAR ESPECIALIDAD MEDICO----------*/
            if(e.getSource() == frm.bt_agregar_especialidad){
                formAgregarEspecialidad form = new formAgregarEspecialidad();
                /*#####Carga Lista######*/
                DefaultListModel dlm = new DefaultListModel();
                try {
                    consulta.ListaEspecialidades(dlm, medico);
                } catch (SQLException ex) {
                    Logger.getLogger(ctrlMod.class.getName()).log(Level.SEVERE, null, ex);
                }
                form.list_especialidades.setModel(dlm);
                ctrAgregarEspecialidad controlador = new ctrAgregarEspecialidad(form, consulta, medico);
                try {
                    consulta.cargarComboBoxE(form.cob_especialidades);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                controlador.iniciar();
                form.setVisible(true);
            }

        } else {
            if (e.getSource() == frm.bt_buscar) {
                JOptionPane.showMessageDialog(null, "Seleccione primero Paciente/Medico");
            }
        }
    }

    /* metodo para vaciar los txt field del formulario de alta paciente */
    private void limpiar() {
        frm.txt_nombre.setText(null);
        frm.txt_apellido.setText(null);
        frm.txt_dni.setText(null);
        frm.txt_direccion.setText(null);
        frm.cob_localidad.setSelectedIndex(0);
        frm.persona_medico.setSelectedIndex(0);
        frm.txt_cp.setText(null);
        frm.txt_email.setText(null);
        frm.txt_tf.setText(null);
        frm.txt_tc.setText(null);
    }

}

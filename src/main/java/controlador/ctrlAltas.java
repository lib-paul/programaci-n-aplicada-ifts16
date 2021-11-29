package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.formAlta;
import modelo.*;

public class ctrlAltas implements ActionListener {

    /* atributos */
    private Medico medico;
    private Paciente paciente;
    private formAlta frm;
    private Consultas consulta;

    /* constructor */
    public ctrlAltas(Medico medico, Paciente paciente, formAlta frm, Consultas consulta) {
        this.medico = medico;
        this.paciente = paciente;
        this.frm = frm;
        this.consulta = consulta;
        this.frm.bt_alta.addActionListener(this);
        this.frm.bt_vaciar.addActionListener(this);
        this.frm.bt_atras.addActionListener(this);
        this.frm.persona_medico.addActionListener(this);
    }

    /* iniciador */
    public void iniciar() {
        frm.setTitle("Alta");
        frm.setLocationRelativeTo(null);
    }

    /* controlador de altas paciente/medico*/
    @Override
    public void actionPerformed(ActionEvent e) {
        /* SI ES PACIENTE ENTONCES = */
        if ("Paciente".equals(frm.persona_medico.getItemAt(frm.persona_medico.getSelectedIndex()))) {
            System.out.println("Elegiste paciente");
            if (e.getSource() == frm.bt_alta) {
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
                try {
                    if (consulta.altaPaciente(paciente)) {
                        JOptionPane.showMessageDialog(null, "Registro guardado.");
                        limpiar();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar.");
                    limpiar();
                    Logger.getLogger(ctrlAltas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }/* SI ES MEDICO ENTONCES = */ else if ("Medico".equals(frm.persona_medico.getItemAt(frm.persona_medico.getSelectedIndex()))) {
            System.out.println("Elegiste medico");
            if (e.getSource() == frm.bt_alta) {
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
                    if (consulta.altaMedico(medico) /*&& consulta.agregarEspecialidad(id medico, id especialidad )*/) {
                        JOptionPane.showMessageDialog(null, "Registro guardado.");
                        limpiar();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar.");
                    limpiar();
                    Logger.getLogger(ctrlAltas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {/* SI NO SELECCIONA ENTONCES = */
            if (e.getSource() == frm.bt_alta) {
                JOptionPane.showMessageDialog(null, "Seleccione si cargar Paciente/Medico.");
            }
        }

        //Limpiar
        if (e.getSource() == frm.bt_vaciar) {
            limpiar();
        }
    }

    /* metodo para vaciar los txt field del formulario de alta paciente */
    private void limpiar() {
        frm.txt_nombre.setText(null);
        frm.txt_apellido.setText(null);
        frm.txt_dni.setText(null);
        frm.txt_direccion.setText(null);
        frm.cob_especialidad.setSelectedIndex(0);
        frm.cob_localidad.setSelectedIndex(0);
        frm.persona_medico.setSelectedIndex(0);
        frm.txt_cp.setText(null);
        frm.txt_email.setText(null);
        frm.txt_tf.setText(null);
        frm.txt_tc.setText(null);
    }

}
